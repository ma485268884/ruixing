package com.yintu.ruixing.service.rbac.impl;

import com.yintu.ruixing.dao.rbac.PermissionRoleDao;
import com.yintu.ruixing.entity.rbac.PermissionRoleEntity;
import com.yintu.ruixing.entity.rbac.PermissionRoleEntityExample;
import com.yintu.ruixing.entity.rbac.RoleEntity;
import com.yintu.ruixing.service.rbac.PermissionRoleService;
import com.yintu.ruixing.service.rbac.PermissionService;
import com.yintu.ruixing.service.rbac.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:mlf
 * @date:2020/5/19 12:30
 */
public class PermissionRoleServiceImpl implements PermissionRoleService {
    @Autowired
    private PermissionRoleDao permissionRoleDao;
    @Autowired
    private RoleService roleService;

    /**
     * 按照权限id查询出全部角色信息
     *
     * @param permissionId 权限id
     * @return 角色全部信息
     */
    @Override
    public List<RoleEntity> findByPermissionId(Long permissionId) {
        PermissionRoleEntityExample permissionRoleEntityExample = new PermissionRoleEntityExample();
        PermissionRoleEntityExample.Criteria criteria = permissionRoleEntityExample.createCriteria();
        criteria.andPermissionIdEqualTo(permissionId);
        List<PermissionRoleEntity> permissionRoleEntities = permissionRoleDao.selectByExample(permissionRoleEntityExample);
        List<Long> roleIds = new ArrayList<>();
        for (PermissionRoleEntity permissionRoleEntity : permissionRoleEntities) {
            roleIds.add(permissionRoleEntity.getRoleId());
        }
        return roleService.findByIds(roleIds);
    }
}
