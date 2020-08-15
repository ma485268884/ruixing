package com.yintu.ruixing.weixiudaxiu;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EquipmentOverhaulManagementDao {
    int deleteByPrimaryKey(Integer id);

    int insert(EquipmentOverhaulManagementEntity record);

    int insertSelective(EquipmentOverhaulManagementEntity record);

    EquipmentOverhaulManagementEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EquipmentOverhaulManagementEntity record);

    int updateByPrimaryKey(EquipmentOverhaulManagementEntity record);

    List<EquipmentOverhaulManagementEntity> connectSelectByCondition(Integer id, String equipmentNumber);
}