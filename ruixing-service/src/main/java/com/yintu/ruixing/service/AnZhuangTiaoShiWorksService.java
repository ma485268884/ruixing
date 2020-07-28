package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.AnZhuangTiaoShiWorksCheZhanEntity;

/**
 * @Author Mr.liu
 * @Date 2020/7/27 19:38
 * @Version 1.0
 * 需求:安装调试现场作业
 */
public interface AnZhuangTiaoShiWorksService {
    void addWorksCheZhan(AnZhuangTiaoShiWorksCheZhanEntity anZhuangTiaoShiWorksCheZhanEntity, String[] chezhanname);

}
