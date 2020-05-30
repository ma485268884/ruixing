package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.CheZhanEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @author Qiao
 * @date 2020/5/25 16:48
 * @return 添加车站信息
 */
public interface CheZhanDao {
    /**
     * @param cheZhanEntity
     * @author Qiao
     * @date 2020/5/25 16:48
     * @return 添加车站信息
     */
    int insertChezhan(CheZhanEntity cheZhanEntity);

    /**
     * @author Qiao
     * @date 2020/5/25 16:49
     * @return 根据id修改车站信息
     */
    int updateCheZhan (CheZhanEntity cheZhanEntity);

    /**
     * @author Qiao
     * @date 2020/5/25 16:49
     * @return 根据id查询车站信息
     */
    CheZhanEntity selectByCheZhan(Long cid);

    /**
     * 根据id删除车站
     * @param cid
     */
    void delCheZhan(Long cid);
}
