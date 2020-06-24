package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.entity.ChanPinJiaoFuPropertyEntity;

import java.util.List;

/**
 * @Author Mis.liu
 * @Date 2020/6/23 16:34
 * @Version 1.0
 * 需求:产品交付模块
 */
public interface ChanPinJiaoFuService {

    void addfristData(ChanPinJiaoFuPropertyEntity chanPinJiaoFuPropertyEntity);

    Integer  findAllDataShu();

    void addDataShu(ChanPinJiaoFuPropertyEntity chanPinJiaoFuPropertyEntity);

    List<TreeNodeUtil> findChanPinJiaoFuShuXing(int i);
}
