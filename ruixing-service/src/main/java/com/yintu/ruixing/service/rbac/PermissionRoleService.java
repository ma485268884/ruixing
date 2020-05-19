package com.yintu.ruixing.service.rbac;

import com.yintu.ruixing.entity.rbac.RoleEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/5/19 12:14
 */
public interface PermissionRoleService {
    /**
     *按照权限id查询角色集
     * @param permissionId 权限id
     * @return  返回指定角色集
     */
    List<RoleEntity> findRolesByPermissionId(Long permissionId);
}
