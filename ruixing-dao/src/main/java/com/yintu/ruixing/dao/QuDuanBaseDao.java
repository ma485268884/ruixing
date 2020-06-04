package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.QuDuanBaseEntity;

public interface QuDuanBaseDao {
    int deleteByPrimaryKey(Integer id);

    int insert(QuDuanBaseEntity record);

    int insertSelective(QuDuanBaseEntity record);

    QuDuanBaseEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuDuanBaseEntity record);

    int updateByPrimaryKey(QuDuanBaseEntity record);
}