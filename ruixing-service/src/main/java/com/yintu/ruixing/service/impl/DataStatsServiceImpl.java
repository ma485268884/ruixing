package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.DataStatsDao;
import com.yintu.ruixing.entity.CheZhanEntity;
import com.yintu.ruixing.service.DataStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author:lcy
 * @date:2020-05-21 11
 * 数据统计
 */

@Service
@Transactional
public class DataStatsServiceImpl implements DataStatsService {

    @Autowired
    private DataStatsDao dataStatsDao;

    @Override
    public List<CheZhanEntity> getAllData(Map map) {
        return dataStatsDao.getAllData(map);
    }

}
