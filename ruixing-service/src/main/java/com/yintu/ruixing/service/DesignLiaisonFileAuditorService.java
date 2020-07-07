package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.entity.DesignLiaisonFileAuditorEntity;
import com.yintu.ruixing.entity.PreSaleFileAuditorEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/7/6 18:41
 */
public interface DesignLiaisonFileAuditorService extends BaseService<DesignLiaisonFileAuditorEntity, Integer> {
    List<DesignLiaisonFileAuditorEntity> findByDesignLiaisonFileId(Integer designLiaisonFileId);

    void addMuch(List<DesignLiaisonFileAuditorEntity> designLiaisonFileAuditorEntities);

    void removeByDesignLiaisonFileId(Integer designLiaisonFileId);
}
