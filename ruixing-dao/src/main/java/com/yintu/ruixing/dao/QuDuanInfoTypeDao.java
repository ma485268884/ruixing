package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.QuDuanInfoTypeEntity;

public interface QuDuanInfoTypeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(QuDuanInfoTypeEntity record);

    int insertSelective(QuDuanInfoTypeEntity record);

    QuDuanInfoTypeEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuDuanInfoTypeEntity record);

    int updateByPrimaryKey(QuDuanInfoTypeEntity record);
}