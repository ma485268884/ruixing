package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.entity.PreSaleFileAuditorEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/7/6 18:38
 */
public interface PreSaleFileAuditorService extends BaseService<PreSaleFileAuditorEntity, Integer> {

    List<PreSaleFileAuditorEntity> findByPreSaleFileId(Integer preSaleFileId);

    void addMuch(List<PreSaleFileAuditorEntity> preSaleFileAuditorEntities);

    void removeByPreSaleFileId(Integer preSaleFileId);
}
