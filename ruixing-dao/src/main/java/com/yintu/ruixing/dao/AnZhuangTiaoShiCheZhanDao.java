package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.AnZhuangTiaoShiCheZhanEntity;

public interface AnZhuangTiaoShiCheZhanDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AnZhuangTiaoShiCheZhanEntity record);

    int insertSelective(AnZhuangTiaoShiCheZhanEntity record);

    AnZhuangTiaoShiCheZhanEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AnZhuangTiaoShiCheZhanEntity record);

    int updateByPrimaryKey(AnZhuangTiaoShiCheZhanEntity record);
    ////////////////////////////////////////////////////////

    void addCheZhan(AnZhuangTiaoShiCheZhanEntity anZhuangTiaoShiCheZhanEntity);
}