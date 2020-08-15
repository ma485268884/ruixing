package com.yintu.ruixing.yunxingweihu;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
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