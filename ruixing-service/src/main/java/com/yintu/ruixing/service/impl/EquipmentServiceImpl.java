package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.EquipmentDao;
import com.yintu.ruixing.entity.EquipmentEntity;
import com.yintu.ruixing.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/7/15 10:18
 */
@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    private EquipmentDao equipmentDao;

    @Override
    public void add(EquipmentEntity entity) {
        equipmentDao.insertSelective(entity);
    }

    @Override
    public void remove(Integer id) {
        equipmentDao.deleteByPrimaryKey(id);

    }

    @Override
    public void edit(EquipmentEntity entity) {
        equipmentDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public EquipmentEntity findById(Integer id) {
        return equipmentDao.selectByPrimaryKey(id);
    }

    @Override
    public List<EquipmentEntity> findAll() {
        return equipmentDao.selectAll();
    }

    @Override
    public List<EquipmentEntity> findByName(String name) {
        return equipmentDao.selectByName(name);
    }
}
