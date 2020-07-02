package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.BiddingEntity;

import java.util.List;

public interface BiddingDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BiddingEntity record);

    int insertSelective(BiddingEntity record);

    BiddingEntity selectByPrimaryKey(Integer id);

    List<BiddingEntity> selectAll();

    List<BiddingEntity> selectByYear(Integer year);

    int updateByPrimaryKeySelective(BiddingEntity record);

    int updateByPrimaryKey(BiddingEntity record);

    List<Integer> selectByDistinctProjectDate();
}