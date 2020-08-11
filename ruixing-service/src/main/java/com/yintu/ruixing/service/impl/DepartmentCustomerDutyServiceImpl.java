package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.DepartmentCustomerDutyDao;
import com.yintu.ruixing.entity.DepartmentCustomerDutyEntity;
import com.yintu.ruixing.entity.DepartmentCustomerDutyEntityExample;
import com.yintu.ruixing.entity.DepartmentUserEntity;
import com.yintu.ruixing.entity.DepartmentUserEntityExample;
import com.yintu.ruixing.service.DepartmentCustomerDutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author:mlf
 * @date:2020/8/11 11:05
 */
@Service
public class DepartmentCustomerDutyServiceImpl implements DepartmentCustomerDutyService {
    @Autowired
    private DepartmentCustomerDutyDao departmentCustomerDutyDao;

    @Override
    public List<DepartmentCustomerDutyEntity> findByExample(DepartmentCustomerDutyEntityExample departmentCustomerDutyEntityExample) {
        return departmentCustomerDutyDao.selectByExample(departmentCustomerDutyEntityExample);
    }

    @Override
    public void removeByExample(DepartmentCustomerDutyEntityExample departmentCustomerDutyEntityExample) {
        departmentCustomerDutyDao.deleteByExample(departmentCustomerDutyEntityExample);
    }

    @Override
    public void add(DepartmentCustomerDutyEntity entity) {
        entity.setCreateTime(new Date());
        entity.setModifiedTime(new Date());
        departmentCustomerDutyDao.insertSelective(entity);
    }

    @Override
    public void remove(Long id) {
        departmentCustomerDutyDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(DepartmentCustomerDutyEntity entity) {
        entity.setModifiedTime(new Date());
        departmentCustomerDutyDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public DepartmentCustomerDutyEntity findById(Long id) {
        return departmentCustomerDutyDao.selectByPrimaryKey(id);
    }


}
