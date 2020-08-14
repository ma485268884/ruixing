package com.yintu.ruixing.service;

import com.alibaba.fastjson.JSONObject;
import com.yintu.ruixing.common.util.TreeNodeUtil;
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


    /**
     * @param czId 车站id
     * @param time 时间
     * @return
     */
    List<JSONObject> findByCondition(Integer czId, Date time);

    /**
     * 查询车站下区段对应动态属性参数
     *
     * @param czId 车站id
     * @return
     */
    JSONObject findNullProperties(Integer czId);


    /**
     * 实时报表树
     *
     * @param czId 车站id
     * @return
     */
    List<TreeNodeUtil> findPropertiesTree(Integer czId);

    /**
     *
     * @param properties 属性集合
     * @param czId 车站id
     * @param time 时间
     * @return
     */
    List<JSONObject> realTimeReport(Integer[] properties, Integer czId, Date time);


}
