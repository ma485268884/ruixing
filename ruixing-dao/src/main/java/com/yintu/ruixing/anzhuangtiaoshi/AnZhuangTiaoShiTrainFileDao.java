package com.yintu.ruixing.anzhuangtiaoshi;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface AnZhuangTiaoShiTrainFileDao {
    int insert(AnZhuangTiaoShiTrainFileEntity record);

    int updateByPrimaryKeySelective(AnZhuangTiaoShiTrainFileEntity record);

    int updateByPrimaryKey(AnZhuangTiaoShiTrainFileEntity record);

    ///////////////////////////////////////////////

    int deleteByPrimaryKey(Integer id);

    AnZhuangTiaoShiTrainFileEntity selectByPrimaryKey(Integer id);

    int insertSelective(AnZhuangTiaoShiTrainFileEntity record);

    List<AnZhuangTiaoShiTrainFileEntity> findAllTrainFiles(@Param("id") Integer id,@Param("filename") String filename);

    List<AnZhuangTiaoShiTrainFileEntity> findTrainFile(Integer id);
}