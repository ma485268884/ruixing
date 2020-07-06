package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.PreSaleFileAuditorDao;
import com.yintu.ruixing.entity.PreSaleFileAuditorEntity;
import com.yintu.ruixing.service.PreSaleFileAuditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author:mlf
 * @date:2020/7/6 18:42
 */
@Service
@Transactional
public class PreSaleFileAuditorServiceImpl implements PreSaleFileAuditorService {
    @Autowired
    private PreSaleFileAuditorDao preSaleFileAuditorDao;

    @Override
    public void add(PreSaleFileAuditorEntity entity) {
        preSaleFileAuditorDao.insertSelective(entity);
    }

    @Override
    public void remove(Integer id) {
        preSaleFileAuditorDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(PreSaleFileAuditorEntity entity) {
        preSaleFileAuditorDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public PreSaleFileAuditorEntity findById(Integer id) {
        return preSaleFileAuditorDao.selectByPrimaryKey(id);
    }
}
