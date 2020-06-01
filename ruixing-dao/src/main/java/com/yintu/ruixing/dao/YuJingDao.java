package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.YuJingEntity;

public interface YuJingDao {
    int deleteByPrimaryKey(Integer id);

    int insert(YuJingEntity record);

    int insertSelective(YuJingEntity record);

    YuJingEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YuJingEntity record);

    int updateByPrimaryKey(YuJingEntity record);
}