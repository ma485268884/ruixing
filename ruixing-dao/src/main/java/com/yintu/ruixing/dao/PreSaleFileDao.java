package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.PreSaleFileEntity;

import java.util.List;

public interface PreSaleFileDao {
    int deleteByPrimaryKey(Integer id);

    int insert(PreSaleFileEntity record);

    int insertSelective(PreSaleFileEntity record);

    PreSaleFileEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PreSaleFileEntity record);

    int updateByPrimaryKey(PreSaleFileEntity record);

    List<PreSaleFileEntity> selectByYearAndProjectNameAndType(Integer year, String projectName, Short type);
}