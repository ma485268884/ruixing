package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.AnZhuangTiaoShiWorksCheZhanDao;
import com.yintu.ruixing.entity.AnZhuangTiaoShiWorksCheZhanEntity;
import com.yintu.ruixing.service.AnZhuangTiaoShiWorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Mr.liu
 * @Date 2020/7/27 19:38
 * @Version 1.0
 * 需求:安装调试现场作业
 */
@Service
@Transactional
public class AnZhuangTiaoShiWorksServiceImpl implements AnZhuangTiaoShiWorksService {
    @Autowired
    private AnZhuangTiaoShiWorksCheZhanDao anZhuangTiaoShiWorksCheZhanDao;

    @Override
    public void addWorksCheZhan(AnZhuangTiaoShiWorksCheZhanEntity anZhuangTiaoShiWorksCheZhanEntity, String[] chezhanname) {
        for (int i = 0; i < chezhanname.length; i++) {
            anZhuangTiaoShiWorksCheZhanEntity.setCzName(chezhanname[i]);
            anZhuangTiaoShiWorksCheZhanDao.insertSelective(anZhuangTiaoShiWorksCheZhanEntity);
        }
    }
}
