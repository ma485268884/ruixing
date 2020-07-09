package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.MaintenancePlanInfoEntity;

import java.util.List;

public interface MaintenancePlanInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(MaintenancePlanInfoEntity record);

    int insertSelective(MaintenancePlanInfoEntity record);

    MaintenancePlanInfoEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MaintenancePlanInfoEntity record);

    int updateByPrimaryKey(MaintenancePlanInfoEntity record);

    List<MaintenancePlanInfoEntity> selectByMaintenancePlanIdAndWork(Integer maintenancePlanId, String work);

}