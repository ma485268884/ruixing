package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.CustomerUnitsDao;
import com.yintu.ruixing.entity.CustomerUnitsEntity;
import com.yintu.ruixing.service.CustomerUnitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author:mlf
 * @date:2020/8/8 20:55
 */
@Service
@Transactional
public class CustomerUnitsServiceImpl implements CustomerUnitsService {
    @Autowired
    private CustomerUnitsDao customerUnitsDao;

    @Override
    public List<CustomerUnitsEntity> findByExample(CustomerUnitsEntity entity) {
        return customerUnitsDao.selectByExample(entity);
    }

    @Override
    public void removeByIds(Integer[] ids) {
        for (Integer id : ids) {
            this.remove(id);
        }
    }

    @Override
    public void add(CustomerUnitsEntity entity) {
        entity.setCreateTime(new Date());
        entity.setModifiedTime(new Date());
        customerUnitsDao.insertSelective(entity);
    }

    @Override
    public void remove(Integer id) {
        customerUnitsDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(CustomerUnitsEntity entity) {
        entity.setModifiedTime(new Date());
        customerUnitsDao.updateByPrimaryKeySelective(entity);

    }

    @Override
    public CustomerUnitsEntity findById(Integer id) {
        return customerUnitsDao.selectByPrimaryKey(id);
    }
}
