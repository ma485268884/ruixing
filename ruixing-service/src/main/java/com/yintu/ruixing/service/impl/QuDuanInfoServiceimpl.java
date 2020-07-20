package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.QuDuanInfoDao;
import com.yintu.ruixing.entity.QuDuanInfoEntity;
import com.yintu.ruixing.service.QuDuanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/6/3 11:53
 */
@Service
@Transactional
public class QuDuanInfoServiceimpl implements QuDuanInfoService {

    @Autowired
    private QuDuanInfoDao quDuanInfoDao;


    @Override
    public QuDuanInfoEntity findById(Integer id) {
        return quDuanInfoDao.selectByPrimaryKey(id);
    }

    @Override
    public List<QuDuanInfoEntity> findQidAndTime(Integer qid, Date time) {
        return quDuanInfoDao.selectByQidAndTime(qid, time);
    }

    @Override
    public List<Integer> findByXidAndCidAndBetweenAndTime(Integer xid, Integer cid, Date startTime, Date endTime) {
        return quDuanInfoDao.selectByXidAndCidAndBetweenAndTime(xid, cid, startTime, endTime);
    }


    @Override
    public List<QuDuanInfoEntity> findByXidAndCidAndTime(Integer xid, Integer cid, Date time) {
        return quDuanInfoDao.selectByXidAndCidAndTime(xid, cid, time);
    }


    @Override
    public List<Map<String, Object>> findStatisticsByDate(Integer xid, Integer cid, Date time) {
        return quDuanInfoDao.selectStatisticsByDate(xid, cid, time);
    }


}
