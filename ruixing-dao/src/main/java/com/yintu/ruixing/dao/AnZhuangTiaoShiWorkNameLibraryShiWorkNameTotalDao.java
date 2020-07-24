package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.AnZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnZhuangTiaoShiWorkNameLibraryShiWorkNameTotalDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AnZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity record);

    AnZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(AnZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity record);

    ///////////////////////////////////////////////////

    int updateByPrimaryKeySelective(AnZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity record);

    int insertSelective(AnZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity record);

    List<AnZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity> findWorkNameById(Integer id);

    List<AnZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity> findWorkNameByWorkname(@Param("workname") String workname);

    Integer findWorkNameTatol(Integer id);
}