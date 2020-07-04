package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.ChanPinJiaoFuCostShouRuDao;
import com.yintu.ruixing.entity.ChanPinJiaoFuCostShouRuEntity;
import com.yintu.ruixing.entity.ChanPinJiaoFuXiangMuEntity;
import com.yintu.ruixing.service.ChanPinJiaoFuCostShouRuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Mr.liu
 * @Date 2020/7/4 19:39
 * @Version 1.0
 * 需求:产品交付费用相关
 */
@Service
@Transactional
public class ChanPinJiaoFuCostShouRuServiceImpl implements ChanPinJiaoFuCostShouRuService {
    @Autowired
    private ChanPinJiaoFuCostShouRuDao chanPinJiaoFuCostShouRuDao;

    @Override
    public List<ChanPinJiaoFuCostShouRuEntity> findAllShouRuCost(Integer page, Integer size) {
        return chanPinJiaoFuCostShouRuDao.findAllShouRuCost();
    }

    @Override
    public void deletShouRuCostByIds(Integer[] ids) {
        chanPinJiaoFuCostShouRuDao.deletShouRuCostByIds(ids);
    }

    @Override
    public List<ChanPinJiaoFuCostShouRuEntity> findShouRuCostByName(Integer page, Integer size, String xiangMuName) {
        return chanPinJiaoFuCostShouRuDao.findShouRuCostByName(xiangMuName);
    }

    @Override
    public void editShouRuCost(ChanPinJiaoFuCostShouRuEntity chanPinJiaoFuCostShouRuEntity) {
        chanPinJiaoFuCostShouRuDao.editShouRuCost(chanPinJiaoFuCostShouRuEntity);
    }

    @Override
    public void addShouRuCost(ChanPinJiaoFuCostShouRuEntity chanPinJiaoFuCostShouRuEntity) {
        chanPinJiaoFuCostShouRuDao.addShouRuCost(chanPinJiaoFuCostShouRuEntity);
    }


}
