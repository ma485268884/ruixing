package com.yintu.ruixing.guzhangzhenduan;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
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