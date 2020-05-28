package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.entity.DepartmentEntity;
import com.yintu.ruixing.entity.DepartmentEntityExample;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/5/27 11:59
 */
public interface DepartmentService {
    /**
     * 添加部门
     *
     * @param departmentEntity 部门信息
     */
    void add(DepartmentEntity departmentEntity);

    /**
     * 修改部门
     *
     * @param departmentEntity 部门信息
     */
    void edit(DepartmentEntity departmentEntity);

    /**
     * 删除
     *
     * @param id id
     */
    void remove(Long id);

    /**
     * 按照条件删除
     *
     * @param departmentEntityExample 部门条件信息
     */
    void removeByExample(DepartmentEntityExample departmentEntityExample);

    /**
     * 按照id查询部门信息
     *
     * @param id id
     * @return 部门信息
     */
    DepartmentEntity findById(Long id);

    /**
     * 按照条件查询部门集合
     *
     * @param departmentEntityExample 部门条件信息
     * @return 部门集合
     */
    List<DepartmentEntity> findByExample(DepartmentEntityExample departmentEntityExample);

    /**
     * 获取部门tree
     *
     * @param parentId 父级id
     * @return 部门树
     */
    List<TreeNodeUtil> findDepartmentTree(Long parentId);

    /**
     * 按照id删除部门
     *
     * @param id      id
     * @param isFirst 是否第一次
     */
    void removeByIdAndIsFirst(Long id, Boolean isFirst);

}
