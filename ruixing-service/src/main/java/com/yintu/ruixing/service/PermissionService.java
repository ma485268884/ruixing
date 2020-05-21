package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.PermissionEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/5/19 12:13
 */
public interface PermissionService {
    /**
     * 添加权限
     *
     * @param permissionEntity 权限信息
     */
    void add(PermissionEntity permissionEntity);

    /**
     * 修改权限
     *
     * @param permissionEntity 权限信息
     */
    void edit(PermissionEntity permissionEntity);

    /**
     * @param id id
     */
    void remove(Long id);

    /**
     * @param id id
     * @return 权限信息
     */
    PermissionEntity findById(Long id);

    /**
     * 查询权限集以及对应的角色集
     *
     * @return 权限集
     */
    List<PermissionEntity> findPermissionAndRole();


}
