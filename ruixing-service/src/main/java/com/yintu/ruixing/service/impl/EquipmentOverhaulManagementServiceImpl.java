package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.EquipmentOverhaulManagementDao;
import com.yintu.ruixing.entity.EquipmentOverhaulManagementEntity;
import com.yintu.ruixing.service.EquipmentOverhaulManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/7/28 16:56
 */
@Service
@Transactional
public class EquipmentOverhaulManagementServiceImpl implements EquipmentOverhaulManagementService {

    @Autowired
    private EquipmentOverhaulManagementDao equipmentOverhaulManagementDao;


    @Override
    public void add(EquipmentOverhaulManagementEntity entity) {
        equipmentOverhaulManagementDao.insertSelective(entity);
    }

    @Override
    public void remove(Integer id) {
        equipmentOverhaulManagementDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(EquipmentOverhaulManagementEntity entity) {
        equipmentOverhaulManagementDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public EquipmentOverhaulManagementEntity findById(Integer id) {
        List<EquipmentOverhaulManagementEntity> equipmentOverhaulManagementEntities = equipmentOverhaulManagementDao.connectSelectByCondition(id, null);
        return equipmentOverhaulManagementEntities.isEmpty() ? null : equipmentOverhaulManagementEntities.get(0);
    }

    @Override
    public void remove(Integer[] ids) {
        for (Integer id : ids) {
            this.remove(id);
        }
    }

    @Override
    public List<EquipmentOverhaulManagementEntity> findByEquipmentNumber(String equipmentNumber) {
        return equipmentOverhaulManagementDao.connectSelectByCondition(null, equipmentNumber);
    }
}
