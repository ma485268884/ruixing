package com.yintu.ruixing.weixiudaxiu.impl;

import com.yintu.ruixing.weixiudaxiu.EquipmentNumberDao;
import com.yintu.ruixing.weixiudaxiu.EquipmentNumberEntity;
import com.yintu.ruixing.weixiudaxiu.EquipmentNumberService;
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
        List<EquipmentNumberEntity> equipmentNumberEntities = equipmentNumberDao.selectByCondition(new Integer[]{id}, null);
        return equipmentNumberEntities.isEmpty() ? null : equipmentNumberEntities.get(0);
    }

    @Override
    public List<EquipmentNumberEntity> findByCondition(Integer[] ids, String equipmentNumber) {
        return equipmentNumberDao.selectByCondition(ids, equipmentNumber);
    }

    @Override
    public void removeMuch(Integer[] ids) {
        equipmentNumberDao.deleteMuch(ids);
    }
}
