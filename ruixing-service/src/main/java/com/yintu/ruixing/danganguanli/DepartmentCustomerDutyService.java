package com.yintu.ruixing.danganguanli;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.danganguanli.DepartmentCustomerDutyEntity;
import com.yintu.ruixing.danganguanli.DepartmentCustomerDutyEntityExample;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/8/11 11:03
 */
public interface DepartmentCustomerDutyService extends BaseService<DepartmentCustomerDutyEntity, Long> {

    /**
     * 多条件查询部门用户信息
     *
     * @param departmentCustomerDutyEntityExample 部门职务条件
     * @return 用户角色信息集
     */
    List<DepartmentCustomerDutyEntity> findByExample(DepartmentCustomerDutyEntityExample departmentCustomerDutyEntityExample);

    /**
     * 按照条件删除部门用户
     *
     * @param departmentCustomerDutyEntityExample 部门职务条件
     */
    void removeByExample(DepartmentCustomerDutyEntityExample departmentCustomerDutyEntityExample);


}
