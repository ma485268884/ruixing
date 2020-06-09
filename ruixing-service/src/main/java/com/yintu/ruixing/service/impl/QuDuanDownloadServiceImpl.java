package com.yintu.ruixing.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yintu.ruixing.dao.QuDuanDownloadDao;
import com.yintu.ruixing.entity.QuDuanDownloadEntity;
import com.yintu.ruixing.entity.QuDuanInfoEntity;
import com.yintu.ruixing.service.QuDuanDownloadService;
import com.yintu.ruixing.service.QuDuanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
    private QuDuanInfoService quDuanInfoService;

    @Override
    public void add(QuDuanDownloadEntity quDuanDownloadEntity) {
        quDuanDownloadDao.insert(quDuanDownloadEntity);
    }

    @Override
    public void remove(Integer id) {
        quDuanDownloadDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(Integer id) {
        quDuanDownloadDao.deleteByPrimaryKey(id);
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
    public List<QuDuanInfoEntity> findDataById(Integer id) {
        QuDuanDownloadEntity quDuanDownloadEntity = this.findById(id);
        List<QuDuanInfoEntity> quDuanInfoEntities = new ArrayList<>();
        if (quDuanDownloadEntity != null) {
            String data = quDuanDownloadEntity.getData();
            List<Integer> quDuanIds = JSONArray.parseArray(data, Integer.class);
            for (Integer quDuanId : quDuanIds) {
                QuDuanInfoEntity quDuanInfoEntity = quDuanInfoService.findById(quDuanId);
                quDuanInfoEntities.add(quDuanInfoEntity);
            }

        }
        return quDuanInfoEntities;
    }

    @Override
    public void add(Integer xid, Integer cid, Short type, Date startDateTime, Integer minute) {
        Calendar time = Calendar.getInstance();
        time.setTime(startDateTime);
        time.add(Calendar.MINUTE, minute);
        Date endDateTime = time.getTime();
        List<QuDuanInfoEntity> quDuanInfoEntities = quDuanInfoService.findByCidAndXid(xid, cid);
        List<Integer> quDuanIds = new ArrayList<>();
        for (QuDuanInfoEntity quDuanInfoEntity : quDuanInfoEntities) {
            quDuanIds.add(quDuanInfoEntity.getId());
        }
        JSONArray ja = (JSONArray) JSONArray.toJSON(quDuanIds);
        QuDuanDownloadEntity quDuanDownloadEntity = new QuDuanDownloadEntity();
        quDuanDownloadEntity.setXid(xid);
        quDuanDownloadEntity.setCid(cid);
        quDuanDownloadEntity.setType(type);
        quDuanDownloadEntity.setStatus((short) 1);
        quDuanDownloadEntity.setData(ja.toJSONString());
        quDuanDownloadEntity.setStartTime(startDateTime);
        quDuanDownloadEntity.setEndTime(endDateTime);
        this.add(quDuanDownloadEntity);
    }
}
