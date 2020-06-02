package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.FenXianPanEntity;
import com.yintu.ruixing.entity.QuDuanEntity;

import java.util.List;

public interface FenXianPanDao {
    int deleteByPrimaryKey(Integer id);

    int insert(FenXianPanEntity record);

    int insertSelective(FenXianPanEntity record);

    FenXianPanEntity selectByPrimaryKey(Integer id);

    List<FenXianPanEntity> selectAll();

    List<FenXianPanEntity> selectByCidAndXid(Integer cid, Integer xid);

    int updateByPrimaryKeySelective(FenXianPanEntity record);

    int updateByPrimaryKey(FenXianPanEntity record);
}