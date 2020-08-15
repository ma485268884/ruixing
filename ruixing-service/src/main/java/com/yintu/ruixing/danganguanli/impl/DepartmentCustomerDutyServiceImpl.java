package com.yintu.ruixing.danganguanli.impl;

import com.yintu.ruixing.danganguanli.DepartmentCustomerDutyDao;
import com.yintu.ruixing.danganguanli.DepartmentCustomerDutyEntity;
import com.yintu.ruixing.danganguanli.DepartmentCustomerDutyEntityExample;
import com.yintu.ruixing.danganguanli.DepartmentCustomerDutyService;
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
