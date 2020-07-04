package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.PreSaleEntity;

import java.util.Date;
import java.util.List;

public interface PreSaleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(PreSaleEntity record);

    int insertSelective(PreSaleEntity record);

    PreSaleEntity selectByPrimaryKey(Integer id);

    List<PreSaleEntity> selectAll();

    List<PreSaleEntity> selectByYear(Integer year);

    int updateByPrimaryKeySelective(PreSaleEntity record);

    int updateByPrimaryKey(PreSaleEntity record);

    List<Integer> selectByDistinctProjectDate();


}