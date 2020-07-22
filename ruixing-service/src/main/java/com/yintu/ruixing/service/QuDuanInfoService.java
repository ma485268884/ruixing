package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.QuDuanInfoEntityV2;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/6/3 11:52
 */
public interface QuDuanInfoService {


    QuDuanInfoEntityV2 findById(Integer id);

    /**
     * 按照车站查询区段详情
     *
     * @param czId 车站id
     * @return 区段详情
     */
    QuDuanInfoEntityV2 findLastBycZId(Integer czId);

    /**
     *
     * @param czId 车站id
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    List<QuDuanInfoEntityV2> findByCzIdAndTime(Integer czId, Date startTime, Date endTime);

    /**
     * 按照车站查询区段详情
     *
     * @param qid 区段id
     * @return 区段详情 多条
     */
    QuDuanInfoEntityV2 findLastByQid(Integer qid);


    /**
     * 实时报表
     *
     * @param czId 车站id
     * @param time 时间
     * @return
     */
    List<QuDuanInfoEntityV2> findByCzIdAndTime(Integer czId, Date time);

    /**
     * 日报表
     *
     * @param time 日期
     * @return 统计
     */
    List<Map<String, Object>> findStatisticsByCzIdAndTime(Integer czId, Date time);


}
