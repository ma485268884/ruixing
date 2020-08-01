package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.AnZhuangTiaoShiWorksCheZhanEntity;

public interface AnZhuangTiaoShiWorksCheZhanDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AnZhuangTiaoShiWorksCheZhanEntity record);

    AnZhuangTiaoShiWorksCheZhanEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AnZhuangTiaoShiWorksCheZhanEntity record);


    //////////////////////////////////////////////////

    int insertSelective(AnZhuangTiaoShiWorksCheZhanEntity record);

    int updateByPrimaryKey(AnZhuangTiaoShiWorksCheZhanEntity record);
}