package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.AnZhuangTiaoShiWenTiFileEntity;
import com.yintu.ruixing.entity.AnZhuangTiaoShiWorksFileEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnZhuangTiaoShiWenTiFileDao {
    int insert(AnZhuangTiaoShiWenTiFileEntity record);

    int updateByPrimaryKeySelective(AnZhuangTiaoShiWenTiFileEntity record);

    int updateByPrimaryKey(AnZhuangTiaoShiWenTiFileEntity record);


    //////////////////////////////////////////
    int deleteByPrimaryKey(Integer id);

    AnZhuangTiaoShiWenTiFileEntity selectByPrimaryKey(Integer id);

    int insertSelective(AnZhuangTiaoShiWenTiFileEntity record);

    List<AnZhuangTiaoShiWenTiFileEntity> findAllFanKuiFileById(@Param("wid") Integer wid,@Param("fileName") String fileName);

    List<AnZhuangTiaoShiWenTiFileEntity> findAllShuChuFileById(@Param("wid") Integer wid,@Param("fileName") String fileName);

    List<AnZhuangTiaoShiWorksFileEntity> findFileById(Integer id);
}