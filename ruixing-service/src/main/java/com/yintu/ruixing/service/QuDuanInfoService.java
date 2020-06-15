package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.QuDuanInfoEntity;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/6/3 11:52
 */
public interface QuDuanInfoService {
    /**
     * 添加区段详情信息
     *
     * @param quDuanInfoEntity 区段详情
     */
    void add(QuDuanInfoEntity quDuanInfoEntity);

    /**
     * 删除区段详情信息
     *
     * @param id 区段详情id
     */
    void remove(Integer id);

    /**
     * 修改区段详情
     *
     * @param quDuanInfoEntity 区段详情
     */
    void edit(QuDuanInfoEntity quDuanInfoEntity);

    /**
     * 按照id查询区段详情
     *
     * @param id 区段详情id
     * @return 区段详情
     */
    QuDuanInfoEntity findById(Integer id);

    /**
     * @param qid  区段信息id
     * @param time 时间
     * @return 区段详情集合
     */
    List<QuDuanInfoEntity> findQidAndTime(Integer qid, Date time);


    /**
     * 获取全部的区段详情集
     *
     * @return 区段详情集
     */
    List<QuDuanInfoEntity> findByXidAndCidAndTime(Integer xid, Integer cid, Date time);

    /**
     * 日报表
     *
     * @param data 日期
     * @return 统计
     */
    List<Map<String, Object>> findStatisticsByDate(Date data);


}
