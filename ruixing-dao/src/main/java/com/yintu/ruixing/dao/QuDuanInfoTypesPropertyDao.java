package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.QuDuanInfoTypesPropertyEntity;

import java.util.List;
import java.util.Map;

public interface QuDuanInfoTypesPropertyDao {
    int deleteByPrimaryKey(Integer id);

    int insert(QuDuanInfoTypesPropertyEntity record);

    int insertSelective(QuDuanInfoTypesPropertyEntity record);

    QuDuanInfoTypesPropertyEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuDuanInfoTypesPropertyEntity record);

    int updateByPrimaryKey(QuDuanInfoTypesPropertyEntity record);

    List<QuDuanInfoTypesPropertyEntity> connectSelectByCondition(String types);

    String countByType(List<Integer> types);

}