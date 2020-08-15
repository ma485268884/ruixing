package com.yintu.ruixing.guzhangzhenduan;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface YuJingDao {
    int deleteByPrimaryKey(Integer id);

    int insert(YuJingEntity record);

    int insertSelective(YuJingEntity record);

    YuJingEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YuJingEntity record);

    int updateByPrimaryKey(YuJingEntity record);
}