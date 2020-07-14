package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.IndexAnalysisEquipmentDao;
import com.yintu.ruixing.entity.EquipmentNumberEntity;
import com.yintu.ruixing.entity.IndexAnalysisEquipmentEntity;
import com.yintu.ruixing.service.EquipmentNumberService;
import com.yintu.ruixing.service.IndexAnalysisEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/7/14 10:38
 */
@Service
@Transactional
public class IndexAnalysisEquipmentServiceImpl implements IndexAnalysisEquipmentService {
    @Autowired
    private IndexAnalysisEquipmentDao indexAnalysisEquipmentDao;
    @Autowired
    private EquipmentNumberService equipmentNumberService;

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
        IndexAnalysisEquipmentEntity indexAnalysisEquipmentEntity = indexAnalysisEquipmentDao.selectByPrimaryKey(id);
        if (indexAnalysisEquipmentEntity != null) {
            Integer equipmentNumberId = indexAnalysisEquipmentEntity.getEquipmentNumberId();
            EquipmentNumberEntity equipmentNumberEntity = equipmentNumberService.findById(equipmentNumberId);
            indexAnalysisEquipmentEntity.setEquipmentNumberEntity(equipmentNumberEntity);
        }
        return indexAnalysisEquipmentEntity;
    }


    @Override
    public List<IndexAnalysisEquipmentEntity> findByCondition(String equipmentNumber) {
        return indexAnalysisEquipmentDao.selectByCondition(equipmentNumber);
    }
}
