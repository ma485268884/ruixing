package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.PermissionRoleEntity;
import com.yintu.ruixing.entity.PermissionRoleEntityExample;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/5/19 12:14
 */
public interface PermissionRoleService {
    /**
     * 添加角色权限
     *
     * @param permissionRoleEntity 角色权限信息
     */
    void add(PermissionRoleEntity permissionRoleEntity);

    /**
     * 修改角色权限
     *
     * @param permissionRoleEntity 角色权限信息
     */
    void edit(PermissionRoleEntity permissionRoleEntity);

    /**
     * 删除角色权限
     *
     * @param id id
     */
    void remove(Long id);

    /**
     * id查询角色权限
     *
     * @return 角色权限信息
     */
    PermissionRoleEntity findById(Long id);

    /**
     * 多条件查询角色权限信息
     *
     * @param permissionRoleEntityExample 角色权限条件
     * @return 角色权限信息集
     */
    List<PermissionRoleEntity> findByExample(PermissionRoleEntityExample permissionRoleEntityExample);
}
