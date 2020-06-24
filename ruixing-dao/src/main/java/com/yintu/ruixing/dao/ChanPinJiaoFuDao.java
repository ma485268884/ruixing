package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.ChanPinJiaoFuEntity;
import com.yintu.ruixing.entity.ChanPinJiaoFuPropertyEntity;

import java.util.List;

/**
 * @Author Mr.liu
 * @Date 2020/6/23 16:19
 * @Version 1.0
 * 需求:产品交付模块
 */
public interface ChanPinJiaoFuDao {

    Integer findAllDataShu();

    void fristData(ChanPinJiaoFuPropertyEntity chanPinJiaoFuPropertyEntity);

    void addDataShu(ChanPinJiaoFuPropertyEntity chanPinJiaoFuPropertyEntity);

    List<ChanPinJiaoFuPropertyEntity> findChanPinJiaoFuShuXing(int i);

    void editDataShuById(ChanPinJiaoFuPropertyEntity chanPinJiaoFuPropertyEntity);

    List<Integer> findParedId(Integer id);

    void deleteDataShuById(Integer id);

    List<ChanPinJiaoFuEntity> findAllXiangMuState();

    List<ChanPinJiaoFuEntity> findXiangMuData(String bianhao, String name);

    List<ChanPinJiaoFuEntity> findXiangMuDataById(Integer id);
}
