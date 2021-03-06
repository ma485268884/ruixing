package com.yintu.ruixing.anzhuangtiaoshi;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface AnZhuangTiaoShiFileDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AnZhuangTiaoShiFileEntity record);

    int insertSelective(AnZhuangTiaoShiFileEntity record);

    int updateByPrimaryKeySelective(AnZhuangTiaoShiFileEntity record);

    int updateByPrimaryKey(AnZhuangTiaoShiFileEntity record);

    //////////////////////////////////////////////////////

    List<AnZhuangTiaoShiFileEntity> findShuRuFileByXid(Integer id);

    List<AnZhuangTiaoShiFileEntity> findShuChuFileByXid(Integer id);

    void addFile(AnZhuangTiaoShiFileEntity anZhuangTiaoShiFileEntity);

    void editFileById(AnZhuangTiaoShiFileEntity anZhuangTiaoShiFileEntity);

    void deletFileByIds(Integer[] ids);

    AnZhuangTiaoShiFileEntity selectByPrimaryKey(Integer id);

    List<AnZhuangTiaoShiFileEntity> findFileByNmae(@Param("xdid") Integer xdid,@Param("filetype") Integer filetype,@Param("filename") String filename);
}