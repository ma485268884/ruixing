package com.yintu.ruixing.service.rbac.impl;

import com.yintu.ruixing.dao.rbac.PermissionRoleDao;
import com.yintu.ruixing.dao.rbac.RoleDao;
import com.yintu.ruixing.dao.rbac.UserRoleDao;
import com.yintu.ruixing.entity.rbac.*;
import com.yintu.ruixing.service.rbac.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:mlf
 * @date:2020/5/19 9:45
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private PermissionRoleDao permissionRoleDao;

    @Override
    public List<RoleEntity> findByIds(List<Long> ids) {
        RoleEntityExample roleEntityExample = new RoleEntityExample();
        RoleEntityExample.Criteria criteria = roleEntityExample.createCriteria();
        criteria.andIdIn(ids);
        return roleDao.selectByExample(roleEntityExample);
    }

    @Override
    public List<RoleEntity> findByUserId(Long userId) {
        UserRoleEntityExample userRoleEntityExample = new UserRoleEntityExample();
        UserRoleEntityExample.Criteria criteria = userRoleEntityExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<UserRoleEntity> userRoleEntities = userRoleDao.selectByExample(userRoleEntityExample);
        List<Long> roleIds = new ArrayList<>();
        for (UserRoleEntity userRoleEntity : userRoleEntities) {
            roleIds.add(userRoleEntity.getUserId());
        }
        return this.findByIds(roleIds);
    }

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
        return this.findByIds(roleIds);
    }
}
