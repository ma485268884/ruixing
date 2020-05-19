package com.yintu.ruixing.service.rbac.impl;

import com.yintu.ruixing.dao.rbac.UserDao;
import com.yintu.ruixing.dao.rbac.UserRoleDao;
import com.yintu.ruixing.entity.rbac.UserEntity;
import com.yintu.ruixing.service.rbac.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //UserEntity userEntity = userDao.loadUserByUsername(username);
        UserEntity userEntity = new UserEntity();
        if (userEntity == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        ///userEntity.setRoles(userDao.getHrRolesById(hr.getId()));
        return userEntity;
    }
}
