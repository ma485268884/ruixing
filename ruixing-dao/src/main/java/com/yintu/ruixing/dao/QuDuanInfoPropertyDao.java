package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.QuDuanInfoPropertyEntity;

import java.util.List;

public interface QuDuanInfoPropertyDao {
    int deleteByPrimaryKey(Integer id);

    int insert(QuDuanInfoPropertyEntity record);

    int insertSelective(QuDuanInfoPropertyEntity record);

    QuDuanInfoPropertyEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuDuanInfoPropertyEntity record);

    int updateByPrimaryKey(QuDuanInfoPropertyEntity record);

    List<QuDuanInfoPropertyEntity> selectByType(Short type);

    List<QuDuanInfoPropertyEntity> selectByIds(Integer[] ids);
}