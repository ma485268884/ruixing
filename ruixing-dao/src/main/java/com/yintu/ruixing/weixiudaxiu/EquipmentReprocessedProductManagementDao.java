package com.yintu.ruixing.weixiudaxiu;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EquipmentReprocessedProductManagementDao {
    int deleteByPrimaryKey(Integer id);

    int insert(EquipmentReprocessedProductManagementEntity record);

    int insertSelective(EquipmentReprocessedProductManagementEntity record);

    EquipmentReprocessedProductManagementEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EquipmentReprocessedProductManagementEntity record);

    int updateByPrimaryKey(EquipmentReprocessedProductManagementEntity record);

    List<EquipmentReprocessedProductManagementEntity> connectSelectByCondition(Integer id, String equipmentNumber);
}