package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.CheZhanDao;
import com.yintu.ruixing.entity.CheZhanEntity;
import com.yintu.ruixing.service.CheZhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO
 *
 * @description:
 * @author: Qiao
 * @time: 2020/5/25 17:10
 */
@Service
@Transactional
public class CheZhanServiceImpl implements CheZhanService {

    @Autowired
    private CheZhanDao cheZhanDao;

    @Override
    public void add(CheZhanEntity cheZhanEntity) {
        long xid = cheZhanEntity.getXid();
        cheZhanEntity.setCzState(0);
        cheZhanEntity.setXdCzId(xid);
        cheZhanDao.insertChezhan(cheZhanEntity);
    }

    @Override
    public void update(CheZhanEntity cheZhanEntity) {
        cheZhanDao.updateCheZhan(cheZhanEntity);
    }

    @Override
    public CheZhanEntity findByCheZhanId(Long cid) {
        return cheZhanDao.selectByCheZhan(cid);
    }

    @Override
    public void delCheZhan(Long cid) {
        cheZhanDao.delCheZhan(cid);
    }

    @Override
    public List<CheZhanEntity> findAll() {
        return cheZhanDao.selectAll();
    }

    @Override
    public List<CheZhanEntity> findByCzName(String czName) {
        return cheZhanDao.selectByCzName(czName);
    }

    @Override
    public CheZhanEntity findByCzId(Integer czId) {
        return cheZhanDao.selectByCzId(czId);
    }

}
