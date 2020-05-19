package com.yintu.ruixing.service.rbac;

import com.yintu.ruixing.entity.rbac.RoleEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/5/19 9:43
 */
public interface RoleService {
    /**
     * 添加角色
     *
     * @param roleEntity 角色信息
     */
    void add(RoleEntity roleEntity);

    /**
     * 删除角色
     *
     * @param roleEntity 角色信息
     */
    void edit(RoleEntity roleEntity);

    /**
     * 删除角色
     *
     * @param id id
     */
    void remove(Long id);

    /**
     * id查询角色
     *
     * @return 角色信息
     */
    RoleEntity findById(Long id);

    /**
     * 按照id集查询角色集
     *
     * @param ids id集
     * @return 角色集
     */
    List<RoleEntity> findByIds(List<Long> ids);

    /**
     * 按照用户id查询角色集
     *
     * @param userId 用户id
     * @return 返回指定角色集
     */
    List<RoleEntity> findByUserId(Long userId);

    /**
     * 按照权限id查询角色集
     *
     * @param permissionId 权限id
     * @return 返回指定角色集
     */
    List<RoleEntity> findByPermissionId(Long permissionId);
}