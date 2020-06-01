package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.BaoJingEntity;

public interface BaoJingDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BaoJingEntity record);

    int insertSelective(BaoJingEntity record);

    BaoJingEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaoJingEntity record);

    int updateByPrimaryKey(BaoJingEntity record);
}