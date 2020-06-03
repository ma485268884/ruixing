package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.QuDuanInfoEntity;

import java.util.List;

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
     * 按照车站和线段查询区段详情集
     *
     * @param cid 车站id
     * @param xid 线段id
     * @return 区段详情集
     */
    List<QuDuanInfoEntity> findByCidAndXid(Integer cid, Integer xid);

}
