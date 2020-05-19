package com.yintu.ruixing.service.rbac.impl;

import com.yintu.ruixing.dao.rbac.PermissionDao;
import com.yintu.ruixing.entity.rbac.PermissionEntity;
import com.yintu.ruixing.entity.rbac.PermissionEntityExample;
import com.yintu.ruixing.entity.rbac.RoleEntity;
import com.yintu.ruixing.service.rbac.PermissionRoleService;
import com.yintu.ruixing.service.rbac.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/5/19 12:29
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;
    @Autowired
    private PermissionRoleService permissionRoleService;

    @Override
    public List<PermissionEntity> findByAllId() {
        PermissionEntityExample permissionEntityExample = new PermissionEntityExample();
        List<PermissionEntity> permissionEntities = permissionDao.selectByExample(permissionEntityExample);
        for (PermissionEntity permissionEntity : permissionEntities) {
            List<RoleEntity> roleEntities = permissionRoleService.findRolesByPermissionId(permissionEntity.getId());
            permissionEntity.setRoleEntities(roleEntities);
        }
        return null;
    }
}
