package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.EquipmentNumberEntity;

import java.util.List;

public interface EquipmentNumberDao {
    int deleteByPrimaryKey(Integer id);

    int insert(EquipmentNumberEntity record);

    int insertSelective(EquipmentNumberEntity record);

    EquipmentNumberEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EquipmentNumberEntity record);

    int updateByPrimaryKey(EquipmentNumberEntity record);

    List<EquipmentNumberEntity> selectByCondition(Integer[] ids, String equipmentNumber);

    void deleteMuch(Integer[] ids);


}