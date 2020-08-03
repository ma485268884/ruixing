package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.EquipmentReprocessedProductManagementDao;
import com.yintu.ruixing.entity.EquipmentReprocessedProductManagementEntity;
import com.yintu.ruixing.service.EquipmentReprocessedProductManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/8/3 16:31
 */
@Service
@Transactional
public class EquipmentReprocessedProductManagementServiceImpl implements EquipmentReprocessedProductManagementService {

    @Autowired
    private EquipmentReprocessedProductManagementDao equipmentReprocessedProductManagementDao;

    @Override
    public void add(EquipmentReprocessedProductManagementEntity entity) {
        equipmentReprocessedProductManagementDao.insertSelective(entity);
    }

    @Override
    public void remove(Integer id) {
        equipmentReprocessedProductManagementDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(EquipmentReprocessedProductManagementEntity entity) {
        equipmentReprocessedProductManagementDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public EquipmentReprocessedProductManagementEntity findById(Integer id) {
        List<EquipmentReprocessedProductManagementEntity> equipmentFaultManagementEntities = equipmentReprocessedProductManagementDao.connectSelectByCondition(id, null);
        return equipmentFaultManagementEntities.isEmpty() ? null : equipmentFaultManagementEntities.get(0);
    }

    @Override
    public void remove(Integer[] ids) {
        for (Integer id : ids) {
            this.remove(id);
        }
    }

    @Override
    public List<EquipmentReprocessedProductManagementEntity> findByEquipmentNumber(String equipmentNumber) {
        return equipmentReprocessedProductManagementDao.connectSelectByCondition(null, equipmentNumber);
    }
}
