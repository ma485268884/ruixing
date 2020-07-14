package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.IndexAnalysisEquipmentEntity;

import java.util.List;

public interface IndexAnalysisEquipmentDao {
    int deleteByPrimaryKey(Integer id);

    int insert(IndexAnalysisEquipmentEntity record);

    int insertSelective(IndexAnalysisEquipmentEntity record);

    IndexAnalysisEquipmentEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndexAnalysisEquipmentEntity record);

    int updateByPrimaryKey(IndexAnalysisEquipmentEntity record);

    List<IndexAnalysisEquipmentEntity> selectByCondition(String equipmentNumber);


}