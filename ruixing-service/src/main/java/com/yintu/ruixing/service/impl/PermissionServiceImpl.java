package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.dao.PermissionDao;
import com.yintu.ruixing.entity.*;
import com.yintu.ruixing.service.PermissionRoleService;
import com.yintu.ruixing.service.PermissionService;
import com.yintu.ruixing.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private PermissionRoleService permissionRoleService;

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
    public List<PermissionEntity> findByExample(PermissionEntityExample permissionEntityExample) {
        return permissionDao.selectByExample(permissionEntityExample);
    }

    @Override
    public List<PermissionEntity> findByIds(List<Long> ids, Long parentId) {
        List<PermissionEntity> permissionEntities = new ArrayList<>();
        if (ids.size() > 0) {
            PermissionEntityExample permissionEntityExample = new PermissionEntityExample();
            PermissionEntityExample.Criteria criteria = permissionEntityExample.createCriteria();
            criteria.andIdIn(ids);
            criteria.andParentIdEqualTo(parentId);
            permissionEntities = this.findByExample(permissionEntityExample);
        }
        return permissionEntities;
    }

    @Override
    public List<PermissionEntity> findByRoleId(Long roleId, Long parentId) {
        PermissionRoleEntityExample permissionRoleEntityExample = new PermissionRoleEntityExample();
        PermissionRoleEntityExample.Criteria criteria = permissionRoleEntityExample.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        List<PermissionRoleEntity> permissionRoleEntities = permissionRoleService.findByExample(permissionRoleEntityExample);
        List<Long> permissionIds = new ArrayList<>();
        for (PermissionRoleEntity permissionRoleEntity : permissionRoleEntities) {
            permissionIds.add(permissionRoleEntity.getRoleId());
        }
        return this.findByIds(permissionIds, parentId);
    }

    @Override
    public List<PermissionEntity> findPermissionAndRole() {
        PermissionEntityExample permissionEntityExample = new PermissionEntityExample();
        List<PermissionEntity> permissionEntities = this.findByExample(permissionEntityExample);
        for (PermissionEntity permissionEntity : permissionEntities) {
            List<RoleEntity> roleEntities = roleService.findByPermissionId(permissionEntity.getId());
            permissionEntity.setRoleEntities(roleEntities);
        }
        return permissionEntities;
    }

    @Override
    public List<String> findRequestMethodsByUserIdAndUrl(Long userId, String url) {
        return permissionDao.selectByUserIdAndUrl(userId, url);
    }

    @Override
    public List<TreeNodeUtil> findPermissionTree(Long parentId) {
        PermissionEntityExample permissionEntityExample = new PermissionEntityExample();
        PermissionEntityExample.Criteria criteria = permissionEntityExample.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<PermissionEntity> permissionEntities = this.findByExample(permissionEntityExample);

        List<TreeNodeUtil> treeNodeUtils = new ArrayList<>();
        for (PermissionEntity permissionEntity : permissionEntities) {
            TreeNodeUtil treeNodeUtil = new TreeNodeUtil();
            treeNodeUtil.setId(permissionEntity.getId());
            treeNodeUtil.setLabel(permissionEntity.getName());
            treeNodeUtil.setIcon(permissionEntity.getIconCls());
            treeNodeUtil.setChildren(this.findPermissionTree(permissionEntity.getId()));
            treeNodeUtils.add(treeNodeUtil);
        }
        return treeNodeUtils;
    }


}
