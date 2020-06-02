package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.FenXianPanEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/6/2 14:47
 */

public interface FenXianPanService {

    /**
     * 添加分线盘信息
     *
     * @param fenXianPanEntity 分线盘信息
     */
    void add(FenXianPanEntity fenXianPanEntity);

    /**
     * 删除分线盘信息
     *
     * @param id 分线盘id
     */
    void remove(Integer id);

    /**
     * 修改分线盘信息
     *
     * @param fenXianPanEntity 分线盘信息
     */
    void edit(FenXianPanEntity fenXianPanEntity);

    /**
     * 按照id查询分线段信息
     *
     * @param id 分线盘id
     */
    FenXianPanEntity findById(Integer id);

    /**
     * @return 分线盘信息集
     */
    List<FenXianPanEntity> findAll();

    /**
     * 按照车站和线段查询
     *
     * @return 分线盘信息集
     */
    List<FenXianPanEntity> findByCidAndXid(Integer cid, Integer xid);
}
