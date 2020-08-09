package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.AnZhuangTiaoShiWenTiFileEntity;

public interface AnZhuangTiaoShiWenTiFileDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AnZhuangTiaoShiWenTiFileEntity record);

    int insertSelective(AnZhuangTiaoShiWenTiFileEntity record);

    AnZhuangTiaoShiWenTiFileEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AnZhuangTiaoShiWenTiFileEntity record);

    int updateByPrimaryKey(AnZhuangTiaoShiWenTiFileEntity record);
}