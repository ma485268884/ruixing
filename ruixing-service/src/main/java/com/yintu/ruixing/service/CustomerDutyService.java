package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.AdvancedService;
import com.yintu.ruixing.entity.CustomerDutyEntity;
import com.yintu.ruixing.entity.DepartmentEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/8/10 14:28
 */
public interface CustomerDutyService extends AdvancedService<CustomerDutyEntity, Long> {


    void add(CustomerDutyEntity entity, Long[] departmentIds, String loginUserName);

    void edit(CustomerDutyEntity entity, Long[] departmentIds, String loginUserName);

    List<DepartmentEntity> findDepartmentsById(Long id);

}
