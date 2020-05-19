package com.yintu.ruixing.service.rbac;

import com.yintu.ruixing.entity.rbac.RoleEntity;
import com.yintu.ruixing.entity.rbac.UserRoleEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/5/19 9:33
 */
public interface UserRoleService {

    List<RoleEntity> findByUserId(Long userId);
}
