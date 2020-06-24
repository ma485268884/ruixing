package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.entity.ChanPinJiaoFuEntity;
import com.yintu.ruixing.entity.ChanPinJiaoFuPropertyEntity;

import java.util.List;

/**
 * @Author Mr.liu
 * @Date 2020/6/23 16:34
 * @Version 1.0
 * 需求:产品交付模块
 */
public interface ChanPinJiaoFuService {

    void addfristData(ChanPinJiaoFuPropertyEntity chanPinJiaoFuPropertyEntity);

    Integer  findAllDataShu();

    void addDataShu(ChanPinJiaoFuPropertyEntity chanPinJiaoFuPropertyEntity);

    List<TreeNodeUtil> findChanPinJiaoFuShuXing(int i);

    void editDataShuById(ChanPinJiaoFuPropertyEntity chanPinJiaoFuPropertyEntity);

    List<Integer> findParedId(Integer id);

    void deleteDataShuById(Integer id);

    List<ChanPinJiaoFuEntity> findAllXiangMuState(Integer page,Integer size);

    List<ChanPinJiaoFuEntity> findXiangMuData(String bianhao, String name, Integer page, Integer size);

    List<ChanPinJiaoFuEntity> findXiangMuDataById(Integer id);
}
