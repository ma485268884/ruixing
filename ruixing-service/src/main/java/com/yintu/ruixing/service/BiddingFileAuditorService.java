package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.entity.BiddingFileAuditorEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/7/6 18:39
 */
public interface BiddingFileAuditorService extends BaseService<BiddingFileAuditorEntity, Integer> {

    List<BiddingFileAuditorEntity> findByBiddingFileIdId(Integer biddingFileId);

    void addMuch(List<BiddingFileAuditorEntity> biddingFileAuditorEntities);

    void removeByBiddingFileId(Integer biddingFileId);
}
