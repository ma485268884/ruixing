package com.yintu.ruixing.weixiudaxiu;

import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
@Mapper
public interface FieldFaultInvestigationManagementDao {
    int deleteByPrimaryKey(Integer id);

    int insert(FieldFaultInvestigationManagementEntity record);

    int insertSelective(FieldFaultInvestigationManagementEntity record);

    FieldFaultInvestigationManagementEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FieldFaultInvestigationManagementEntity record);

    int updateByPrimaryKey(FieldFaultInvestigationManagementEntity record);

    List<FieldFaultInvestigationManagementEntity> connectSelectByCondition(Integer id, Date startDate, Date endDate);

}