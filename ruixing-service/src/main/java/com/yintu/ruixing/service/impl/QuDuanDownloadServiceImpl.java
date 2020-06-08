package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.QuDuanDownloadDao;
import com.yintu.ruixing.entity.QuDuanDownloadEntity;
import com.yintu.ruixing.service.QuDuanDownloadService;
import com.yintu.ruixing.service.QuDuanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void add(Integer xid, Integer cid, Date date, Integer minute) {
        Calendar time = Calendar.getInstance();
        time.setTime(date);
        time.add(Calendar.MINUTE, minute);
        Date endDateTime = time.getTime();
    }
}
