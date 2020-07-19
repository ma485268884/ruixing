package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.CheZhanEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Qiao
 * @date 2020/5/25 16:48
 * @return 添加车站信息
 */
public interface CheZhanDao {
    /**
     * @param cheZhanEntity
     * @return 添加车站信息
     * @author Qiao
     * @date 2020/5/25 16:48
     */
    void insertChezhan(CheZhanEntity cheZhanEntity);

    /**
     * @return 根据id修改车站信息
     * @author Qiao
     * @date 2020/5/25 16:49
     */
    void updateCheZhan(CheZhanEntity cheZhanEntity);

    /**
     * @return 根据id查询车站信息
     * @author Qiao
     * @date 2020/5/25 16:49
     */
    CheZhanEntity selectByCheZhan(Long cid);

    /**
     * 根据id删除车站
     *
     * @param cid
     */
    void delCheZhan(Long cid);

    /**
     * 查询全部车站信息
     *
     * @return 车站信息集合
     */
    List<CheZhanEntity> selectAll();

    /**
     * 按照车站名查询
     *
     * @param czName 车站名名称
     * @return
     */
    List<CheZhanEntity> selectByCzName(String czName);

    List<CheZhanEntity> findallChezhanByName(String czname);

    Long findchezhanid(long parseLong);

    Integer findxianduanid(long parseLong);
}
