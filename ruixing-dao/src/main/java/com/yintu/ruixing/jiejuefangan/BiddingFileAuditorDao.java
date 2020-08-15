package com.yintu.ruixing.jiejuefangan;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BiddingFileAuditorDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BiddingFileAuditorEntity record);

    int insertSelective(BiddingFileAuditorEntity record);

    BiddingFileAuditorEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BiddingFileAuditorEntity record);

    int updateByPrimaryKey(BiddingFileAuditorEntity record);

    List<BiddingFileAuditorEntity> selectByBiddingFileId(Integer biddingFileId);

    void insertMuch(List<BiddingFileAuditorEntity> biddingFileAuditorEntities);

    void deleteByBiddingFileId(Integer biddingFileId);
}