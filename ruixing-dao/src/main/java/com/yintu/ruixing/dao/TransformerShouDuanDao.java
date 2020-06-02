package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.SongDuanEntity;
import com.yintu.ruixing.entity.TransformerShouDuanEntity;

import java.util.List;

public interface TransformerShouDuanDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TransformerShouDuanEntity record);

    int insertSelective(TransformerShouDuanEntity record);

    TransformerShouDuanEntity selectByPrimaryKey(Integer id);

    List<TransformerShouDuanEntity> selectByAll();

    List<TransformerShouDuanEntity> selectByCidAndXid(Integer cid, Integer xid);

    int updateByPrimaryKeySelective(TransformerShouDuanEntity record);

    int updateByPrimaryKey(TransformerShouDuanEntity record);
}