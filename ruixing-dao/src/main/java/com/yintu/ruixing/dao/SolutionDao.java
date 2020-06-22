package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.SolutionEntity;

import java.util.List;

public interface SolutionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SolutionEntity record);

    int insertSelective(SolutionEntity record);

    SolutionEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SolutionEntity record);

    int updateByPrimaryKey(SolutionEntity record);

    List<SolutionEntity> selectPartByParentIdAndType(Integer parentId,Short type);

}