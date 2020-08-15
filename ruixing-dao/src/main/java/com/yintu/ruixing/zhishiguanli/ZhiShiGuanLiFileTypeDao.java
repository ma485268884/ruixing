package com.yintu.ruixing.zhishiguanli;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ZhiShiGuanLiFileTypeDao {
    int insert(ZhiShiGuanLiFileTypeEntity record);

    ZhiShiGuanLiFileTypeEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(ZhiShiGuanLiFileTypeEntity record);



    //////////////////////////////////////////////////////////////////
    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZhiShiGuanLiFileTypeEntity record);

    int insertSelective(ZhiShiGuanLiFileTypeEntity record);

    List<ZhiShiGuanLiFileTypeEntity> findSomeFileType(String fileTypeName);


}