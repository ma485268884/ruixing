package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.TransformerSongDuanEntity;
import com.yintu.ruixing.entity.TuningEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/6/2 16:27
 */
public interface TuningService {

    /**
     * 添加调谐单元信息
     *
     * @param tuningEntity 调谐单元信息
     */
    void add(TuningEntity tuningEntity);

    /**
     * 删除调谐单元信息
     *
     * @param id 调谐单元id
     */
    void remove(Integer id);

    /**
     * 调谐单元信息
     *
     * @param tuningEntity 调谐单元信息
     */
    void edit(TuningEntity tuningEntity);

    /**
     * 调谐单元信息
     *
     * @param id 调谐单元信息id
     */
    TuningEntity findById(Integer id);

    /**
     * @return 调谐单元信息集
     */
    List<TuningEntity> findAll();

    /**
     * 按照车站和线段查询
     *
     * @return 调谐单元信息集
     */
    List<TuningEntity> findByCidAndXid(Integer cid, Integer xid);
}
