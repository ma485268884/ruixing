package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.ChanPinJiaoFuCostZhiChuDao;
import com.yintu.ruixing.entity.ChanPinJiaoFuCostZhiChuEntity;
import com.yintu.ruixing.entity.ChanPinJiaoFuXiangMuEntity;
import com.yintu.ruixing.service.ChanPinJiaoFuCostZhiChuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Mr.liu
 * @Date 2020/7/4 20:23
 * @Version 1.0
 * 需求:产品交付费用-支出
 */
@Service
@Transactional
public class ChanPinJiaoFuCostZhiChuServiceImpl implements ChanPinJiaoFuCostZhiChuService {
    @Autowired
    private ChanPinJiaoFuCostZhiChuDao chanPinJiaoFuCostZhiChuDao;

    @Override
    public List<ChanPinJiaoFuCostZhiChuEntity> findAllZhiChuCost(Integer page, Integer size) {
        return chanPinJiaoFuCostZhiChuDao.findAllZhiChuCost();
    }

    @Override
    public void deletZhiChuCostByIds(Integer[] ids) {
        chanPinJiaoFuCostZhiChuDao.deletZhiChuCostByIds(ids);
    }

    @Override
    public List<ChanPinJiaoFuCostZhiChuEntity> findZhiChuCostByName(Integer page, Integer size, String xiangMuName) {
        return chanPinJiaoFuCostZhiChuDao.findZhiChuCostByName(xiangMuName);
    }

    @Override
    public void editZhiChuCost(ChanPinJiaoFuCostZhiChuEntity chanPinJiaoFuCostZhiChuEntity) {
        chanPinJiaoFuCostZhiChuDao.editZhiChuCost(chanPinJiaoFuCostZhiChuEntity);
    }

    @Override
    public void addZhiChuCost(ChanPinJiaoFuCostZhiChuEntity chanPinJiaoFuCostZhiChuEntity) {
        chanPinJiaoFuCostZhiChuDao.addZhiChuCost(chanPinJiaoFuCostZhiChuEntity);
    }

    @Override
    public List<ChanPinJiaoFuXiangMuEntity> findXiangMu() {
        return chanPinJiaoFuCostZhiChuDao.findXiangMu();
    }
}
