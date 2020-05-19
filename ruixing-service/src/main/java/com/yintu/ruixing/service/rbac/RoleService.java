package com.yintu.ruixing.service.rbac;

import com.yintu.ruixing.entity.rbac.RoleEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/5/19 9:43
 */
public interface RoleService {
    /**
     *按照id集查询角色集
     * @param ids id集
     * @return 角色集
     */
    List<RoleEntity> findByIds(List<Long> ids);
}