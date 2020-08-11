package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.DepartmentCustomerDutyEntity;
import com.yintu.ruixing.entity.DepartmentCustomerDutyEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepartmentCustomerDutyDao {
    long countByExample(DepartmentCustomerDutyEntityExample example);

    int deleteByExample(DepartmentCustomerDutyEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DepartmentCustomerDutyEntity record);

    int insertSelective(DepartmentCustomerDutyEntity record);

    List<DepartmentCustomerDutyEntity> selectByExample(DepartmentCustomerDutyEntityExample example);

    DepartmentCustomerDutyEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DepartmentCustomerDutyEntity record, @Param("example") DepartmentCustomerDutyEntityExample example);

    int updateByExample(@Param("record") DepartmentCustomerDutyEntity record, @Param("example") DepartmentCustomerDutyEntityExample example);

    int updateByPrimaryKeySelective(DepartmentCustomerDutyEntity record);

    int updateByPrimaryKey(DepartmentCustomerDutyEntity record);
}