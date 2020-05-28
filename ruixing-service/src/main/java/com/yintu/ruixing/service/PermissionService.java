package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.entity.PermissionEntity;
import com.yintu.ruixing.entity.PermissionEntityExample;

import java.util.List;

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
     * 按照指定条件删除权限
     *
     * @param permissionEntityExample 权限id
     */
    void removeByExample(PermissionEntityExample permissionEntityExample);

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
     * @param ids 权限id集合
     * @return 权限集
     */
    List<PermissionEntity> findByIds(List<Long> ids, Long parentId);

    /**
     * @param roleId 角色id
     * @return 权限集
     */
    List<PermissionEntity> findByRoleId(Long roleId, Long parentId);

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
     * 获取权限tree
     *
     * @param parentId 父级id
     * @return 权限树
     */
    List<TreeNodeUtil> findPermissionTree(Long parentId);


    /**
     * 指定删除id，以及次节点父节点
     *
     * @param id 权限id
     * @param isFirst  是否第一次
     */
    void removeByIdAndIsFirst(Long id, Boolean isFirst);


}
