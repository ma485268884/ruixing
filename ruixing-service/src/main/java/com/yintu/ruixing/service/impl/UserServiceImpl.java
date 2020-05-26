package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.common.exception.BaseRuntimeException;
import com.yintu.ruixing.dao.UserDao;
import com.yintu.ruixing.entity.*;
import com.yintu.ruixing.service.RoleService;
import com.yintu.ruixing.service.UserRoleService;
import com.yintu.ruixing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleService userRoleService;

    @Override
    public void add(UserEntity userEntity) {
        UserEntityExample userEntityExample = new UserEntityExample();
        UserEntityExample.Criteria criteria = userEntityExample.createCriteria();
        criteria.andUsernameEqualTo(userEntity.getUsername());
        List<UserEntity> userEntities = this.findByExample(userEntityExample);
        if (userEntities.size() > 0) {
            throw new BaseRuntimeException("添加失败，用户名重复");
        }
        userEntity.setLocked((short) 0);
        userEntity.setCreateTime(new Date());
        String password = userEntity.getPassword();
        if (password != null && !password.isEmpty()) {
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            userEntity.setPassword(passwordEncoder.encode(password));
        }
        userDao.insertSelective(userEntity);

    }

    @Override
    public void edit(UserEntity userEntity) {
        UserEntityExample userEntityExample = new UserEntityExample();
        UserEntityExample.Criteria criteria = userEntityExample.createCriteria();
        criteria.andUsernameEqualTo(userEntity.getUsername());
        List<UserEntity> userEntities = this.findByExample(userEntityExample);
        if (userEntities.size() > 0 && !userEntities.get(0).getId().equals(userEntity.getId())) {
            throw new BaseRuntimeException("修改失败，用户名重复");
        }
        String password = userEntity.getPassword();
        if (password != null && !password.isEmpty()) {
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            userEntity.setPassword(passwordEncoder.encode(password));
        }
        userDao.updateByPrimaryKeySelective(userEntity);
    }

    @Override
    public void remove(Long id) {
        userDao.deleteByPrimaryKey(id);
    }

    @Override
    public UserEntity findById(Long id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public List<UserEntity> findAll() {
        UserEntityExample userEntityExample = new UserEntityExample();
        return userDao.selectByExample(userEntityExample);
    }

    @Override
    public List<UserEntity> findByExample(UserEntityExample userEntityExample) {
        return userDao.selectByExample(userEntityExample);
    }

    @Override
    public List<UserEntity> findAllOrByUsername(String username) {
        List<UserEntity> userEntities;
        if (username == null || "".equals(username)) {
            userEntities = this.findAll();
        } else {
            UserEntityExample userEntityExample = new UserEntityExample();
            UserEntityExample.Criteria criteria = userEntityExample.createCriteria();
            criteria.andUsernameLike("%" + username + "%");
            userEntities = this.findByExample(userEntityExample);
        }
        return userEntities;
    }


    /**
     * 按照用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户信息
     * @throws UsernameNotFoundException 用户未找到异常
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntityExample userEntityExample = new UserEntityExample();
        UserEntityExample.Criteria criteria = userEntityExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<UserEntity> userEntities = userDao.selectByExample(userEntityExample);
        if (userEntities.size() == 0) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        UserEntity userEntity = userEntities.get(0);
        userEntity.setRoleEntitys(roleService.findByUserId(userEntity.getId()));
        return userEntity;
    }

    @Override
    public List<RoleEntity> findRolesById(Long id) {
        return roleService.findByUserId(id);
    }

    @Override
    public void addRolesByIdAndRoleIds(Long id, Long[] roleIds) {
        //去重
        Set<Long> set = new HashSet<>(Arrays.asList(roleIds));

        UserEntity userEntity = this.findById(id);
        if (userEntity != null) {//判断当前用户是否存在
            //查询当前用户分配的角色
            UserRoleEntityExample userRoleEntityExample = new UserRoleEntityExample();
            UserRoleEntityExample.Criteria criteria = userRoleEntityExample.createCriteria();
            criteria.andUserIdEqualTo(id);
            List<UserRoleEntity> userRoleEntities = userRoleService.findByExample(userRoleEntityExample);

            //删除当前用户分配的角色
            if (userRoleEntities.size() > 0) {
                List<Long> longs = new ArrayList<>();
                for (UserRoleEntity userRoleEntity : userRoleEntities) {
                    longs.add(userRoleEntity.getRoleId());
                }
                criteria.andRoleIdIn(longs);
                userRoleService.removeByExample(userRoleEntityExample);
            }

            //添加当前用户新分配分配的角色
            for (Long roleId : set) {
                RoleEntity roleEntity = roleService.findById(roleId);
                if (roleEntity != null) {
                    UserRoleEntity userRoleEntity = new UserRoleEntity();
                    userRoleEntity.setUserId(id);
                    userRoleEntity.setRoleId(roleId);
                    userRoleService.add(userRoleEntity);
                }
            }
        }
    }
}
