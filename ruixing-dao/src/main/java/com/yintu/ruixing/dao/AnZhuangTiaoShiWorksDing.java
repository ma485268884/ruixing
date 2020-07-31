package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.AnZhuangTiaoShiWorksDingEntity;

public interface AnZhuangTiaoShiWorksDing {
    int deleteByPrimaryKey(Integer id);

    int insert(AnZhuangTiaoShiWorksDingEntity record);

    int insertSelective(AnZhuangTiaoShiWorksDingEntity record);

    AnZhuangTiaoShiWorksDingEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AnZhuangTiaoShiWorksDingEntity record);

    int updateByPrimaryKey(AnZhuangTiaoShiWorksDingEntity record);
}