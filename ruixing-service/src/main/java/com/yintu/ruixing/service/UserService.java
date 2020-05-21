package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    /**
     * 添加用户
     *
     * @param userEntity 用户信息
     */
    void add(UserEntity userEntity);

    /**
     * 修改用户
     *
     * @param userEntity 用户信息
     */
    void edit(UserEntity userEntity);

    /**
     * 删除用户
     *
     * @param id
     */
    void remove(Long id);

    /**
     * 按照id查询用户
     *
     * @param id 用户id
     * @return 用户信息
     */
    UserEntity findById(Long id);

    /**
     * 查询所有用户
     *
     * @return 用户信息
     */
    List<UserEntity> findAll();
}
