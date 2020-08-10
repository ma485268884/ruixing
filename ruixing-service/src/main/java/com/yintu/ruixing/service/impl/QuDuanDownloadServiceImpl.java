package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.QuDuanDownloadDao;
import com.yintu.ruixing.entity.QuDuanDownloadEntity;
import com.yintu.ruixing.entity.QuDuanInfoEntityV2;
import com.yintu.ruixing.service.CheZhanService;
import com.yintu.ruixing.service.QuDuanDownloadService;
import com.yintu.ruixing.service.QuDuanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<QuDuanDownloadEntity> findByDateTime(Integer czId, Date startDateTime, Date endDateTime) {
        return quDuanDownloadDao.selectByDateTime(czId, startDateTime, endDateTime);
    }

    @Override
    public Integer add(Integer czId, Short type, Date startDateTime, Date endDateTime) {
        QuDuanDownloadEntity quDuanDownloadEntity = new QuDuanDownloadEntity();
        quDuanDownloadEntity.setCid(czId);
        quDuanDownloadEntity.setStartTime(startDateTime);
        quDuanDownloadEntity.setEndTime(endDateTime);
        quDuanDownloadEntity.setStatus((short) 0);
        quDuanDownloadEntity.setType(type);
        quDuanDownloadEntity.setDataType((short) 1);
        quDuanDownloadEntity.setCreateTime(new Date());
        this.add(quDuanDownloadEntity);
        return quDuanDownloadEntity.getId();
    }

    @Override
    public Map<String, Object> findPlayBackDataById(Integer id) {
        QuDuanDownloadEntity quDuanDownloadEntity = this.findById(id);
        Integer czId = quDuanDownloadEntity.getCid();
        String quDuanBaseJsonData = cheZhanService.findJsonByCzId(czId);
        List<QuDuanInfoEntityV2> quDuanInfoEntityV2s = quDuanInfoService.findByCzIdAndTime(czId, quDuanDownloadEntity.getStartTime(), quDuanDownloadEntity.getEndTime());
        Map<String, Object> map = new HashMap<>();
        map.put("quDuanBaseJsonData", quDuanBaseJsonData);
        map.put("quDuanInfoEntityV2s", quDuanInfoEntityV2s);
        return map;
    }


    @Override
    public Integer changeDataStatus(Integer czId, Integer userId, Short dataStatus) {
        QuDuanDownloadEntity quDuanDownloadEntity = this.insertData(czId, userId);
        quDuanDownloadEntity.setDataStatus(dataStatus);
        if (dataStatus.equals((short) 1)) {
            quDuanDownloadEntity.setCreateTime(new Date());
        } else {
            if (quDuanDownloadEntity.getSwitchStatus().equals((short) 0)) {
                quDuanDownloadEntity.setSwitchStatus((short) 1);
            }
        }
        this.edit(quDuanDownloadEntity);
        return quDuanDownloadEntity.getId();
    }

    @Override
    public Integer changeSwitchStatus(Integer czId, Integer userId, Short switchStatus) {
        QuDuanDownloadEntity quDuanDownloadEntity = this.insertData(czId, userId);
        quDuanDownloadEntity.setSwitchStatus(switchStatus);
        this.edit(quDuanDownloadEntity);
        return quDuanDownloadEntity.getId();
    }

    @Override
    public Short changeUpdateTime(Integer czId, Integer userId) {
        QuDuanDownloadEntity quDuanDownloadEntity = this.insertData(czId, userId);
        quDuanDownloadEntity.setUpdateTime(new Date());
        this.edit(quDuanDownloadEntity);
        return quDuanDownloadEntity.getSwitchStatus();
    }


    public QuDuanDownloadEntity insertData(Integer czId, Integer userId) {
        QuDuanDownloadEntity quDuanDownloadEntity = this.quDuanDownloadDao.selectByCidAndDataType(czId, userId, (short) 2);
        if (quDuanDownloadEntity == null) {
            quDuanDownloadEntity = new QuDuanDownloadEntity();
            quDuanDownloadEntity.setCid(czId);
            quDuanDownloadEntity.setUserId(userId);
            quDuanDownloadEntity.setDataStatus((short) 0);
            quDuanDownloadEntity.setDataType((short) 2);
            Date date = new Date();
            quDuanDownloadEntity.setCreateTime(date);
            quDuanDownloadEntity.setSwitchStatus((short) 1);
            quDuanDownloadEntity.setUpdateTime(date);
            this.add(quDuanDownloadEntity);
        }
        return quDuanDownloadEntity;
    }
}

