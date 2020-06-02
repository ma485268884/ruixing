package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.TransformerSongDuanEntity;
import com.yintu.ruixing.entity.TuningEntity;

import java.util.List;

public interface TuningDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TuningEntity record);

    int insertSelective(TuningEntity record);

    TuningEntity selectByPrimaryKey(Integer id);

    List<TuningEntity> selectByAll();

    List<TuningEntity> selectByCidAndXid(Integer cid, Integer xid);

    int updateByPrimaryKeySelective(TuningEntity record);

    int updateByPrimaryKey(TuningEntity record);
}