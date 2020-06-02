package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.QuDuanEntity;

import java.util.List;

public interface QuDuanDao {
    int deleteByPrimaryKey(Integer id);

    int insert(QuDuanEntity record);

    int insertSelective(QuDuanEntity record);

    QuDuanEntity selectByPrimaryKey(Integer id);

    List<QuDuanEntity> selectByAll();

    List<QuDuanEntity> selectByCidAndXid(Integer cid, Integer xid);

    int updateByPrimaryKeySelective(QuDuanEntity record);

    int updateByPrimaryKey(QuDuanEntity record);
}