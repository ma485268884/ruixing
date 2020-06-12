package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.MenXianEntity;

import java.util.List;

public interface MenXianDao {
    int deleteByPrimaryKey(Integer id);

    int insert(MenXianEntity record);

    int insertSelective(MenXianEntity record);

    MenXianEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenXianEntity record);

    int updateByPrimaryKey(MenXianEntity record);

    List<MenXianEntity> selectByPropertyIds(Integer[] propertyIds);
}