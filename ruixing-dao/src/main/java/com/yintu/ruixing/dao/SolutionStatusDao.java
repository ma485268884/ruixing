package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.SolutionStatusEntity;

import java.util.List;

public interface SolutionStatusDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SolutionStatusEntity record);

    int insertSelective(SolutionStatusEntity record);

    SolutionStatusEntity selectByPrimaryKey(Integer id);

    List<SolutionStatusEntity> selectByFileNameAndType(String fileName, Short type);

    int updateByPrimaryKeySelective(SolutionStatusEntity record);

    int updateByPrimaryKey(SolutionStatusEntity record);

    List<SolutionStatusEntity> selectByYearIdOrProjectIdOrFileTypeIdAndType(Integer id, Short nameType, Short type);

    List<SolutionStatusEntity> selectByProjectNameAndType(String projectName, Short type);

    List<SolutionStatusEntity> selectByIdsAndType(Integer[] ids, Short type);
}