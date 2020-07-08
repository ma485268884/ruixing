package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.MaintenancePlanEntity;

import java.util.List;

public interface MaintenancePlanDao {
    int deleteByPrimaryKey(Integer id);

    int insert(MaintenancePlanEntity record);

    int insertSelective(MaintenancePlanEntity record);

    MaintenancePlanEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MaintenancePlanEntity record);

    int updateByPrimaryKey(MaintenancePlanEntity record);

    List<MaintenancePlanEntity> selectByName(String name);

    List<MaintenancePlanEntity> selectByIds(Integer[] ids);

    void insertMuch(List<MaintenancePlanEntity> maintenancePlanEntities);
}