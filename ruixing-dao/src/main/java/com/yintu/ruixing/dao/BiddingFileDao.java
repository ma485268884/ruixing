package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.BiddingFileEntity;

import java.util.List;

public interface BiddingFileDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BiddingFileEntity record);

    int insertSelective(BiddingFileEntity record);

    BiddingFileEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BiddingFileEntity record);

    int updateByPrimaryKey(BiddingFileEntity record);

    List<BiddingFileEntity> selectByCondition(Integer year, String projectName, Integer[] ids, Short type);

}