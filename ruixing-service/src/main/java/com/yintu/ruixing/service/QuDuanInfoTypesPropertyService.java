package com.yintu.ruixing.service;

import cn.hutool.core.thread.FinalizableDelegatedExecutorService;
import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.entity.QuDuanInfoTypesPropertyEntity;

import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/8/4 18:54
 */

public interface QuDuanInfoTypesPropertyService extends BaseService<QuDuanInfoTypesPropertyEntity, Integer> {


    List<QuDuanInfoTypesPropertyEntity> connectFindByCondition(String types);

   String countByType(List<Integer> types);
}
