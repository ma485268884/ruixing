package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.AnZhuangTiaoShiCheZhanDao;
import com.yintu.ruixing.entity.AnZhuangTiaoShiCheZhanEntity;
import com.yintu.ruixing.service.AnZhuangTiaoShiCheZhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Mr.liu
 * @Date 2020/7/11 16:47
 * @Version 1.0
 * 需求:安装调试的车站
 */
@Service
@Transactional
public class AnZhuangTiaoShiCheZhanServiceImpl implements AnZhuangTiaoShiCheZhanService {
    @Autowired
    private AnZhuangTiaoShiCheZhanDao anZhuangTiaoShiCheZhanDao;

    @Override
    public void addCheZhan(AnZhuangTiaoShiCheZhanEntity anZhuangTiaoShiCheZhanEntity) {
        anZhuangTiaoShiCheZhanEntity.setDongtaiyanshouIsNo(0);
        anZhuangTiaoShiCheZhanEntity.setJingtaiyanshouIsNo(0);
        anZhuangTiaoShiCheZhanEntity.setKaitongIsNo(0);
        anZhuangTiaoShiCheZhanEntity.setShiyunxingIsNo(0);
        anZhuangTiaoShiCheZhanEntity.setLiantiaolianshiIsNo(0);
        anZhuangTiaoShiCheZhanEntity.setShangdiantiaojianIsNo(0);
        anZhuangTiaoShiCheZhanEntity.setWanchengpeixianIsNo(0);
        anZhuangTiaoShiCheZhanDao.addCheZhan(anZhuangTiaoShiCheZhanEntity);
    }
}
