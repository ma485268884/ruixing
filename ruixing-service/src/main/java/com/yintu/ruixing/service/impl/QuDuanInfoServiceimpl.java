package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.QuDuanInfoDaoV2;
import com.yintu.ruixing.entity.QuDuanBaseEntity;
import com.yintu.ruixing.entity.QuDuanInfoEntityV2;
import com.yintu.ruixing.service.QuDuanBaseService;
import com.yintu.ruixing.service.QuDuanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/6/3 11:53
 */
@Service
public class QuDuanInfoServiceimpl implements QuDuanInfoService {

    @Autowired
    private QuDuanInfoDaoV2 quDuanInfoDaoV2;

    @Autowired
    private QuDuanBaseService quDuanBaseService;


    @Override
    public QuDuanInfoEntityV2 findById(Integer id) {
        return quDuanInfoDaoV2.selectByPrimaryKey(id);
    }


    @Override
    public QuDuanInfoEntityV2 findLastBycZId(Integer czId) {
        return quDuanInfoDaoV2.selectLastByCzId(czId);
    }

    @Override
    public List<QuDuanInfoEntityV2> findByCzIdAndTime(Integer czId, Date startTime, Date endTime) {
        return quDuanInfoDaoV2.selectByCzIdAndTime(czId, startTime, endTime);
    }


    @Override
    public QuDuanInfoEntityV2 findLastByQid(Integer qid) {
        return quDuanInfoDaoV2.selectLastByQid(qid);
    }


    @Override
    public List<QuDuanInfoEntityV2> findByCzIdAndTime(Integer czId, Date time) {
        return quDuanInfoDaoV2.selectByCzIdAndQid(czId, time);
    }

    @Override
    public List<Map<String, Object>> findStatisticsByCzIdAndTime(Integer czId, Date time) {
        return quDuanInfoDaoV2.selectStatisticsByCzIdAndTime(czId, time);
    }

    @Override
    public List<QuDuanInfoEntityV2> findByCondition(Integer czId, Date time) {
        List<QuDuanInfoEntityV2> quDuanInfoEntityV2s = new ArrayList<>();
        if (time == null) {
            List<QuDuanBaseEntity> quDuanBaseEntities = quDuanBaseService.findByCzId(czId);
            for (QuDuanBaseEntity quDuanBaseEntity : quDuanBaseEntities) {
                QuDuanInfoEntityV2 quDuanInfoEntityV2 = quDuanInfoDaoV2.selectFirstByCzId1(czId, quDuanBaseEntity.getQdid());
                quDuanInfoEntityV2s.add(quDuanInfoEntityV2);
            }
        } else {
            quDuanInfoEntityV2s = quDuanInfoDaoV2.selectByCzIdAndTime1(czId, time);
        }
        return quDuanInfoEntityV2s;
    }

    @Override
    public Integer[] findDistinctTypeByCzId(Integer czId) {
        return quDuanInfoDaoV2.selectDistinctTypeByCzId(czId);
    }


}
