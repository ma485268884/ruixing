package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.ShouDuanEntity;
import com.yintu.ruixing.entity.SongDuanEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/6/2 15:35
 */
public interface SongDuanService {
    /**
     * 添加送端信息
     *
     * @param songDuanEntity 送端信息
     */
    void add(SongDuanEntity songDuanEntity);

    /**
     * 删除送端信息
     *
     * @param id 送端id
     */
    void remove(Integer id);

    /**
     * 修改送端信息
     *
     * @param songDuanEntity 送端信息
     */
    void edit(SongDuanEntity songDuanEntity);

    /**
     * 按照id查询送端信息
     *
     * @param id 送端id
     */
    SongDuanEntity findById(Integer id);

    /**
     * @return 送端信息集
     */
    List<SongDuanEntity> findAll();

    /**
     * 按照车站和线段查询
     *
     * @return 送端信息集
     */
    List<SongDuanEntity> findByCidAndXid(Integer cid, Integer xid);
}
