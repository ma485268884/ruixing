package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.EquipmentNumberDao;
import com.yintu.ruixing.entity.EquipmentNumberEntity;
import com.yintu.ruixing.service.EquipmentNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/7/13 11:08
 */
@Service
@Transactional
public class EquipmentNumberServiceImpl implements EquipmentNumberService {

    @Autowired
    private EquipmentNumberDao equipmentNumberDao;

    @Override
    public void add(EquipmentNumberEntity entity) {
        equipmentNumberDao.insertSelective(entity);
    }

    @Override
    public void remove(Integer id) {
        equipmentNumberDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(EquipmentNumberEntity entity) {
        equipmentNumberDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public EquipmentNumberEntity findById(Integer id) {
        return equipmentNumberDao.selectByPrimaryKey(id);
    }
    
    @Override
    public List<EquipmentNumberEntity> findByEquipmentNumber(String equipmentNumber) {
        return equipmentNumberDao.selectByEquipmentNumber(equipmentNumber);
    }
}
