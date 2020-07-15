package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.EquipmentEntity;

import java.util.List;

public interface EquipmentDao {
    int deleteByPrimaryKey(Integer id);

    int insert(EquipmentEntity record);

    int insertSelective(EquipmentEntity record);

    EquipmentEntity selectByPrimaryKey(Integer id);

    List<EquipmentEntity> selectAll();

    int updateByPrimaryKeySelective(EquipmentEntity record);

    int updateByPrimaryKey(EquipmentEntity record);
}