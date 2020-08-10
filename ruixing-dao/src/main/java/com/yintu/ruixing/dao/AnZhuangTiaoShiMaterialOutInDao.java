package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.AnZhuangTiaoShiMaterialOutInEntity;

import java.util.List;

public interface AnZhuangTiaoShiMaterialOutInDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AnZhuangTiaoShiMaterialOutInEntity record);

    AnZhuangTiaoShiMaterialOutInEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AnZhuangTiaoShiMaterialOutInEntity record);

    int updateByPrimaryKey(AnZhuangTiaoShiMaterialOutInEntity record);


    ////////////////////////////////////////////////////////////
    int insertSelective(AnZhuangTiaoShiMaterialOutInEntity record);

    List<AnZhuangTiaoShiMaterialOutInEntity> findAllOutMaterial(String materialNumber);

    List<AnZhuangTiaoShiMaterialOutInEntity> findAllInMaterial(String materialNumber);
}