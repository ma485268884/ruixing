package com.yintu.ruixing.service.rbac;

import com.yintu.ruixing.entity.rbac.PermissionEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/5/19 12:13
 */
public interface PermissionService {
    /**
     * 查询权限集以及对应的角色集
     *
     * @return 权限集
     */
    List<PermissionEntity> findByAllId();
}
