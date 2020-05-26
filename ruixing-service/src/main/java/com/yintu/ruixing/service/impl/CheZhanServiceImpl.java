package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.CheZhanDao;
import com.yintu.ruixing.entity.CheZhanEntity;
import com.yintu.ruixing.service.CheZhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        cheZhanDao.insertChezhan(cheZhanEntity);
    }

    @Override
    public void update(Long id) {
        cheZhanDao.updateCheZhan(id);
    }

    @Override
    public CheZhanEntity findByCheZhanId(Long id) {
        return cheZhanDao.selectByCheZhan(id);
    }

}
