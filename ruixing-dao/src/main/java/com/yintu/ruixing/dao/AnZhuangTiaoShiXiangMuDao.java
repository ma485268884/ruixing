package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.AnZhuangTiaoShiXiangMuEntity;

import java.util.List;

public interface AnZhuangTiaoShiXiangMuDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AnZhuangTiaoShiXiangMuEntity record);

    int insertSelective(AnZhuangTiaoShiXiangMuEntity record);

    AnZhuangTiaoShiXiangMuEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AnZhuangTiaoShiXiangMuEntity record);

    int updateByPrimaryKey(AnZhuangTiaoShiXiangMuEntity record);




    ////////////////////////////////////////////////





    List<AnZhuangTiaoShiXiangMuEntity> findSanJiShu();

    List<AnZhuangTiaoShiXiangMuEntity> findDiErJi(Integer xdFenlei);

    Object findOneXiangMU(Integer id);

    void addSanJiShuXiangMu(AnZhuangTiaoShiXiangMuEntity anZhuangTiaoShiXiangMuEntity);

    void editSanJiShu(AnZhuangTiaoShiXiangMuEntity anZhuangTiaoShiXiangMuEntity);

    void deletSanJiShuById(Integer id);
}