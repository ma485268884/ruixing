package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.common.exception.BaseRuntimeException;
import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.dao.UserDao;
import com.yintu.ruixing.entity.*;
import com.yintu.ruixing.service.*;
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
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private PermissionRoleService permissionRoleService;

    @Override
    public void add(UserEntity userEntity) {
        UserEntityExample userEntityExample = new UserEntityExample();
        UserEntityExample.Criteria criteria = userEntityExample.createCriteria();
        if (Short.valueOf((short) 1).equals(userEntity.getIsCustomer())) {
            criteria.andIsCustomerEqualTo((short) 1);
        } else {
            criteria.andIsCustomerEqualTo((short) 0);
        }
        criteria.andUsernameEqualTo(userEntity.getUsername());
        List<UserEntity> userEntities = this.findByExample(userEntityExample);
        if (userEntities.size() > 0) {
            throw new BaseRuntimeException("添加失败，用户名重复");
        }
        Short authType = userEntity.getAuthType();
        userEntity.setAuthType(authType == null ? (short) 0 : authType);
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
        if (Short.valueOf((short) 1).equals(userEntity.getIsCustomer())) {
            criteria.andIsCustomerEqualTo((short) 1);
        } else {
            criteria.andIsCustomerEqualTo((short) 0);
        }
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
    public List<UserEntity> findAll(Short isCustermer) {
        UserEntityExample userEntityExample = new UserEntityExample();
        UserEntityExample.Criteria criteria = userEntityExample.createCriteria();
        criteria.andIsCustomerEqualTo(isCustermer);
        return userDao.selectByExample(userEntityExample);
    }

    @Override
    public List<UserEntity> findByExample(UserEntityExample userEntityExample) {
        return userDao.selectByExample(userEntityExample);
    }

    @Override
    public List<UserEntity> findAllOrByUsername(String username, Short isCustermer) {
        List<UserEntity> userEntities;
        if (username == null || "".equals(username)) {
            userEntities = this.findAll(isCustermer);
        } else {
            UserEntityExample userEntityExample = new UserEntityExample();
            UserEntityExample.Criteria criteria = userEntityExample.createCriteria();
            criteria.andIsCustomerEqualTo(isCustermer);
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


    @Override
    public List<TreeNodeUtil> findPermissionById(Long id, Long parentId, Short isMemu) {
        List<PermissionEntity> permissionEntities = userDao.selectPermissionById(id, parentId, isMemu);
        List<TreeNodeUtil> treeNodeUtils = new ArrayList<>();
        for (PermissionEntity permissionEntity : permissionEntities) {
            TreeNodeUtil treeNodeUtil = new TreeNodeUtil();
            treeNodeUtil.setId(permissionEntity.getId());
            treeNodeUtil.setLabel(permissionEntity.getName());
            treeNodeUtil.setIcon(permissionEntity.getIconCls());
            treeNodeUtil.setChildren(this.findPermissionById(id, permissionEntity.getId(), isMemu));
            Map<String, Object> map = new HashMap<>();
            map.put("parentId", permissionEntity.getParentId());
            map.put("url", permissionEntity.getUrl());
            map.put("method", permissionEntity.getMethod());
            map.put("isMenu", permissionEntity.getIsMenu());
            map.put("path", permissionEntity.getPath());
            map.put("description", permissionEntity.getDescription());
            map.put("roleEntities", permissionEntity.getRoleEntities());
            treeNodeUtil.setA_attr(map);
            treeNodeUtils.add(treeNodeUtil);
        }
        return treeNodeUtils;
    }

    @Override
    public List<TreeNodeUtil> findPermission(Long parentId, Short isMemu) {
        List<PermissionEntity> permissionEntities = userDao.selectPermission(parentId, isMemu);
        List<TreeNodeUtil> treeNodeUtils = new ArrayList<>();
        for (PermissionEntity permissionEntity : permissionEntities) {
            TreeNodeUtil treeNodeUtil = new TreeNodeUtil();
            treeNodeUtil.setId(permissionEntity.getId());
            treeNodeUtil.setLabel(permissionEntity.getName());
            treeNodeUtil.setIcon(permissionEntity.getIconCls());
            treeNodeUtil.setChildren(this.findPermission(permissionEntity.getId(), isMemu));
            Map<String, Object> map = new HashMap<>();
            map.put("parentId", permissionEntity.getParentId());
            map.put("url", permissionEntity.getUrl());
            map.put("method", permissionEntity.getMethod());
            map.put("isMenu", permissionEntity.getIsMenu());
            map.put("path", permissionEntity.getPath());
            map.put("description", permissionEntity.getDescription());
            map.put("roleEntities", permissionEntity.getRoleEntities());
            treeNodeUtil.setA_attr(map);
            treeNodeUtils.add(treeNodeUtil);
        }
        return treeNodeUtils;
    }
}
