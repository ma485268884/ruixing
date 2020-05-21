package com.yintu.ruixing.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.exception.BaseRuntimeException;
import com.yintu.ruixing.dao.RoleDao;
import com.yintu.ruixing.entity.*;
import com.yintu.ruixing.service.PermissionRoleService;
import com.yintu.ruixing.service.PermissionService;
import com.yintu.ruixing.service.RoleService;
import com.yintu.ruixing.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:mlf
 * @date:2020/5/19 9:45
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private PermissionRoleService permissionRoleService;
    @Autowired
    private PermissionService permissionService;

    @Override
    public void add(RoleEntity roleEntity) {
        RoleEntityExample roleEntityExample = new RoleEntityExample();
        RoleEntityExample.Criteria criteria = roleEntityExample.createCriteria();
        criteria.andNameEqualTo(roleEntity.getName());
        List<RoleEntity> userEntities = this.findByExample(roleEntityExample);
        if (userEntities.size() > 0) {
            throw new BaseRuntimeException("添加失败，角色重复");
        }
        roleDao.insertSelective(roleEntity);
    }

    @Override
    public void edit(RoleEntity roleEntity) {
        roleDao.updateByPrimaryKeySelective(roleEntity);
    }

    @Override
    public void remove(Long id) {
        roleDao.deleteByPrimaryKey(id);
    }

    @Override
    public RoleEntity findById(Long id) {
        return roleDao.selectByPrimaryKey(id);
    }

    @Override
    public List<RoleEntity> findAll() {
        RoleEntityExample roleEntityExample = new RoleEntityExample();
        return roleDao.selectByExample(roleEntityExample);
    }

    @Override
    public List<RoleEntity> findByExample(RoleEntityExample roleEntityExample) {
        return roleDao.selectByExample(roleEntityExample);
    }


    @Override
    public PageInfo<JSONObject> findAllAndUrlByUserIdAndUrl(Integer pageNumber, Integer pageSize, String name, Long userId, String url) {
        List<String> strings = permissionService.findByUserIdAndUrl(userId, "/users");
        Page<RoleEntity> roleEntityPage = PageHelper.startPage(pageNumber, pageSize);
        List<RoleEntity> roleEntities;
        if (name == null || "".equals(name)) {
            roleEntities = this.findAll();
        } else {
            RoleEntityExample roleEntityExample = new RoleEntityExample();
            RoleEntityExample.Criteria criteria = roleEntityExample.createCriteria();
            criteria.andNameLike("%" + name + "%");
            roleEntities = this.findByExample(roleEntityExample);
        }
        List<JSONObject> jsonObjects = new ArrayList<>();
        for (RoleEntity roleEntity : roleEntities) {
            JSONObject jo = (JSONObject) JSONObject.toJSON(roleEntity);
            jo.put("url", strings);
            jsonObjects.add(jo);
        }
        return new PageInfo<>(jsonObjects);
    }


    @Override
    public List<RoleEntity> findByIds(List<Long> ids) {
        RoleEntityExample roleEntityExample = new RoleEntityExample();
        RoleEntityExample.Criteria criteria = roleEntityExample.createCriteria();
        criteria.andIdIn(ids);
        return ids.size() == 0 ? new ArrayList<>() : roleDao.selectByExample(roleEntityExample);
    }


    @Override
    public List<RoleEntity> findByUserId(Long userId) {
        UserRoleEntityExample userRoleEntityExample = new UserRoleEntityExample();
        UserRoleEntityExample.Criteria criteria = userRoleEntityExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<UserRoleEntity> userRoleEntities = userRoleService.findByExample(userRoleEntityExample);
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
        List<PermissionRoleEntity> permissionRoleEntities = permissionRoleService.findByExample(permissionRoleEntityExample);
        List<Long> roleIds = new ArrayList<>();
        for (PermissionRoleEntity permissionRoleEntity : permissionRoleEntities) {
            roleIds.add(permissionRoleEntity.getRoleId());
        }
        return this.findByIds(roleIds);
    }

}
