package com.yintu.ruixing.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yintu.ruixing.dao.QuDuanDownloadDao;
import com.yintu.ruixing.entity.QuDuanBaseEntity;
import com.yintu.ruixing.entity.QuDuanDownloadEntity;
import com.yintu.ruixing.entity.QuDuanInfoEntity;
import com.yintu.ruixing.service.QuDuanBaseService;
import com.yintu.ruixing.service.QuDuanDownloadService;
import com.yintu.ruixing.service.QuDuanInfoService;
import org.apache.tomcat.util.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
    private QuDuanBaseService quDuanBaseService;
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
    public List<QuDuanBaseEntity> findDataById(Integer id) {
        QuDuanDownloadEntity quDuanDownloadEntity = this.findById(id);
        List<QuDuanBaseEntity> quDuanBaseEntities = new ArrayList<>();
        if (quDuanDownloadEntity != null) {
            String data = quDuanDownloadEntity.getData();
            List<Integer> quDuanIds = JSONArray.parseArray(data, Integer.class);
            for (Integer quDuanId : quDuanIds) {
                QuDuanBaseEntity quDuanBaseEntity = quDuanBaseService.findById(quDuanId);
                quDuanBaseEntities.add(quDuanBaseEntity);
            }

        }
        return quDuanBaseEntities;
    }

    @Override
    public Integer add(Integer tid, Integer did, Integer xid, Integer cid, Integer sid, Short type, Date startDateTime, Date endDateTime) {
        QuDuanDownloadEntity quDuanDownloadEntity = new QuDuanDownloadEntity();
        quDuanDownloadEntity.setTid(tid);
        quDuanDownloadEntity.setDid(did);
        quDuanDownloadEntity.setXid(xid);
        quDuanDownloadEntity.setCid(cid);
        quDuanDownloadEntity.setSid(sid);
        quDuanDownloadEntity.setStartTime(startDateTime);
        quDuanDownloadEntity.setEndTime(endDateTime);

        quDuanDownloadEntity.setStatus((short) 0);
        quDuanDownloadEntity.setType(type);
        this.add(quDuanDownloadEntity);
        return quDuanDownloadEntity.getId();
    }


    @Override
    public void callbackEdit(Integer id) {
        executorService.submit(new QuDuanInfoRunnable(this, id));
    }

    //异步更新数据
    class QuDuanInfoRunnable implements Runnable {

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
                Integer tid = quDuanDownloadEntity.getTid();
                Integer did = quDuanDownloadEntity.getDid();
                Integer xid = quDuanDownloadEntity.getXid();
                Integer cid = quDuanDownloadEntity.getCid();
                Date startDateTime = quDuanDownloadEntity.getStartTime();
                Date endDateTime = quDuanDownloadEntity.getEndTime();
                List<Integer> quDuanInfoIds = quDuanInfoService.findByXidAndCidAndBetweenAndTime(xid, cid, startDateTime, endDateTime);
                JSONArray ja = (JSONArray) JSONArray.toJSON(quDuanInfoIds);
                quDuanDownloadEntity.setStatus((short) 1);
                quDuanDownloadEntity.setData(ja.toJSONString());
                quDuanDownloadService.edit(quDuanDownloadEntity);
            }
        }

    }

}

