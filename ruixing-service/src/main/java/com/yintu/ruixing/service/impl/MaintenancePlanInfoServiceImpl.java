package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.MaintenancePlanInfoDao;
import com.yintu.ruixing.entity.MaintenancePlanInfoEntity;
import com.yintu.ruixing.service.MaintenancePlanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/7/9 16:40
 */
@Service
@Transactional
public class MaintenancePlanInfoServiceImpl implements MaintenancePlanInfoService {

    @Autowired
    private MaintenancePlanInfoDao maintenancePlanInfoDao;

    @Override
    public void add(MaintenancePlanInfoEntity entity) {
        maintenancePlanInfoDao.insertSelective(entity);
    }

    @Override
    public void remove(Integer id) {
        maintenancePlanInfoDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(MaintenancePlanInfoEntity entity) {
        maintenancePlanInfoDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public MaintenancePlanInfoEntity findById(Integer id) {
        return maintenancePlanInfoDao.selectByPrimaryKey(id);
    }




    @Override
    public List<MaintenancePlanInfoEntity> findByMaintenancePlanId(Integer maintenancePlanId) {
        return maintenancePlanInfoDao.selectByMaintenancePlanId(maintenancePlanId);
    }
}
