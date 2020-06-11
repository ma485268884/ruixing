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
    public void add(QuDuanInfoEntity quDuanInfoEntity) {
        quDuanInfoDao.insertSelective(quDuanInfoEntity);
    }

    @Override
    public void remove(Integer id) {
        quDuanInfoDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(QuDuanInfoEntity quDuanInfoEntity) {
        quDuanInfoDao.updateByPrimaryKeySelective(quDuanInfoEntity);
    }

    @Override
    public QuDuanInfoEntity findById(Integer id) {
        return quDuanInfoDao.selectByPrimaryKey(id);
    }

    @Override
    public List<QuDuanInfoEntity> findByCidAndXid(Integer cid, Integer xid) {
        return quDuanInfoDao.selectByXidAndCid(cid, xid);
    }

    @Override
    public List<QuDuanInfoEntity> findAll() {
        return quDuanInfoDao.selectAll();
    }


    @Override
    public List<Map<String, Object>> findStatisticsByDate(Date data) {
        return quDuanInfoDao.selectStatisticsByDate(data);
    }


}
