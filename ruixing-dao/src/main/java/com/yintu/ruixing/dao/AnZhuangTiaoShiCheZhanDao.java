package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.AnZhuangTiaoShiCheZhanEntity;

import java.util.List;

public interface AnZhuangTiaoShiCheZhanDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AnZhuangTiaoShiCheZhanEntity record);

    int insertSelective(AnZhuangTiaoShiCheZhanEntity record);

    AnZhuangTiaoShiCheZhanEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AnZhuangTiaoShiCheZhanEntity record);

    int updateByPrimaryKey(AnZhuangTiaoShiCheZhanEntity record);


    ///////////////////////////////////////////////////

    void addCheZhan(AnZhuangTiaoShiCheZhanEntity anZhuangTiaoShiCheZhanEntity);

    List<AnZhuangTiaoShiCheZhanEntity> findCheZhanById(Integer id);

    void editCheZhanById(AnZhuangTiaoShiCheZhanEntity anZhuangTiaoShiCheZhanEntity);

    void deleteCheZhanByIds(Integer[] ids);

    List<AnZhuangTiaoShiCheZhanEntity> findCheZhanByName(String czname);
}