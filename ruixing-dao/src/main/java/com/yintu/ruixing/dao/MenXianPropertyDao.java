package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.MenXianPropertyEntity;

import java.util.List;

public interface MenXianPropertyDao {
    int deleteByPrimaryKey(Integer id);

    int insert(MenXianPropertyEntity record);

    int insertSelective(MenXianPropertyEntity record);

    MenXianPropertyEntity selectByPrimaryKey(Integer id);

    List<MenXianPropertyEntity> selectByParentId(Integer parentId);

    List<MenXianPropertyEntity> selectByNotParentId(Integer parentId);

    int updateByPrimaryKeySelective(MenXianPropertyEntity record);

    int updateByPrimaryKey(MenXianPropertyEntity record);
}