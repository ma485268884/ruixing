package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.ShouDuanEntity;

import java.util.List;

public interface ShouDuanDao {

    int deleteByPrimaryKey(Integer id);

    int insert(ShouDuanEntity record);

    int insertSelective(ShouDuanEntity record);

    ShouDuanEntity selectByPrimaryKey(Integer id);

    List<ShouDuanEntity> selectByAll();

    List<ShouDuanEntity> selectByCidAndXid(Integer cid, Integer xid);

    int updateByPrimaryKeySelective(ShouDuanEntity record);

    int updateByPrimaryKey(ShouDuanEntity record);
}