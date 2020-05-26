package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.common.exception.BaseRuntimeException;
import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.dao.PermissionDao;
import com.yintu.ruixing.entity.*;
import com.yintu.ruixing.service.PermissionRoleService;
import com.yintu.ruixing.service.PermissionService;
import com.yintu.ruixing.service.RoleService;
import org.apache.ibatis.executor.BaseExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
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
    @Autowired
    private PermissionRoleService permissionRoleService;

    @Override
    public void add(PermissionEntity permissionEntity) {
        Long parentId = permissionEntity.getParentId();
        Assert.notNull(parentId, "父级id不能为空");
        PermissionEntity parentPermissionEntity = this.findById(parentId);
        if (parentPermissionEntity != null) {
            String parentPath = parentPermissionEntity.getPath();
            if (parentPath != null && !"".equals(parentPath))
                throw new BaseRuntimeException("当前节点不能添加权限信息");
        } else if (parentId != -1) {
            return;
        }
        String path = permissionEntity.getPath();
        String url = permissionEntity.getUrl();
        String method = permissionEntity.getMethod();
        if (path != null && !"".equals(path)) {
            Assert.notNull(url, "url不能为空");
            Assert.notNull(method, "method不能为空");
            if ("".equals(url) || "".equals(method))
                throw new BaseRuntimeException("url或者method填写有误有误");
            if (!"GET".equals(method.toUpperCase()))
                throw new BaseRuntimeException("只有请求方式为GET才能添加path");
        }
        permissionDao.insertSelective(permissionEntity);
    }

    @Override
    public void edit(PermissionEntity permissionEntity) {
        Long parentId = permissionEntity.getParentId();
        Assert.notNull(parentId, "父级id不能为空");
        PermissionEntity parentPermissionEntity = this.findById(parentId);
        if (parentPermissionEntity != null) {
            String parentPath = parentPermissionEntity.getPath();
            if (parentPath != null && !"".equals(parentPath))
                throw new BaseRuntimeException("当前节点不能添加权限信息");
        } else if (parentId != -1) {
            return;
        }
        String path = permissionEntity.getPath();
        String url = permissionEntity.getUrl();
        String method = permissionEntity.getMethod();
        if (path != null && !"".equals(path)) {
            Assert.notNull(url, "url不能为空");
            Assert.notNull(method, "method不能为空");
            if ("".equals(url) || "".equals(method))
                throw new BaseRuntimeException("url或者method填写有误有误");
            if (!"GET".equals(method.toUpperCase()))
                throw new BaseRuntimeException("只有请求方式为GET才能添加path");
        }
        permissionDao.updateByPrimaryKeySelective(permissionEntity);
    }

    @Override
    public void remove(Long id) {
        permissionDao.deleteByPrimaryKey(id);
    }

    @Override
    public void removeByExample(PermissionEntityExample permissionEntityExample) {
        permissionDao.deleteByExample(permissionEntityExample);
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
            criteria.andIdIn(ids).andParentIdEqualTo(parentId);
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
            permissionIds.add(permissionRoleEntity.getPermissionId());
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


    @Override
    public void removeByParentIdAndIsFirst(Long parentId, Boolean isFirst) {
        if (isFirst) {  //第一次掉用此方法，按照id查询权限信息，删除
            PermissionEntity permissionEntity = this.findById(parentId);
            if (permissionEntity != null) {
                this.remove(parentId);
            }
        }
        PermissionEntityExample permissionEntityExample = new PermissionEntityExample();
        PermissionEntityExample.Criteria criteria = permissionEntityExample.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<PermissionEntity> permissionEntities = this.findByExample(permissionEntityExample); //按照parentId查询
        if (permissionEntities.size() > 0) {
            for (PermissionEntity permissionEntity : permissionEntities) {//遍历递归删除
                this.remove(permissionEntity.getId());
                this.removeByParentIdAndIsFirst(permissionEntity.getId(), false);
                //注意：先删除再去查询，不会出现查不到情况，原因，递归调用方法，此前方法处于不会结束，也就意味着事物没有结束。当然也可以先去查询，再去删除。
            }
        }
    }
}
