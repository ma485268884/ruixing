package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.entity.QuDuanInfoPropertyEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/8/7 10:08
 */
public interface QuDuanInfoPropertyService extends BaseService<QuDuanInfoPropertyEntity, Integer> {
    List<QuDuanInfoPropertyEntity> findByType(Short type);
}
