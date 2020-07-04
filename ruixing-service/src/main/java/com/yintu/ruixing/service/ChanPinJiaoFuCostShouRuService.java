package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.ChanPinJiaoFuCostShouRuEntity;

import java.util.List;

/**
 * @Author Mr.liu
 * @Date 2020/7/4 19:39
 * @Version 1.0
 * 需求:产品交付费用相关
 */
public interface ChanPinJiaoFuCostShouRuService {
    void addShouRuCost(ChanPinJiaoFuCostShouRuEntity chanPinJiaoFuCostShouRuEntity);

    void editShouRuCost(ChanPinJiaoFuCostShouRuEntity chanPinJiaoFuCostShouRuEntity);

    List<ChanPinJiaoFuCostShouRuEntity> findAllShouRuCost(Integer page, Integer size);

    List<ChanPinJiaoFuCostShouRuEntity> findShouRuCostByName(Integer page, Integer size, String xiangMuName);

    void deletShouRuCostByIds(Integer[] ids);
}
