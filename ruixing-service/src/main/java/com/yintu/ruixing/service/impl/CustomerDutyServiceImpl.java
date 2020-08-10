package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.CustomerDutyDao;
import com.yintu.ruixing.entity.CustomerDutyEntity;
import com.yintu.ruixing.service.CustomerDutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author:mlf
 * @date:2020/8/10 14:28
 */
@Service
@Transactional
public class CustomerDutyServiceImpl implements CustomerDutyService {

    @Autowired
    private CustomerDutyDao customerDutyDao;

    @Override
    public List<CustomerDutyEntity> findByExample(CustomerDutyEntity entity) {
        return customerDutyDao.selectByExample(entity);
    }

    @Override
    public void removeByIds(Integer[] ids) {
        for (Integer id : ids) {
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
    public void remove(Integer id) {
        customerDutyDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(CustomerDutyEntity entity) {
        entity.setModifiedTime(new Date());
        customerDutyDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public CustomerDutyEntity findById(Integer id) {
        return customerDutyDao.selectByPrimaryKey(id);
    }
}
