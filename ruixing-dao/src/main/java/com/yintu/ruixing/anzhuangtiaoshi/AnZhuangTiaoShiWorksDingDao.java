package com.yintu.ruixing.anzhuangtiaoshi;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
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