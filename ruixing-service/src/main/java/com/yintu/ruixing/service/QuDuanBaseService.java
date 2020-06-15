package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.QuDuanBaseEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/6/15 19:29
 */
public interface QuDuanBaseService {

    /**
     * 添加区段基础信息
     *
     * @param quDuanBaseEntity 区段基础信息
     */
    void add(QuDuanBaseEntity quDuanBaseEntity);

    /**
     * 删除区段基础信息
     *
     * @param id id
     */
    void remove(Integer id);

    /**
     * 修改区段基础信息
     *
     * @param quDuanBaseEntity 区段基础信息
     */
    void edit(QuDuanBaseEntity quDuanBaseEntity);

    /**
     * 查询 区段基础信息
     *
     * @param id id
     * @return 区段基础信息
     */
    QuDuanBaseEntity findById(Integer id);

    /**
     * @param xid 线段id
     * @param cid 车站id
     * @return 区段基础信息集合
     */
    List<QuDuanBaseEntity> findByXidAndCid(Integer xid, Integer cid);
}
