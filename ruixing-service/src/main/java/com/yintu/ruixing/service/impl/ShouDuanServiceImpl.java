package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.ShouDuanDao;
import com.yintu.ruixing.entity.ShouDuanEntity;
import com.yintu.ruixing.service.ShouDuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/6/2 15:31
 */
@Service
@Transactional
public class ShouDuanServiceImpl implements ShouDuanService {
    @Autowired
    private ShouDuanDao shouDuanDao;

    @Override
    public void add(ShouDuanEntity shouDuanEntity) {
        shouDuanDao.insertSelective(shouDuanEntity);
    }

    @Override
    public void remove(Integer id) {
        shouDuanDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(ShouDuanEntity shouDuanEntity) {
        shouDuanDao.updateByPrimaryKeySelective(shouDuanEntity);
    }

    @Override
    public ShouDuanEntity findById(Integer id) {
        return shouDuanDao.selectByPrimaryKey(id);
    }

    @Override
    public List<ShouDuanEntity> findAll() {
        return shouDuanDao.selectByAll();
    }

    @Override
    public List<ShouDuanEntity> findByCidAndXid(Integer cid, Integer xid) {
        return shouDuanDao.selectByCidAndXid(cid, xid);
    }
}
