package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.EquipmentFaultManagementEntity;

import java.util.Date;
import java.util.List;

public interface EquipmentFaultManagementDao {
    int deleteByPrimaryKey(Integer id);

    int insert(EquipmentFaultManagementEntity record);

    int insertSelective(EquipmentFaultManagementEntity record);

    EquipmentFaultManagementEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EquipmentFaultManagementEntity record);

    int updateByPrimaryKey(EquipmentFaultManagementEntity record);

    List<EquipmentFaultManagementEntity> connectSelectByCondition(Integer id, Date startDate, Date endDate);
}