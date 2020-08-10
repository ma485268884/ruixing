package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.CustomerUnitsEntity;

import java.util.List;

public interface CustomerUnitsDao {
    int deleteByPrimaryKey(Long id);

    int insert(CustomerUnitsEntity record);

    int insertSelective(CustomerUnitsEntity record);

    CustomerUnitsEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CustomerUnitsEntity record);

    int updateByPrimaryKey(CustomerUnitsEntity record);

    List<CustomerUnitsEntity> selectByExample(CustomerUnitsEntity customerUnitsEntity);
}