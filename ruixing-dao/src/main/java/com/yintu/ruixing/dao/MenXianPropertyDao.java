package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.MenXianPropertyEntity;

public interface MenXianPropertyDao {
    int deleteByPrimaryKey(Integer id);

    int insert(MenXianPropertyEntity record);

    int insertSelective(MenXianPropertyEntity record);

    MenXianPropertyEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenXianPropertyEntity record);

    int updateByPrimaryKey(MenXianPropertyEntity record);
}