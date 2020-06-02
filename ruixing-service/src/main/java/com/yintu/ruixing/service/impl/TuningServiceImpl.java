package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.TuningDao;
import com.yintu.ruixing.entity.TuningEntity;
import com.yintu.ruixing.service.TuningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/6/2 16:29
 */
@Service
@Transactional
public class TuningServiceImpl implements TuningService {
    @Autowired
    private TuningDao tuningDao;

    @Override
    public void add(TuningEntity tuningEntity) {
        tuningDao.insertSelective(tuningEntity);
    }

    @Override
    public void remove(Integer id) {
        tuningDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(TuningEntity tuningEntity) {
        tuningDao.updateByPrimaryKeySelective(tuningEntity);
    }

    @Override
    public TuningEntity findById(Integer id) {
        return tuningDao.selectByPrimaryKey(id);
    }

    @Override
    public List<TuningEntity> findAll() {
        return tuningDao.selectByAll();
    }

    @Override
    public List<TuningEntity> findByCidAndXid(Integer cid, Integer xid) {
        return tuningDao.selectByCidAndXid(cid, xid);
    }
}
