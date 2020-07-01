package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.PreSaleFileDao;
import com.yintu.ruixing.entity.PreSaleFileEntity;
import com.yintu.ruixing.service.PreSaleFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/6/30 18:58
 */
@Service
@Transactional
public class PreSaleFileServiceImpl implements PreSaleFileService {
    @Autowired
    private PreSaleFileDao preSaleFileDao;

    @Override
    public void add(PreSaleFileEntity entity) {
        preSaleFileDao.insertSelective(entity);
    }

    @Override
    public void remove(Integer id) {
        preSaleFileDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(PreSaleFileEntity entity) {
        preSaleFileDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public PreSaleFileEntity findById(Integer id) {
        return preSaleFileDao.selectByPrimaryKey(id);
    }

    @Override
    public List<PreSaleFileEntity> findByYearAndProjectNameAndType(Integer year, String projectName, String type) {
        return preSaleFileDao.selectByYearAndProjectNameAndType(year, "%" + projectName + "%", "输入文件".equals(type) ? (short) 1 : (short) 2);
    }
}
