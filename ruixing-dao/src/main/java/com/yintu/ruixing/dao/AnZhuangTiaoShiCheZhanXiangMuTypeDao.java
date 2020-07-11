package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.AnZhuangTiaoShiCheZhanXiangMuTypeEntity;

import java.util.List;

public interface AnZhuangTiaoShiCheZhanXiangMuTypeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AnZhuangTiaoShiCheZhanXiangMuTypeEntity record);

    int insertSelective(AnZhuangTiaoShiCheZhanXiangMuTypeEntity record);

    AnZhuangTiaoShiCheZhanXiangMuTypeEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AnZhuangTiaoShiCheZhanXiangMuTypeEntity record);

    int updateByPrimaryKey(AnZhuangTiaoShiCheZhanXiangMuTypeEntity record);

    /////////////////////////////////////////////////

    void addXiangMuType(AnZhuangTiaoShiCheZhanXiangMuTypeEntity anZhuangTiaoShiCheZhanXiangMuTypeEntity);

    List<AnZhuangTiaoShiCheZhanXiangMuTypeEntity> findAllXiangMuType();
}