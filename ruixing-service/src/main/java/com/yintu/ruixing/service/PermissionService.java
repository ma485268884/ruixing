package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.entity.PermissionEntity;
import com.yintu.ruixing.entity.PermissionEntityExample;

import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/5/19 12:13
 */
public interface PermissionService {
    /**
     * 添加权限
     *
     * @param permissionEntity 权限信息
     */
    void add(PermissionEntity permissionEntity);

    /**
     * 修改权限
     *
     * @param permissionEntity 权限信息
     */
    void edit(PermissionEntity permissionEntity);

    /**
     * @param id id
     */
    void remove(Long id);

    /**
     * @param id id
     * @return 权限信息
     */
    PermissionEntity findById(Long id);

    /**
     * @param permissionEntityExample 多条件查询权限列表
     * @return 权限集
     */
    List<PermissionEntity> findByExample(PermissionEntityExample permissionEntityExample);

    /**
     * 查询权限集以及对应的角色集
     *
     * @return 权限集
     */
    List<PermissionEntity> findPermissionAndRole();

    /**
     * 按照用户和模块寻查询权限
     *
     * @param userId
     * @param url
     * @return
     */
    List<String> findRequestMethodsByUserIdAndUrl(Long userId, String url);

    /**
     * 获取tree
     * @param parentId 父级id
     * @return
     */
    List<TreeNodeUtil> findPermissionTree(Long parentId);

}
