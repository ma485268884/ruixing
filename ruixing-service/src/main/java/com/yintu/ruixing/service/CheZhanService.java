package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.CheZhanEntity;
/**
 *
 * @author Qiao
 * @date 2020/5/25 17:03
 * @return
 */
public interface CheZhanService {
    /**
     * @param cheZhanEntity
     * @author Qiao
     * @date 2020/5/25 17:04
     * @return 添加车站信息
     */
    void add(CheZhanEntity cheZhanEntity);
    /**
     * @author Qiao
     * @date 2020/5/25 17:04
     * @return 根据id修改车站信息
     */
    void update(CheZhanEntity cheZhanEntity);

    /**
     * @author Qiao
     * @date 2020/5/25 17:05
     * @return 根据id查询车站信息
     */
    CheZhanEntity findByCheZhanId(Long id);

    /**
     * 根据id删除车站
     * @param id
     */
    void delCheZhan(Long id);
}
