package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.ZhiShiGuanLiFileTypeFileEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface ZhiShiGuanLiFileTypeFileDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ZhiShiGuanLiFileTypeFileEntity record);

    ZhiShiGuanLiFileTypeFileEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(ZhiShiGuanLiFileTypeFileEntity record);

    ////////////////////////////////////////////////////////////

    int updateByPrimaryKeySelective(ZhiShiGuanLiFileTypeFileEntity record);

    int insertSelective(ZhiShiGuanLiFileTypeFileEntity record);

    void addOneFile(@Param("fileName") String fileName,@Param("createtime") Date createtime,
                    @Param("filePath")String filePath,@Param("id1") Integer id1,@Param("tid") Integer tid);
}