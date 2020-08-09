package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.AnZhuangTiaoShiWenTiFileEntity;

import java.util.List;

public interface AnZhuangTiaoShiWenTiFileDao {
    int insert(AnZhuangTiaoShiWenTiFileEntity record);

    int updateByPrimaryKeySelective(AnZhuangTiaoShiWenTiFileEntity record);

    int updateByPrimaryKey(AnZhuangTiaoShiWenTiFileEntity record);


    //////////////////////////////////////////
    int deleteByPrimaryKey(Integer id);

    AnZhuangTiaoShiWenTiFileEntity selectByPrimaryKey(Integer id);

    int insertSelective(AnZhuangTiaoShiWenTiFileEntity record);

    List<AnZhuangTiaoShiWenTiFileEntity> findAllFanKuiFileById(Integer id,String fileName);

    List<AnZhuangTiaoShiWenTiFileEntity> findAllShuChuFileById(Integer id,String fileName);
}