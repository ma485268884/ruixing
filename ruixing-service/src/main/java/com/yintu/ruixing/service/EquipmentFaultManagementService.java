package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.entity.EquipmentFaultManagementEntity;

import java.util.Date;
import java.util.List;

/**
 * @author:mlf
 * @date:2020/7/29 16:26
 */
public interface EquipmentFaultManagementService extends BaseService<EquipmentFaultManagementEntity, Integer> {

    void remove(Integer[] ids);

    List<EquipmentFaultManagementEntity> findByStartDateAndEndDate(Date startDate, Date endDate);
}
