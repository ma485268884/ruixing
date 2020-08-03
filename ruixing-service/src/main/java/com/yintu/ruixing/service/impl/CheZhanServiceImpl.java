package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.CheZhanDao;
import com.yintu.ruixing.dao.QuDuanBaseDao;
import com.yintu.ruixing.entity.CheZhanEntity;
import com.yintu.ruixing.entity.QuDuanBaseEntity;
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

    @Autowired
    private QuDuanBaseDao quDuanBaseDao;

    @Override
    public List<CheZhanEntity> findXiangLinTwoCheZhanByXdid(Integer xdid) {
        return cheZhanDao.findXiangLinTwoCheZhanByXdid(xdid);
    }

    @Override
    public List<CheZhanEntity> findXiangLinThreeCheZhanByXdid(Integer xdid) {
        return cheZhanDao.findXiangLinThreeCheZhanByXdid(xdid);
    }

    @Override
    public List<CheZhanEntity> findXiangLinFourCheZhanByXdid(Integer xdid) {
        return cheZhanDao.findXiangLinFourCheZhanByXdid(xdid);
    }

    @Override
    public List<CheZhanEntity> findXiangLinFiveCheZhanByXdid(Integer xdid) {
        return cheZhanDao.findXiangLinFiveCheZhanByXdid(xdid);
    }

    @Override
    public List<CheZhanEntity> findXiangLinSixCheZhanByXdid(Integer xdid) {
        return cheZhanDao.findXiangLinSixCheZhanByXdid(xdid);
    }

    @Override
    public List<CheZhanEntity> findXiangLinOneCheZhanByXdid(Integer xdid) {
        return cheZhanDao.findXiangLinOneCheZhanByXdid(xdid);
    }

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
    public List<QuDuanBaseEntity> findQuDuanByCid(Long cid) {
        return quDuanBaseDao.findQuDuanByCid(cid);
    }

    @Override
    public List<CheZhanEntity> findByCzName(String czName) {
        return cheZhanDao.selectByCzName(czName);
    }

    @Override
    public String  findJsonByCzId(Integer czId) {
        return cheZhanDao.selectJsonByCzId(czId);
    }

}
