package com.yintu.ruixing.danganguanli;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CustomerUnitsDao {
    int deleteByPrimaryKey(Long id);

    int insert(CustomerUnitsEntity record);

    int insertSelective(CustomerUnitsEntity record);

    CustomerUnitsEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CustomerUnitsEntity record);

    int updateByPrimaryKey(CustomerUnitsEntity record);

    List<CustomerUnitsEntity> selectByExample(CustomerUnitsEntity customerUnitsEntity);
}