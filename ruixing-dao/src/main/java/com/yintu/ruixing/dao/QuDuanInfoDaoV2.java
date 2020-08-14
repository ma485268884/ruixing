package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.QuDuanInfoEntity;
import com.yintu.ruixing.entity.QuDuanInfoEntityV2;
import com.yintu.ruixing.entity.quduanEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface QuDuanInfoDaoV2 {

    QuDuanInfoEntityV2 selectByPrimaryKey(Integer id);


    QuDuanInfoEntityV2 selectLastByQid(Integer qid);


    List<QuDuanInfoEntityV2> selectByCzId(Integer czId, Date time, String tableName);

    List<Map<String, Object>> selectStatisticsByCzIdAndTime(Integer czId, Date time, String tableName);


    QuDuanInfoEntityV2 selectFirstByCzId1(Integer czId, Integer qid, String tableName);

    List<QuDuanInfoEntityV2> selectByCzIdAndTime1(Integer czId, Date time, String tableName);


    //根据区段id  查询相关的数据

    List<QuDuanInfoEntity> findGuZhangKuData(@Param("id") Integer id, @Param("tableName") String tableName);

    List<QuDuanInfoEntity> findDianMaHuaDatabById(Integer id);

    List<QuDuanInfoEntity> findQuDuanDataByTime(Date time);

    //根据传过来的数据查询数据 展示在曲线上
    Integer findQuDuanDataByTime2(@Param("format") String format, @Param("name") String name);

    Integer findQuDuanData(@Param("starttimee") Long starttimee, @Param("shuxingname") String shuxingname,
                           @Param("quduanname") String quduanname, @Param("qdid") Integer qdid);

    List<Integer> findQuDuanData(@Param("starttime") Long starttime, @Param("endtime") Long endtime,
                                 @Param("shuxingname") String shuxingname, @Param("quduanname") String quduanname, @Param("qdid") Integer qdid);

    List<quduanEntity> findQuDuanDatas(@Param("starttime") long starttime, @Param("endtime") long endtime,
                                       @Param("shuxingname") String shuxingname, @Param("quduanname") String quduanname,
                                       @Param("qdid") Integer qdid, @Param("tableName") String tableName);

    List<QuDuanInfoEntityV2> findDianMaHuaDatasByCZid(@Param("czid") Integer czid, @Param("time") long time, @Param("tableName") String tableName);

    List<QuDuanInfoEntityV2> findDianMaHuaDatasByCZids(@Param("czid") Integer czid, @Param("tableName") String tableName);
}