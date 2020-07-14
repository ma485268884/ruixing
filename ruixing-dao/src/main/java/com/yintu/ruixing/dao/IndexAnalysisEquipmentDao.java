package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.IndexAnalysisEquipmentEntity;

public interface IndexAnalysisEquipmentDao {
    int deleteByPrimaryKey(Integer id);

    int insert(IndexAnalysisEquipmentEntity record);

    int insertSelective(IndexAnalysisEquipmentEntity record);

    IndexAnalysisEquipmentEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndexAnalysisEquipmentEntity record);

    int updateByPrimaryKey(IndexAnalysisEquipmentEntity record);
}