package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.BiddingFileAuditorEntity;

public interface BiddingFileAuditorDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BiddingFileAuditorEntity record);

    int insertSelective(BiddingFileAuditorEntity record);

    BiddingFileAuditorEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BiddingFileAuditorEntity record);

    int updateByPrimaryKey(BiddingFileAuditorEntity record);
}