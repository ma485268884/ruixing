package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.CustomerDutyEntity;

import java.util.List;

public interface CustomerDutyDao {
    int deleteByPrimaryKey(Long id);

    int insert(CustomerDutyEntity record);

    int insertSelective(CustomerDutyEntity record);

    CustomerDutyEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CustomerDutyEntity record);

    int updateByPrimaryKey(CustomerDutyEntity record);

    List<CustomerDutyEntity> selectByExample(CustomerDutyEntity customerDutyEntity);

}