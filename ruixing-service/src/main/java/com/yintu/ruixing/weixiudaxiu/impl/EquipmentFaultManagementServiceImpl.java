package com.yintu.ruixing.weixiudaxiu.impl;

import com.yintu.ruixing.weixiudaxiu.EquipmentFaultManagementDao;
import com.yintu.ruixing.weixiudaxiu.EquipmentFaultManagementEntity;
import com.yintu.ruixing.weixiudaxiu.EquipmentFaultManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author:mlf
 * @date:2020/7/29 16:27
 */
@Service
@Transactional
public class EquipmentFaultManagementServiceImpl implements EquipmentFaultManagementService {
    @Autowired
    private EquipmentFaultManagementDao equipmentFaultManagementDao;

    @Override
    public void add(EquipmentFaultManagementEntity entity) {
        equipmentFaultManagementDao.insertSelective(entity);
    }

    @Override
    public void remove(Integer id) {
        equipmentFaultManagementDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(EquipmentFaultManagementEntity entity) {
        equipmentFaultManagementDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public EquipmentFaultManagementEntity findById(Integer id) {
        List<EquipmentFaultManagementEntity> equipmentFaultManagementEntities = equipmentFaultManagementDao.connectSelectByCondition(id, null, null);
        return equipmentFaultManagementEntities.isEmpty() ? null : equipmentFaultManagementEntities.get(0);
    }

    @Override
    public void remove(Integer[] ids) {
        for (Integer id : ids) {
            this.remove(id);
        }
    }

    @Override
    public List<EquipmentFaultManagementEntity> findByStartDateAndEndDate(Date startDate, Date endDate) {
        return equipmentFaultManagementDao.connectSelectByCondition(null, startDate, endDate);
    }


}
