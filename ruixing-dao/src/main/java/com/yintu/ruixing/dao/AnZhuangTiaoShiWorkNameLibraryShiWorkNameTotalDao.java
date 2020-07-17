package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.AnZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity;

public interface AnZhuangTiaoShiWorkNameLibraryShiWorkNameTotalDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AnZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity record);

    AnZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AnZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity record);

    int updateByPrimaryKey(AnZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity record);

    ///////////////////////////////////////////////////

    int insertSelective(AnZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity record);
}