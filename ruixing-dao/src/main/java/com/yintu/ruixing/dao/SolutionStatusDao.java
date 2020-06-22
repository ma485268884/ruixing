package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.SolutionStatusEntity;

public interface SolutionStatusDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SolutionStatusEntity record);

    int insertSelective(SolutionStatusEntity record);

    SolutionStatusEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SolutionStatusEntity record);

    int updateByPrimaryKey(SolutionStatusEntity record);
}