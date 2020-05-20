package com.yintu.ruixing.service.rbac.impl;

import com.yintu.ruixing.dao.rbac.PermissionRoleDao;
import com.yintu.ruixing.entity.rbac.PermissionRoleEntity;
import com.yintu.ruixing.entity.rbac.UserRoleEntity;
import com.yintu.ruixing.service.rbac.PermissionRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author:mlf
 * @date:2020/5/19 12:30
 */
@Service
@Transactional
public class PermissionRoleServiceImpl implements PermissionRoleService {

    @Autowired
    private PermissionRoleDao permissionRoleDao;

    @Override
    public void add(PermissionRoleEntity permissionRoleEntity) {
        permissionRoleDao.insertSelective(permissionRoleEntity);
    }

    @Override
    public void edit(PermissionRoleEntity permissionRoleEntity) {
        permissionRoleDao.updateByPrimaryKeySelective(permissionRoleEntity);
    }

    @Override
    public void remove(Long id) {
        permissionRoleDao.deleteByPrimaryKey(id);
    }

    @Override
    public PermissionRoleEntity findById(Long id) {
        return permissionRoleDao.selectByPrimaryKey(id);
    }
}
