package com.yintu.ruixing.service.rbac;

import com.yintu.ruixing.entity.rbac.RoleEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/5/19 9:33
 */
public interface UserRoleService {
    /**
     * 按照用户id查询角色集
     * @param userId 用户id
     * @return 返回指定角色集
     */
    List<RoleEntity> findRolesByUserId(Long userId);
}
