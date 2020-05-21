package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.CheZhanEntity;

import java.util.List;
import java.util.Map;

/**
 * @author:lcy
 * @date:2020-05-21 11
 * 数据统计
 */

public interface DataStatsService {
    List<CheZhanEntity> getAllData(Map map);

}
