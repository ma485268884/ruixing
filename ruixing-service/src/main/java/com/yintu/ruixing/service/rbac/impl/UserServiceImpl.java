package com.yintu.ruixing.service.rbac.impl;

import com.yintu.ruixing.dao.rbac.UserDao;
import com.yintu.ruixing.entity.rbac.UserEntity;
import com.yintu.ruixing.entity.rbac.UserEntityExample;
import com.yintu.ruixing.service.rbac.RoleService;
import com.yintu.ruixing.service.rbac.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleService roleService;

    @Override
    public void add(UserEntity userEntity) {
        userEntity.setLocked((short) 0);
        userEntity.setEnabled((short) 1);
        userEntity.setLoginTime(new Date());
        String password = userEntity.getPassword();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userEntity.setPassword(passwordEncoder.encode(password));
        userDao.insertSelective(userEntity);
    }

    @Override
    public void edit(UserEntity userEntity) {
        String password = userEntity.getPassword();
        if (!password.isEmpty()) {
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
        return null;
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


}
