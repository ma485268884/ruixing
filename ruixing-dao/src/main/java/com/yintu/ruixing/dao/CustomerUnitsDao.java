package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.CustomerUnitsEntity;

import java.util.List;

public interface CustomerUnitsDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CustomerUnitsEntity record);

    int insertSelective(CustomerUnitsEntity record);

    CustomerUnitsEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CustomerUnitsEntity record);

    int updateByPrimaryKey(CustomerUnitsEntity record);

    List<CustomerUnitsEntity> selectByName(CustomerUnitsEntity customerUnitsEntity);
}