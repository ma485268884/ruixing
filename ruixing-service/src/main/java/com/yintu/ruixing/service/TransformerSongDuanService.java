package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.TransformerShouDuanEntity;
import com.yintu.ruixing.entity.TransformerSongDuanEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/6/2 15:55
 */
public interface TransformerSongDuanService {

    /**
     * 添加送端匹配变压器信息
     *
     * @param transformerSongDuanEntity 送端匹配变压器信息
     */
    void add(TransformerSongDuanEntity transformerSongDuanEntity);

    /**
     * 删除送端匹配变压器信息
     *
     * @param id 送端匹配变压器id
     */
    void remove(Integer id);

    /**
     * 送端匹配变压器信息
     *
     * @param transformerSongDuanEntity 送端匹配变压器信息
     */
    void edit(TransformerSongDuanEntity transformerSongDuanEntity);

    /**
     * 送端匹配变压器信息
     *
     * @param id 送端匹配变压器id
     */
    TransformerSongDuanEntity findById(Integer id);

    /**
     * @return 送端匹配变压器信息集
     */
    List<TransformerSongDuanEntity> findAll();

    /**
     * 按照车站和线段查询
     *
     * @return 送端匹配变压器信息集
     */
    List<TransformerSongDuanEntity> findByCidAndXid(Integer cid, Integer xid);
}
