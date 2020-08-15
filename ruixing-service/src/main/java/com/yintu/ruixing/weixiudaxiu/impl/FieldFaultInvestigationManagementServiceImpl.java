package com.yintu.ruixing.weixiudaxiu.impl;

import com.yintu.ruixing.weixiudaxiu.FieldFaultInvestigationManagementDao;
import com.yintu.ruixing.weixiudaxiu.FieldFaultInvestigationManagementEntity;
import com.yintu.ruixing.weixiudaxiu.FieldFaultInvestigationManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author:mlf
 * @date:2020/7/30 19:23
 */
@Service
@Transactional
public class FieldFaultInvestigationManagementServiceImpl implements FieldFaultInvestigationManagementService {

    @Autowired
    private FieldFaultInvestigationManagementDao fieldFaultInvestigationManagementDao;

    @Override
    public void add(FieldFaultInvestigationManagementEntity entity) {
        fieldFaultInvestigationManagementDao.insertSelective(entity);
    }

    @Override
    public void remove(Integer id) {
        fieldFaultInvestigationManagementDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(FieldFaultInvestigationManagementEntity entity) {
        fieldFaultInvestigationManagementDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public FieldFaultInvestigationManagementEntity findById(Integer id) {
        List<FieldFaultInvestigationManagementEntity> fieldFaultInvestigationManagementEntities = fieldFaultInvestigationManagementDao.connectSelectByCondition(id, null, null);
        return fieldFaultInvestigationManagementEntities.isEmpty() ? null : fieldFaultInvestigationManagementEntities.get(0);
    }

    @Override
    public void remove(Integer[] ids) {
        for (Integer id : ids) {
            this.remove(id);
        }
    }

    @Override
    public List<FieldFaultInvestigationManagementEntity> findByStartDateAndEndDate(Date startDate, Date endDate) {
        return fieldFaultInvestigationManagementDao.connectSelectByCondition(null, startDate, endDate);
    }
}
