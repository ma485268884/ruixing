package com.yintu.ruixing.service.rbac;

import com.yintu.ruixing.entity.rbac.RoleEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/5/19 9:43
 */
public interface RoleService {

    List<RoleEntity> findByIds(List<Long> ids);
}