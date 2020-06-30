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

    List<Integer> findIdS(Integer id);

    List<ChanPinJiaoFuEntity> findXiangMuDataById(Integer idd);

    List<ChanPinJiaoFuEntity> findXiangMuDataByIds(Integer firstid, Integer secondid, Integer fileid, Integer page, Integer size);

    ChanPinJiaoFuEntity findById(Integer id);

    void addXiangMuData(ChanPinJiaoFuEntity chanPinJiaoFuEntity);

    void editXiangMuDataById(ChanPinJiaoFuEntity chanPinJiaoFuEntity);

    void deletXiangMuDataById(Integer id);

    void deletXiangMuDataByIds(Integer[] ids);
}
