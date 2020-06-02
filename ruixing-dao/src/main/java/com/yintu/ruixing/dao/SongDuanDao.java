package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.ShouDuanEntity;
import com.yintu.ruixing.entity.SongDuanEntity;

import java.util.List;

public interface SongDuanDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SongDuanEntity record);

    int insertSelective(SongDuanEntity record);

    SongDuanEntity selectByPrimaryKey(Integer id);

    List<SongDuanEntity> selectByAll();

    List<SongDuanEntity> selectByCidAndXid(Integer cid, Integer xid);

    int updateByPrimaryKeySelective(SongDuanEntity record);

    int updateByPrimaryKey(SongDuanEntity record);
}