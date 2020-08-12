package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.entity.CustomerDutyEntity;
import com.yintu.ruixing.entity.DepartmentEntity;
import com.yintu.ruixing.entity.DepartmentEntityExample;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/5/27 11:59
 */
public interface DepartmentService extends BaseService<DepartmentEntity, Long> {
    /**
     * id集合查询
     *
     * @param ids id集合
     * @return 部门集合
     */
    List<DepartmentEntity> findByIds(List<Long> ids);

    /**
     * 按照条件删除
     *
     * @param departmentEntityExample 部门条件信息
     */
    void removeByExample(DepartmentEntityExample departmentEntityExample);


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
    List<TreeNodeUtil> findDepartmentTree(Long parentId, Long customerUnitsId);

    /**
     * 按照id删除部门
     *
     * @param id      id
     * @param isFirst 是否第一次
     */
    void removeByIdAndIsFirst(Long id, Boolean isFirst);

    /**
     * 通过部门id集合
     *
     * @param ids 部门id集合
     * @return 职位信息集合
     */
    List<CustomerDutyEntity> findCustomerDutiesByIds(Long[] ids);


}
