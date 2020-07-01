package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.entity.PreSaleFileEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/6/30 18:58
 */
public interface PreSaleFileService extends BaseService<PreSaleFileEntity, Integer> {

    List<PreSaleFileEntity> findByYearAndProjectNameAndType(Integer year, String projectName, String type);
}
