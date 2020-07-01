package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.PreSaleEntity;

import java.util.List;
import java.util.Map;

public interface PreSaleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(PreSaleEntity record);

    int insertSelective(PreSaleEntity record);

    PreSaleEntity selectByPrimaryKey(Integer id);

    List<PreSaleEntity> selectAll();

    int updateByPrimaryKeySelective(PreSaleEntity record);

    int updateByPrimaryKey(PreSaleEntity record);

    List<Integer> selectByDistinctProjectDate();

    List<Map<String, Object>> selectByYear(Integer year);
}