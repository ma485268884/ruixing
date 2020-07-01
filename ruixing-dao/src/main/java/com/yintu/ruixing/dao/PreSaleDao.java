package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.PreSaleEntity;

import java.util.List;

public interface PreSaleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(PreSaleEntity record);

    int insertSelective(PreSaleEntity record);

    PreSaleEntity selectByPrimaryKey(Integer id);

    List<PreSaleEntity> selectByAll();

    int updateByPrimaryKeySelective(PreSaleEntity record);

    int updateByPrimaryKey(PreSaleEntity record);

    List<Integer> selectByDistinctProjectDate();

    List<String> selectByYear(Integer year);
}