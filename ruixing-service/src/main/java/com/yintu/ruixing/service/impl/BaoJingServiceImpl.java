package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.BaoJingDao;
import com.yintu.ruixing.entity.BaoJingEntity;
import com.yintu.ruixing.service.BaojingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author:mlf
 * @date:2020/6/1 11:28
 */
@Service
@Transactional
public class BaoJingServiceImpl implements BaojingService {
    @Autowired
    private BaoJingDao baojingDao;

    @Override
    public void add(BaoJingEntity baoJingEntity) {
        baojingDao.insertSelective(baoJingEntity);
    }

    @Override
    public void remove(Integer id) {
        baojingDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(BaoJingEntity baoJingEntity) {
        baojingDao.updateByPrimaryKeySelective(baoJingEntity);
    }

    @Override
    public BaoJingEntity findById(Integer id) {
        return baojingDao.selectByPrimaryKey(id);
    }
}
