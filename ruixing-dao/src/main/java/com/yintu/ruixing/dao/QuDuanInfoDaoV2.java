package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.QuDuanInfoEntity;
import com.yintu.ruixing.entity.QuDuanInfoEntityV2;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.INTERNAL;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface QuDuanInfoDaoV2 {

    QuDuanInfoEntityV2 selectByPrimaryKey(Integer id);

    QuDuanInfoEntity selectLastByCid(Integer cid);

    List<QuDuanInfoEntity> selectByCidAndQdIdAndTime(Integer cid, Integer qdId, Date time);

    List<Integer> selectByXidAndCidAndBetweenAndTime(Integer xid, Integer cid, Date startTime, Date endTime);


    List<QuDuanInfoEntity> selectByXidAndCidAndTime(Integer xid, Integer cid, Date time);

    List<Map<String, Object>> selectStatisticsByDate(Integer xid, Integer cid, Date time);

    //根据区段id  查询相关的数据

    List<QuDuanInfoEntity> findGuZhangKuData(Integer id);

    List<QuDuanInfoEntity> findDianMaHuaDatabById(Integer id);

    List<QuDuanInfoEntity> findQuDuanDataByTime(Date time);

    //根据传过来的数据查询数据 展示在曲线上
    Integer findQuDuanDataByTime2(@Param("format") String format, @Param("name") String name);

    List<Integer> findQuDuanData(@Param("starttime") String starttime, @Param("endtime") String endtime,
                                 @Param("shuxingname") String shuxingname, @Param("quduanname") String quduanname);

}