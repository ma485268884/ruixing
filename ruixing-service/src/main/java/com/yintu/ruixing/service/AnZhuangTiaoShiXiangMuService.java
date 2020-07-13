package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.entity.AnZhuangTiaoShiCheZhanXiangMuTypeEntity;
import com.yintu.ruixing.entity.AnZhuangTiaoShiFileEntity;
import com.yintu.ruixing.entity.AnZhuangTiaoShiXiangMuEntity;
import com.yintu.ruixing.entity.ChanPinJiaoFuXiangMuFileEntity;

import java.util.List;

/**
 * @Author Mr.liu
 * @Date 2020/7/11 10:43
 * @Version 1.0
 * 需求:安装调试模块
 */
public interface AnZhuangTiaoShiXiangMuService {
    List<TreeNodeUtil> findSanJiShu();

    void addSanJiShuXiangMu(AnZhuangTiaoShiXiangMuEntity anZhuangTiaoShiXiangMuEntity);

    void editSanJiShu(AnZhuangTiaoShiXiangMuEntity anZhuangTiaoShiXiangMuEntity);

    void deletSanJiShuById(Integer id);

    List<AnZhuangTiaoShiCheZhanXiangMuTypeEntity> findAllXiangMuType();

    List<ChanPinJiaoFuXiangMuFileEntity> findXiangMuAndBianHao();

    AnZhuangTiaoShiFileEntity findById(Integer id);
}
