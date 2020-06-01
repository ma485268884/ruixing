package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.YuJingDao;
import com.yintu.ruixing.entity.YuJingEntity;
import com.yintu.ruixing.service.YuJingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author:mlf
 * @date:2020/6/1 11:29
 */
@Service
@Transactional
public class YuJingServiceImpl implements YuJingService {
    @Autowired
    private YuJingDao yuJingDao;

    @Override
    public void add(YuJingEntity yuJingEntity) {
        yuJingDao.insertSelective(yuJingEntity);
    }

    @Override
    public void remove(Integer id) {
        yuJingDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(YuJingEntity yuJingEntity) {
        yuJingDao.updateByPrimaryKeySelective(yuJingEntity);
    }

    @Override
    public YuJingEntity findById(Integer id) {
        return yuJingDao.selectByPrimaryKey(id);
    }
}
