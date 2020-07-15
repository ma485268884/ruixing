package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.SparePartsEntity;

import java.util.List;

public interface SparePartsDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SparePartsEntity record);

    int insertSelective(SparePartsEntity record);

    SparePartsEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SparePartsEntity record);

    int updateByPrimaryKey(SparePartsEntity record);

    List<SparePartsEntity> selectByCondition(Integer[] ids,String equipmentName);

    void insertMuch(List<SparePartsEntity> sparePartsEntities);

    void deleteMuch(Integer[] ids);
}