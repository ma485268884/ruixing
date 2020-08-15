package com.yintu.ruixing.yunxingweihu;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MaintenancePlanInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(MaintenancePlanInfoEntity record);

    int insertSelective(MaintenancePlanInfoEntity record);

    MaintenancePlanInfoEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MaintenancePlanInfoEntity record);

    int updateByPrimaryKey(MaintenancePlanInfoEntity record);

    List<MaintenancePlanInfoEntity> selectByCondition(Integer[] ids, Integer maintenancePlanId, String equipmentName);

    void insertMuch(List<MaintenancePlanInfoEntity> maintenancePlanInfoEntities);
}