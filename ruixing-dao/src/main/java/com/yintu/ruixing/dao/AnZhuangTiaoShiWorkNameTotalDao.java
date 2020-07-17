package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.AnZhuangTiaoShiWorkNameTotalEntity;

import java.util.List;

public interface AnZhuangTiaoShiWorkNameTotalDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AnZhuangTiaoShiWorkNameTotalEntity record);

    AnZhuangTiaoShiWorkNameTotalEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(AnZhuangTiaoShiWorkNameTotalEntity record);


    //////////////////////////////////////////////////////////////////

    int updateByPrimaryKeySelective(AnZhuangTiaoShiWorkNameTotalEntity record);

    int insertSelective(AnZhuangTiaoShiWorkNameTotalEntity record);

    List<AnZhuangTiaoShiWorkNameTotalEntity> findWorkNameTotal(String workname);

    void deleteWorkNameTotalByIds(Integer[] ids);
}