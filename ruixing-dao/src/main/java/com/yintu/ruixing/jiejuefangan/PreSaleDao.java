package com.yintu.ruixing.jiejuefangan;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
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