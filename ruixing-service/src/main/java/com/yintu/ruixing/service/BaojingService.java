package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.BaoJingEntity;

/**
 * @author:mlf
 * @date:2020/6/1 11:22
 */
public interface BaojingService {

    /**
     * 添加报警信息
     *
     * @param baoJingEntity 报警信息
     */
    void add(BaoJingEntity baoJingEntity);

    /**
     * id删除报警信息
     *
     * @param id 报警信息id
     */
    void remove(Integer id);

    /**
     * 修改报警信息
     *
     * @param baoJingEntity 报警信息
     */
    void edit(BaoJingEntity baoJingEntity);

    /**
     * 按照id查询报警信息
     *
     * @param id 报警信息id
     * @return 报警信息
     */
    BaoJingEntity findById(Integer id);
}
