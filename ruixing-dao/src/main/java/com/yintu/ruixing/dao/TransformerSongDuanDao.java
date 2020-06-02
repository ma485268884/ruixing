package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.TransformerShouDuanEntity;
import com.yintu.ruixing.entity.TransformerSongDuanEntity;

import java.util.List;

public interface TransformerSongDuanDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TransformerSongDuanEntity record);

    int insertSelective(TransformerSongDuanEntity record);

    TransformerSongDuanEntity selectByPrimaryKey(Integer id);

    List<TransformerSongDuanEntity> selectByAll();

    List<TransformerSongDuanEntity> selectByCidAndXid(Integer cid, Integer xid);

    int updateByPrimaryKeySelective(TransformerSongDuanEntity record);

    int updateByPrimaryKey(TransformerSongDuanEntity record);
}