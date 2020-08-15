package com.yintu.ruixing.danganguanli;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CustomerDutyDao {
    long countByExample(CustomerDutyEntityExample example);

    int deleteByExample(CustomerDutyEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustomerDutyEntity record);

    int insertSelective(CustomerDutyEntity record);

    List<CustomerDutyEntity> selectByExample(CustomerDutyEntityExample example);

    CustomerDutyEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustomerDutyEntity record, @Param("example") CustomerDutyEntityExample example);

    int updateByExample(@Param("record") CustomerDutyEntity record, @Param("example") CustomerDutyEntityExample example);

    int updateByPrimaryKeySelective(CustomerDutyEntity record);

    int updateByPrimaryKey(CustomerDutyEntity record);
}