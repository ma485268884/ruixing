package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.QuDuanInfoDao;
import com.yintu.ruixing.dao.QuXianDao;
import com.yintu.ruixing.entity.QuDuanBaseEntity;
import com.yintu.ruixing.entity.QuDuanInfoEntity;
import com.yintu.ruixing.entity.SheBeiEntity;
import com.yintu.ruixing.service.QuXianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author:lcy
 * @date:2020-06-11 17
 * 曲线相关
 */
@Service
@Transactional
public class QuXianServiceImpl implements QuXianService {
    @Autowired
    private QuXianDao quXianDao;
    @Autowired
    private QuDuanInfoDao quDuanInfoDao;

    @Override
    public List<SheBeiEntity> findSheBeiByCid(Integer id) {
        return quXianDao.findSheBeiByCid(id);
    }

    @Override
    public List<QuDuanBaseEntity> findQuDuanById(Integer id) {
        return quXianDao.findQuDuanById(id);
    }

    @Override
    public List<QuDuanInfoEntity> findQuDuanDataByTime(Date time) {
        return quDuanInfoDao.findQuDuanDataByTime(time);
    }

    @Override
    public List<QuDuanBaseEntity> findQuDuanDataByTime1(Date time) {
        return quXianDao.findQuDuanDataByTime1(time);
    }

    @Override
    public List<QuDuanInfoEntity> findQuDuanDataByTime2(String format) {
        return quDuanInfoDao.findQuDuanDataByTime2(format);
    }
}
