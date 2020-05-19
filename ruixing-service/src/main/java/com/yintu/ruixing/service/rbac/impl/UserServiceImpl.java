package com.yintu.ruixing.service.rbac.impl;

import com.yintu.ruixing.dao.rbac.UserDao;
import com.yintu.ruixing.dao.rbac.UserRoleDao;
import com.yintu.ruixing.entity.rbac.UserEntity;
import com.yintu.ruixing.entity.rbac.UserEntityExample;
import com.yintu.ruixing.service.rbac.UserRoleService;
import com.yintu.ruixing.service.rbac.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRoleService userRoleServicel;

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
        UserEntity userEntity = userDao.selectByExample(userEntityExample).get(0);
        if (userEntity == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        userEntity.setRoleEntitys(userRoleServicel.findByUserId(userEntity.getId()));
        return userEntity;
    }

}
