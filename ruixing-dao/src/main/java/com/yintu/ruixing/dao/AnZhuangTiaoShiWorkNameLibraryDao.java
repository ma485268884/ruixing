package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.AnZhuangTiaoShiWorkNameLibraryEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnZhuangTiaoShiWorkNameLibraryDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AnZhuangTiaoShiWorkNameLibraryEntity record);

    AnZhuangTiaoShiWorkNameLibraryEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(AnZhuangTiaoShiWorkNameLibraryEntity record);


    ////////////////////////////////////

    int insertSelective(AnZhuangTiaoShiWorkNameLibraryEntity record);

    List<AnZhuangTiaoShiWorkNameLibraryEntity> findWorkName(@Param("workname") String workname);

    int updateByPrimaryKeySelective(AnZhuangTiaoShiWorkNameLibraryEntity record);

    void deleteWorkNameByIds(Integer[] ids);
}