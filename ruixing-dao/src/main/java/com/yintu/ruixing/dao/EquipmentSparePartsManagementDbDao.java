package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.EquipmentSparePartsManagementDbEntity;

import java.util.List;

public interface EquipmentSparePartsManagementDbDao {
    int deleteByPrimaryKey(Integer id);

    int insert(EquipmentSparePartsManagementDbEntity record);

    int insertSelective(EquipmentSparePartsManagementDbEntity record);

    EquipmentSparePartsManagementDbEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EquipmentSparePartsManagementDbEntity record);

    int updateByPrimaryKey(EquipmentSparePartsManagementDbEntity record);

    List<EquipmentSparePartsManagementDbEntity> connectSelectByCondition(Integer id, String equipmentName, String materialNumber);

}