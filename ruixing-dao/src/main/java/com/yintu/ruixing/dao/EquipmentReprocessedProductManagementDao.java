package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.EquipmentReprocessedProductManagementEntity;

import java.util.List;

public interface EquipmentReprocessedProductManagementDao {
    int deleteByPrimaryKey(Integer id);

    int insert(EquipmentReprocessedProductManagementEntity record);

    int insertSelective(EquipmentReprocessedProductManagementEntity record);

    EquipmentReprocessedProductManagementEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EquipmentReprocessedProductManagementEntity record);

    int updateByPrimaryKey(EquipmentReprocessedProductManagementEntity record);

    List<EquipmentReprocessedProductManagementEntity> connectSelectByCondition(Integer id, String equipmentNumber);
}