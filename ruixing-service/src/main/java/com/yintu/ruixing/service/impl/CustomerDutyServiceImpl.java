package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.CustomerDutyDao;
import com.yintu.ruixing.entity.CustomerDutyEntity;
import com.yintu.ruixing.entity.DepartmentCustomerDutyEntity;
import com.yintu.ruixing.entity.DepartmentCustomerDutyEntityExample;
import com.yintu.ruixing.entity.DepartmentEntity;
import com.yintu.ruixing.service.CustomerDutyService;
import com.yintu.ruixing.service.DepartmentCustomerDutyService;
import com.yintu.ruixing.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author:mlf
 * @date:2020/8/10 14:28
 */
@Service
@Transactional
public class CustomerDutyServiceImpl implements CustomerDutyService {

    @Autowired
    private CustomerDutyDao customerDutyDao;

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DepartmentCustomerDutyService departmentCustomerDutyService;


    @Override
    public List<CustomerDutyEntity> findByExample(CustomerDutyEntity entity) {
        return customerDutyDao.selectByExample(entity);
    }

    @Override
    public void removeByIds(Long[] ids) {
        for (Long id : ids) {
            this.remove(id);
        }
    }

    @Override
    public void add(CustomerDutyEntity entity) {
        entity.setCreateTime(new Date());
        entity.setModifiedTime(new Date());
        customerDutyDao.insertSelective(entity);
    }

    @Override
    public void remove(Long id) {
        customerDutyDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(CustomerDutyEntity entity) {
        entity.setModifiedTime(new Date());
        customerDutyDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public CustomerDutyEntity findById(Long id) {
        return customerDutyDao.selectByPrimaryKey(id);
    }

    @Override
    public void add(CustomerDutyEntity entity, Long[] departmentIds, String loginUserName) {
        this.add(entity);
        for (Long departmentId : departmentIds) {
            DepartmentCustomerDutyEntity departmentCustomerDutyEntity = new DepartmentCustomerDutyEntity();
            departmentCustomerDutyEntity.setCreateBy(loginUserName);
            departmentCustomerDutyEntity.setCreateTime(new Date());
            departmentCustomerDutyEntity.setModifiedBy(loginUserName);
            departmentCustomerDutyEntity.setModifiedTime(new Date());
            departmentCustomerDutyEntity.setDepartmentId(departmentId);
            departmentCustomerDutyEntity.setDutyId(entity.getId());
            departmentCustomerDutyService.add(departmentCustomerDutyEntity);
        }
    }

    @Override
    public void edit(CustomerDutyEntity entity, Long[] departmentIds, String loginUserName) {
        this.edit(entity);
        DepartmentCustomerDutyEntityExample departmentCustomerDutyEntityExample = new DepartmentCustomerDutyEntityExample();
        DepartmentCustomerDutyEntityExample.Criteria criteria = departmentCustomerDutyEntityExample.createCriteria();
        criteria.andDutyIdEqualTo(entity.getId());
        departmentCustomerDutyService.removeByExample(departmentCustomerDutyEntityExample);
        for (Long departmentId : departmentIds) {
            DepartmentCustomerDutyEntity departmentCustomerDutyEntity = new DepartmentCustomerDutyEntity();
            departmentCustomerDutyEntity.setCreateBy(loginUserName);
            departmentCustomerDutyEntity.setCreateTime(new Date());
            departmentCustomerDutyEntity.setModifiedBy(loginUserName);
            departmentCustomerDutyEntity.setModifiedTime(new Date());
            departmentCustomerDutyEntity.setDepartmentId(departmentId);
            departmentCustomerDutyEntity.setDutyId(entity.getId());
            departmentCustomerDutyService.add(departmentCustomerDutyEntity);
        }
    }

    @Override
    public List<DepartmentEntity> findDepartmentsById(Long id) {
        DepartmentCustomerDutyEntityExample departmentCustomerDutyEntityExample = new DepartmentCustomerDutyEntityExample();
        DepartmentCustomerDutyEntityExample.Criteria criteria = departmentCustomerDutyEntityExample.createCriteria();
        criteria.andDutyIdEqualTo(id);
        List<DepartmentCustomerDutyEntity> departmentCustomerDutyEntities = departmentCustomerDutyService.findByExample(departmentCustomerDutyEntityExample);
        List<Long> departmentIds = departmentCustomerDutyEntities.stream().map(DepartmentCustomerDutyEntity::getDepartmentId).collect(Collectors.toList());
        return departmentService.findByIds(departmentIds);
    }
}
