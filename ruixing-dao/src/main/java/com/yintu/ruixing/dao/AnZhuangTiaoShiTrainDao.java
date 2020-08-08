package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.AnZhuangTiaoShiTrainEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnZhuangTiaoShiTrainDao {
    int insert(AnZhuangTiaoShiTrainEntity record);

    AnZhuangTiaoShiTrainEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(AnZhuangTiaoShiTrainEntity record);


    /////////////////////////////////////
    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AnZhuangTiaoShiTrainEntity record);

    int insertSelective(AnZhuangTiaoShiTrainEntity record);

    List<AnZhuangTiaoShiTrainEntity> findAllTrain(@Param("xdName") String xdName,@Param("customer") String customer);
}