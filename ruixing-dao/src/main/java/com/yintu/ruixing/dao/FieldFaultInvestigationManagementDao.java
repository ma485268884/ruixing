package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.FieldFaultInvestigationManagementEntity;

import java.util.Date;
import java.util.List;

public interface FieldFaultInvestigationManagementDao {
    int deleteByPrimaryKey(Integer id);

    int insert(FieldFaultInvestigationManagementEntity record);

    int insertSelective(FieldFaultInvestigationManagementEntity record);

    FieldFaultInvestigationManagementEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FieldFaultInvestigationManagementEntity record);

    int updateByPrimaryKey(FieldFaultInvestigationManagementEntity record);

    List<FieldFaultInvestigationManagementEntity> connectSelectByCondition(Integer id, Date startDate, Date endDate);

}