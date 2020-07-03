package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.entity.ChanPinJiaoFuXiangMuEntity;
import com.yintu.ruixing.entity.ChanPinJiaoFuXiangMuFileEntity;

import java.util.List;
import java.util.Map;

/**
 * @Author Mr.liu
 * @Date 2020/7/1 13:45
 * @Version 1.0
 * 需求:产品交付相关
 */
public interface ChanPinJiaoFuXiangMuService {
    List<TreeNodeUtil> findSanJiShu();

    void addXiangMu(ChanPinJiaoFuXiangMuEntity chanPinJiaoFuXiangMuEntity);

    void editXiangMuById(ChanPinJiaoFuXiangMuEntity chanPinJiaoFuXiangMuEntity);

    void deletXiagMuById(Integer id);

    List<ChanPinJiaoFuXiangMuEntity> findAll(Integer page,Integer size);

    void addXiangMuFile(ChanPinJiaoFuXiangMuFileEntity chanPinJiaoFuXiangMuFileEntity);

    void editXiangMuFileById(ChanPinJiaoFuXiangMuFileEntity chanPinJiaoFuXiangMuFileEntity);

    ChanPinJiaoFuXiangMuFileEntity findById(Integer id);

    void deletXiangMuFileById(Integer id);

    void deletXiangMuFileByIds(Integer[] ids);

    List<ChanPinJiaoFuXiangMuEntity> findXiangMuData(String xiangMuBianHao, String xiangMuName, Integer page, Integer size);

    List<ChanPinJiaoFuXiangMuEntity> findXiangMuByIds(Integer stateid, Integer id, Integer typeid, Integer page, Integer size);

    Map<String, Object> findJiaoFuQingKuangNumberAll();

    List<ChanPinJiaoFuXiangMuEntity> findJiaoFuQingKuangList(String choiceTing, Integer page, Integer size);

    List<ChanPinJiaoFuXiangMuEntity> findJiaoFuQingKuangLists(String choiceTing, Integer page, Integer size);
}
