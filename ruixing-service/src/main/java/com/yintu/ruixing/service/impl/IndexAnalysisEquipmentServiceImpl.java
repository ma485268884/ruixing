package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.IndexAnalysisEquipmentDao;
import com.yintu.ruixing.entity.IndexAnalysisEquipmentEntity;
import com.yintu.ruixing.service.IndexAnalysisEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author:mlf
 * @date:2020/7/14 10:38
 */
@Service
@Transactional
public class IndexAnalysisEquipmentServiceImpl implements IndexAnalysisEquipmentService {
    @Autowired
    private IndexAnalysisEquipmentDao indexAnalysisEquipmentDao;

    @Override
    public void add(IndexAnalysisEquipmentEntity entity) {
        indexAnalysisEquipmentDao.insertSelective(entity);
    }

    @Override
    public void remove(Integer id) {
        indexAnalysisEquipmentDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(IndexAnalysisEquipmentEntity entity) {
        indexAnalysisEquipmentDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public IndexAnalysisEquipmentEntity findById(Integer id) {
        return indexAnalysisEquipmentDao.selectByPrimaryKey(id);
    }
}
