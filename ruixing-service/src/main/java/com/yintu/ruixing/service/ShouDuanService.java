package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.QuDuanEntity;
import com.yintu.ruixing.entity.ShouDuanEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/6/2 15:23
 */
public interface ShouDuanService {
    /**
     * 添加受端信息
     *
     * @param shouDuanEntity 受端信息
     */
    void add(ShouDuanEntity  shouDuanEntity);

    /**
     * 删除受端信息
     *
     * @param id 受端id
     */
    void remove(Integer id);

    /**
     * 修改受端信息
     *
     * @param shouDuanEntity 受端信息
     */
    void edit(ShouDuanEntity shouDuanEntity);

    /**
     * 按照id查询受端信息
     *
     * @param id 受端id
     */
    ShouDuanEntity findById(Integer id);

    /**
     * @return 受端信息集
     */
    List<ShouDuanEntity> findAll();

    /**
     * 按照车站和线段查询
     *
     * @return 受端信息集
     */
    List<ShouDuanEntity> findByCidAndXid(Integer cid, Integer xid);
}
