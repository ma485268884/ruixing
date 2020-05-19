package com.yintu.ruixing.service.rbac.impl;

import com.yintu.ruixing.dao.rbac.PermissionDao;
import com.yintu.ruixing.entity.rbac.PermissionEntity;
import com.yintu.ruixing.entity.rbac.PermissionEntityExample;
import com.yintu.ruixing.entity.rbac.RoleEntity;
import com.yintu.ruixing.service.rbac.PermissionService;
import com.yintu.ruixing.service.rbac.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/5/19 12:29
 */
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;
    @Autowired
    private RoleService roleService;

    @Override
    public void add(PermissionEntity permissionEntity) {
        permissionDao.insertSelective(permissionEntity);
    }

    @Override
    public void edit(PermissionEntity permissionEntity) {
        permissionDao.updateByPrimaryKeySelective(permissionEntity);
    }

    @Override
    public void remove(Long id) {
        permissionDao.deleteByPrimaryKey(id);
    }

    @Override
    public PermissionEntity findById(Long id) {
        return permissionDao.selectByPrimaryKey(id);
    }

    @Override
    public List<PermissionEntity> findPermissionAndRole() {
        PermissionEntityExample permissionEntityExample = new PermissionEntityExample();
        List<PermissionEntity> permissionEntities = permissionDao.selectByExample(permissionEntityExample);
        for (PermissionEntity permissionEntity : permissionEntities) {
            List<RoleEntity> roleEntities = roleService.findByPermissionId(permissionEntity.getId());
            permissionEntity.setRoleEntities(roleEntities);
        }
        return permissionEntities;
    }
}
