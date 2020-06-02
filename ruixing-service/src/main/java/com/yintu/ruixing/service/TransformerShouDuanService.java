package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.ShouDuanEntity;
import com.yintu.ruixing.entity.TransformerShouDuanEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/6/2 15:44
 */
public interface TransformerShouDuanService {

    /**
     * 添加受端匹配变压器信息
     *
     * @param transformerShouDuanEntity 受端匹配变压器信息
     */
    void add(TransformerShouDuanEntity transformerShouDuanEntity);

    /**
     * 删除受端匹配变压器信息
     *
     * @param id 受端匹配变压器id
     */
    void remove(Integer id);

    /**
     * 受端匹配变压器信息
     *
     * @param transformerShouDuanEntity 受端匹配变压器信息
     */
    void edit(TransformerShouDuanEntity transformerShouDuanEntity);

    /**
     * 受端匹配变压器信息
     *
     * @param id 受端匹配变压器id
     */
    TransformerShouDuanEntity findById(Integer id);

    /**
     * @return 受端匹配变压器信息集
     */
    List<TransformerShouDuanEntity> findAll();

    /**
     * 按照车站和线段查询
     *
     * @return 受端匹配变压器信息集
     */
    List<TransformerShouDuanEntity> findByCidAndXid(Integer cid, Integer xid);
}
