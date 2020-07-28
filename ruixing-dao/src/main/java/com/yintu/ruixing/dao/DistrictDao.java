package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.DistrictEntity;

import java.util.List;

public interface DistrictDao {
    int deleteByPrimaryKey(Integer id);

    int insert(DistrictEntity record);

    int insertSelective(DistrictEntity record);

    DistrictEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DistrictEntity record);

    int updateByPrimaryKey(DistrictEntity record);

    List<DistrictEntity> selectByParentId(Integer parentId);
}