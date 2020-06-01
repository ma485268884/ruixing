package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.YuJingEntity;
import java.util.List;

public interface YuJingDao {
    int deleteByPrimaryKey(Integer id);

    int insert(YuJingEntity record);

    YuJingEntity selectByPrimaryKey(Integer id);

    List<YuJingEntity> selectAll();

    int updateByPrimaryKey(YuJingEntity record);
}