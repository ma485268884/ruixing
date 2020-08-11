package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.AdvancedService;
import com.yintu.ruixing.entity.CustomerDutyEntity;

import java.util.Date;

/**
 * @author:mlf
 * @date:2020/8/10 14:28
 */
public interface CustomerDutyService extends AdvancedService<CustomerDutyEntity, Long> {


    void add(CustomerDutyEntity entity, Integer[] departmentIds);

    void edit(CustomerDutyEntity entity, Integer[] departmentIds);

}
