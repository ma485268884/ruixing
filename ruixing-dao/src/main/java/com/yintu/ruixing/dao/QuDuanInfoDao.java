package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.QuDuanInfoEntity;

import java.util.List;

public interface QuDuanInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(QuDuanInfoEntity record);

    int insertSelective(QuDuanInfoEntity record);

    QuDuanInfoEntity selectByPrimaryKey(Integer id);

    List<QuDuanInfoEntity> selectByXidAndCid(Integer xid, Integer cid);

    int updateByPrimaryKeySelective(QuDuanInfoEntity record);

    int updateByPrimaryKey(QuDuanInfoEntity record);

}