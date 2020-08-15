package com.yintu.ruixing.anzhuangtiaoshi;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnZhuangTiaoShiWorksCheZhanDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AnZhuangTiaoShiWorksCheZhanEntity record);

    AnZhuangTiaoShiWorksCheZhanEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AnZhuangTiaoShiWorksCheZhanEntity record);


    //////////////////////////////////////////////////

    int insertSelective(AnZhuangTiaoShiWorksCheZhanEntity record);

    int updateByPrimaryKey(AnZhuangTiaoShiWorksCheZhanEntity record);
}