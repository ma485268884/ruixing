package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.BaoJingEntity;
import java.util.List;

public interface BaoJingDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BaoJingEntity record);

    BaoJingEntity selectByPrimaryKey(Integer id);

    List<BaoJingEntity> selectAll();

    int updateByPrimaryKey(BaoJingEntity record);
}