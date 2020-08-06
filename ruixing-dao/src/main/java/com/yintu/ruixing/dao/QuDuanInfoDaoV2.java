package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.QuDuanInfoEntity;
import com.yintu.ruixing.entity.QuDuanInfoEntityV2;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface QuDuanInfoDaoV2 {

    QuDuanInfoEntityV2 selectByPrimaryKey(Integer id);

    QuDuanInfoEntityV2 selectLastByCzId(Integer czId);


    List<QuDuanInfoEntityV2> selectByCzIdAndTime(Integer czId, Date startTime, Date endTime);


    QuDuanInfoEntityV2 selectLastByQid(Integer qid);

    List<QuDuanInfoEntityV2> selectByCzIdAndQid(Integer czId, Date time);

    List<Map<String, Object>> selectStatisticsByCzIdAndTime(Integer czId, Date time);


    QuDuanInfoEntityV2 selectFirstByCzId1(Integer czId, Integer qid);

    List<QuDuanInfoEntityV2> selectByCzIdAndTime1(Integer czId, Date time);



    //根据区段id  查询相关的数据

    List<QuDuanInfoEntity> findGuZhangKuData(Integer id);

    List<QuDuanInfoEntity> findDianMaHuaDatabById(Integer id);

    List<QuDuanInfoEntity> findQuDuanDataByTime(Date time);

    //根据传过来的数据查询数据 展示在曲线上
    Integer findQuDuanDataByTime2(@Param("format") String format, @Param("name") String name);

    List<Integer> findQuDuanData(@Param("starttime") Long starttime, @Param("endtime") Long endtime,
                                 @Param("shuxingname") String shuxingname, @Param("quduanname") String quduanname, @Param("qdid") Integer qdid);

}