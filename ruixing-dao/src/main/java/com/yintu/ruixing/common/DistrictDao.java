package com.yintu.ruixing.common;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface DistrictDao {
    int deleteByPrimaryKey(Integer id);

    int insert(DistrictEntity record);

    int insertSelective(DistrictEntity record);

    DistrictEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DistrictEntity record);

    int updateByPrimaryKey(DistrictEntity record);

    List<DistrictEntity> selectByParentId(Integer parentId);
}