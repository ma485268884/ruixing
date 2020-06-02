package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.TieLuJuDao;
import com.yintu.ruixing.entity.TieLuJuEntity;
import com.yintu.ruixing.service.TieLuJuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author:lcy
 * @date:2020-05-26 11
 * 铁路局的serviceimpl
 */
@Service
@Transactional
public class TieLuJuServiceImpl implements TieLuJuService {
    @Autowired
    private TieLuJuDao tieLuJuDao;
    @Override
    public TieLuJuEntity findTieLuJuById(Long tid) {
        return tieLuJuDao.findTieLuJuById(tid);
    }

    @Override
    public void addTieLuJU(TieLuJuEntity tieLuJuEntity) {
        tieLuJuDao.addTieLuJU(tieLuJuEntity);
    }

    @Override
    public void editTieLuJuById(TieLuJuEntity tieLuJuEntity) {
        tieLuJuDao.editTieLuJuById(tieLuJuEntity);
    }

    @Override
    public void delTieLuJu(Long tid) {
        tieLuJuDao.delTieLuJu(tid);
    }
}
