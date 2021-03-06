package com.yintu.ruixing.guzhangzhenduan;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;
@Mapper
public interface QuDuanInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(QuDuanInfoEntity record);

    int insertSelective(QuDuanInfoEntity record);

    QuDuanInfoEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuDuanInfoEntity record);

    int updateByPrimaryKey(QuDuanInfoEntity record);


    List<QuDuanInfoEntity> selectByQidAndTime(Integer qid, Date time);

    List<Integer> selectByXidAndCidAndBetweenAndTime(Integer xid, Integer cid, Date startTime, Date endTime);

    List<QuDuanInfoEntity> selectByXidAndCidAndTime(Integer xid, Integer cid, Date time);

    List<Map<String, Object>> selectStatisticsByDate(Integer xid, Integer cid, Date time);

    //根据区段id  查询相关的数据

    List<QuDuanInfoEntity> findGuZhangKuData(Integer id);

    List<QuDuanInfoEntity> findDianMaHuaDatabById(Integer id);

    List<QuDuanInfoEntity> findQuDuanDataByTime(Date time);
    //根据传过来的数据查询数据 展示在曲线上
    Integer findQuDuanDataByTime2(@Param("format") String format, @Param("name") String name);

    List<Integer> findQuDuanData(@Param("starttime")Long starttime, @Param("endtime")Long endtime,
                                 @Param("shuxingname") String shuxingname, @Param("quduanname")String quduanname);
}