package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.entity.QuDuanInfoTypesPropertyEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/8/4 18:54
 */

public interface QuDuanInfoTypesPropertyService extends BaseService<QuDuanInfoTypesPropertyEntity, Integer> {


    List<QuDuanInfoTypesPropertyEntity> connectFindByCondition(String types);
}
