package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.UserRoleEntity;
import com.yintu.ruixing.entity.UserRoleEntityExample;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/5/19 9:33
 */
public interface UserRoleService {

    /**
     * 添加用户角色
     *
     * @param userRoleEntity 用户角色
     */
    void add(UserRoleEntity userRoleEntity);

    /**
     * 修改用户角色
     *
     * @param userRoleEntity 用户角色信息
     */
    void edit(UserRoleEntity userRoleEntity);

    /**
     * 删除用户角色
     *
     * @param id id
     */
    void remove(Long id);

    /**
     * id查询角色
     *
     * @return 用户角色信息
     */
    UserRoleEntity findById(Long id);


    /**
     * 多条件查询用户角色信息
     *
     * @param userRoleEntityExample 用户角色条件
     * @return 用户角色信息集
     */
    List<UserRoleEntity> findByExample(UserRoleEntityExample userRoleEntityExample);

}
