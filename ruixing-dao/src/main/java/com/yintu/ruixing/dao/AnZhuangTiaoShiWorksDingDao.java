package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.AnZhuangTiaoShiWorkNameLibraryEntity;
import com.yintu.ruixing.entity.AnZhuangTiaoShiWorksCheZhanEntity;
import com.yintu.ruixing.entity.AnZhuangTiaoShiWorksDingEntity;

import java.util.List;

public interface AnZhuangTiaoShiWorksDingDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AnZhuangTiaoShiWorksDingEntity record);

    AnZhuangTiaoShiWorksDingEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AnZhuangTiaoShiWorksDingEntity record);

    int updateByPrimaryKey(AnZhuangTiaoShiWorksDingEntity record);


    ////////////////////////////////////////////////////////

    int insertSelective(AnZhuangTiaoShiWorksDingEntity record);

    List<AnZhuangTiaoShiWorksCheZhanEntity> findCheZhanDatasByXid(Integer xid);

    List<AnZhuangTiaoShiWorkNameLibraryEntity> findWorksDatasByCid(Integer cid);
}