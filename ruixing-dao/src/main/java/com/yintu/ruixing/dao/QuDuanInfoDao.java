package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.QuDuanInfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface QuDuanInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(QuDuanInfoEntity record);

    int insertSelective(QuDuanInfoEntity record);

    QuDuanInfoEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuDuanInfoEntity record);

    int updateByPrimaryKey(QuDuanInfoEntity record);


    List<QuDuanInfoEntity> selectByQidAndTime(Integer qid, Date time);

    List<QuDuanInfoEntity> selectByXidAndCidAndTime(Integer xid, Integer cid, Date time);

    List<Map<String, Object>> selectStatisticsByDate(Date data);

    //根据区段id  查询相关的数据

    List<QuDuanInfoEntity> findGuZhangKuData(Integer id);

    List<QuDuanInfoEntity> findDianMaHuaDatabById(Integer id);

    List<QuDuanInfoEntity> findQuDuanDataByTime(Date time);
    //根据传过来的数据查询数据 展示在曲线上
    Integer findQuDuanDataByTime2(@Param("format") String format, @Param("name") String name);

    List<Integer> findQuDuanData(@Param("starttime")String starttime, @Param("endtime")String endtime, @Param("quduanName")String quduanName, @Param("shuxingName")String shuxingName);
}