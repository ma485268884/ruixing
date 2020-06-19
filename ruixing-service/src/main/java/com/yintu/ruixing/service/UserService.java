package com.yintu.ruixing.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.entity.PermissionEntity;
import com.yintu.ruixing.entity.RoleEntity;
import com.yintu.ruixing.entity.UserEntity;
import com.yintu.ruixing.entity.UserEntityExample;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;

public interface UserService extends UserDetailsService {

    /**
     * T
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
    List<UserEntity> findAll(Short isCustermer);

    /**
     * 通过条件查询用户
     *
     * @param userEntityExample 条件封装类
     * @return 用户信息集
     */
    List<UserEntity> findByExample(UserEntityExample userEntityExample);

    /**
     * 查询全部用户或者按照用户名查询
     *
     * @param username 用户名
     * @return 用户列表信息
     */
    List<UserEntity> findAllOrByUsername(String username, Short isCustermer);

    /**
     * 通过用户id查询角色
     *
     * @param id 用户id
     * @return 角色信息
     */

    List<RoleEntity> findRolesById(Long id);

    /**
     * 指定用户分配角色
     *
     * @param Id      用户id
     * @param roleIds 角色id集
     */
    void addRolesByIdAndRoleIds(Long Id, Long[] roleIds);

    /**
     * 通过用户id查询权限
     *
     * @param id       用户id
     * @param parentId 父级id
     * @return 权限信息集
     */
    List<PermissionEntity> findPermissionById(Long id, Long parentId);


}
