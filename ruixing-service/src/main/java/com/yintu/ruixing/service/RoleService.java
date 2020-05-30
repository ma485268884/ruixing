package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.entity.PermissionEntity;
import com.yintu.ruixing.entity.RoleEntity;
import com.yintu.ruixing.entity.RoleEntityExample;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/5/19 9:43
 */
public interface RoleService {
    /**
     * 添加角色
     *
     * @param roleEntity 角色信息
     */
    void add(RoleEntity roleEntity);

    /**
     * 删除角色
     *
     * @param roleEntity 角色信息
     */
    void edit(RoleEntity roleEntity);

    /**
     * 删除角色
     *
     * @param id id
     */
    void remove(Long id);

    /**
     * id查询角色
     *
     * @return 角色信息
     */
    RoleEntity findById(Long id);

    /**
     * @return 角色信息
     */
    List<RoleEntity> findAll();


    /***
     * 多条件查询角色信息
     * @param roleEntityExample 角色条件
     * @return 角色信息集
     */
    List<RoleEntity> findByExample(RoleEntityExample roleEntityExample);

    /**
     * 按照id集查询角色集
     *
     * @param ids id集
     * @return 角色集
     */
    List<RoleEntity> findByIds(List<Long> ids);

    /**
     * 按照用户id查询角色集
     *
     * @param userId 用户id
     * @return 返回指定角色集
     */
    List<RoleEntity> findByUserId(Long userId);

    /**
     * 按照权限id查询角色集
     *
     * @param permissionId 权限id
     * @return 返回指定角色集
     */
    List<RoleEntity> findByPermissionId(Long permissionId);

    /**
     * 查询全部角色或者查询按照名称查询
     *
     * @param name 角色名字
     * @return 角色集
     */
    List<RoleEntity> findAllOrByName(String name);

    /**
     * @param id       角色id
     * @param parentId 上级id
     * @return 权限
     */

    List<TreeNodeUtil> findPermissionsTreeById(Long id, Long parentId);

    /**
     * @param id       角色id
     * @param parentId 上级id
     * @return 权限
     */
    List<TreeNodeUtil> findPermissionsById(Long id, Long parentId);


    /**
     * 指定角色分配权限
     *
     * @param Id            用户id
     * @param permissionIds 角色id集
     */
    void addPermissionsByIdAndPermissionIds(Long Id, Long[] permissionIds);


}