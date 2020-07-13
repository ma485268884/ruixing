package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.AnZhuangTiaoShiFileEntity;

public interface AnZhuangTiaoShiFileDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AnZhuangTiaoShiFileEntity record);

    int insertSelective(AnZhuangTiaoShiFileEntity record);

    AnZhuangTiaoShiFileEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AnZhuangTiaoShiFileEntity record);

    int updateByPrimaryKey(AnZhuangTiaoShiFileEntity record);


}