package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.EquipmentOverhaulManagementEntity;

import java.util.List;

public interface EquipmentOverhaulManagementDao {
    int deleteByPrimaryKey(Integer id);

    int insert(EquipmentOverhaulManagementEntity record);

    int insertSelective(EquipmentOverhaulManagementEntity record);

    EquipmentOverhaulManagementEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EquipmentOverhaulManagementEntity record);

    int updateByPrimaryKey(EquipmentOverhaulManagementEntity record);

    List<EquipmentOverhaulManagementEntity> connectSelectByCondition(Integer id, String equipmentNumber);
}