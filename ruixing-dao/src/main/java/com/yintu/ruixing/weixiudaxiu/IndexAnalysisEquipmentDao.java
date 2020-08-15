package com.yintu.ruixing.weixiudaxiu;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface IndexAnalysisEquipmentDao {
    int deleteByPrimaryKey(Integer id);

    int insert(IndexAnalysisEquipmentEntity record);

    int insertSelective(IndexAnalysisEquipmentEntity record);

    IndexAnalysisEquipmentEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndexAnalysisEquipmentEntity record);

    int updateByPrimaryKey(IndexAnalysisEquipmentEntity record);

    List<IndexAnalysisEquipmentEntity> selectByCondition(String equipmentNumber);


}