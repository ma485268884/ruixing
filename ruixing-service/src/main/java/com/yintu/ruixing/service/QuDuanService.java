package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.QuDuanEntity;

import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/6/2 15:14
 */
public interface QuDuanService {
    /**
     * 添加区段信息
     *
     * @param quDuanEntity 区段信息
     */
    void add(QuDuanEntity quDuanEntity);

    /**
     * 删除区段信息
     *
     * @param id 区段id
     */
    void remove(Integer id);

    /**
     * 修改区段信息
     *
     * @param quDuanEntity 区段信息
     */
    void edit(QuDuanEntity quDuanEntity);

    /**
     * 按照id查询区段信息
     *
     * @param id 区段id
     */
    QuDuanEntity findById(Integer id);

    /**
     * @return 区段信息集
     */
    List<QuDuanEntity> findAll();

    /**
     * 按照车站和线段查询
     *
     * @return 区段信息集
     */
    List<QuDuanEntity> findByCidAndXid(Integer cid, Integer xid);

    /**
     * @return 七张表的整合
     */
    Map<String, List<?>> findAll(Integer cid, Integer xid);

}
