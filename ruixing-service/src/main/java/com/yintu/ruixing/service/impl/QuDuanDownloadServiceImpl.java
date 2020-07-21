package com.yintu.ruixing.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yintu.ruixing.dao.QuDuanDownloadDao;
import com.yintu.ruixing.entity.*;
import com.yintu.ruixing.service.CheZhanService;
import com.yintu.ruixing.service.QuDuanBaseService;
import com.yintu.ruixing.service.QuDuanDownloadService;
import com.yintu.ruixing.service.QuDuanInfoService;
import org.apache.tomcat.util.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author:mlf
 * @date:2020/6/8 15:33
 */
@Service
@Transactional
public class QuDuanDownloadServiceImpl implements QuDuanDownloadService {

    @Autowired
    private QuDuanDownloadDao quDuanDownloadDao;
    @Autowired
    private CheZhanService cheZhanService;
    @Autowired
    private QuDuanInfoService quDuanInfoService;

    private final ExecutorService executorService = Executors.newFixedThreadPool(3);

    @Override
    public void add(QuDuanDownloadEntity quDuanDownloadEntity) {
        quDuanDownloadDao.insertSelective(quDuanDownloadEntity);
    }

    @Override
    public void remove(Integer id) {
        quDuanDownloadDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(QuDuanDownloadEntity quDuanDownloadEntity) {
        quDuanDownloadDao.updateByPrimaryKeySelective(quDuanDownloadEntity);
    }

    @Override
    public QuDuanDownloadEntity findById(Integer id) {
        return quDuanDownloadDao.selectByPrimaryKey(id);
    }

    @Override
    public List<QuDuanDownloadEntity> findAll() {
        return quDuanDownloadDao.selectAll();
    }

    @Override
    public List<QuDuanDownloadEntity> findByDateTime(Date startDateTime, Date endDateTime) {
        return quDuanDownloadDao.selectByDateTime(startDateTime, endDateTime);
    }


    @Override
    public Integer add(Integer czId, Short type, Date startDateTime, Date endDateTime) {
        QuDuanDownloadEntity quDuanDownloadEntity = new QuDuanDownloadEntity();
        quDuanDownloadEntity.setCid(czId);
        quDuanDownloadEntity.setStartTime(startDateTime);
        quDuanDownloadEntity.setEndTime(endDateTime);
        quDuanDownloadEntity.setStatus((short) 0);
        quDuanDownloadEntity.setType(type);
        this.add(quDuanDownloadEntity);
        return quDuanDownloadEntity.getId();
    }

    @Override
    public Map<String, Object> findPlayBackDataById(Integer id) {
        QuDuanDownloadEntity quDuanDownloadEntity = this.findById(id);
        Integer czId = quDuanDownloadEntity.getCid();
        CheZhanEntity cheZhanEntity = cheZhanService.findByCzId(czId);
        String quDuanBaseJsonData = cheZhanEntity.getCzJson();
        List<QuDuanInfoEntityV2> quDuanInfoEntityV2s = quDuanInfoService.findByCzIdAndTime(czId, quDuanDownloadEntity.getStartTime(), quDuanDownloadEntity.getEndTime());
        Map<String, Object> map = new HashMap<>();
        map.put("quDuanBaseJsonData", quDuanBaseJsonData);
        map.put("quDuanInfoEntityV2s", quDuanInfoEntityV2s);
        return map;
    }


    //异步更新数据
    public static class QuDuanInfoRunnable implements Runnable {

        private final QuDuanDownloadService quDuanDownloadService;
        private final Integer id;

        private QuDuanInfoRunnable(QuDuanDownloadService quDuanDownloadService, Integer id) {
            this.quDuanDownloadService = quDuanDownloadService;
            this.id = id;
        }

        @Override
        public void run() {
            QuDuanDownloadEntity quDuanDownloadEntity = quDuanDownloadService.findById(id);
            if (quDuanDownloadEntity != null) {
                Integer cid = quDuanDownloadEntity.getCid();
                Date startDateTime = quDuanDownloadEntity.getStartTime();
                Date endDateTime = quDuanDownloadEntity.getEndTime();
                List<Integer> quDuanInfoIds = null;
                JSONArray ja = (JSONArray) JSONArray.toJSON(quDuanInfoIds);
                quDuanDownloadEntity.setStatus((short) 1);
                quDuanDownloadService.edit(quDuanDownloadEntity);
            }
        }

    }

}

