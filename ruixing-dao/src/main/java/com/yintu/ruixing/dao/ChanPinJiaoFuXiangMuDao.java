package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.ChanPinJiaoFuXiangMuEntity;
import com.yintu.ruixing.entity.ChanPinJiaoFuXiangMuFileEntity;

import java.util.List;

public interface ChanPinJiaoFuXiangMuDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ChanPinJiaoFuXiangMuEntity record);

    int insertSelective(ChanPinJiaoFuXiangMuEntity record);

    ChanPinJiaoFuXiangMuEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChanPinJiaoFuXiangMuEntity record);

    int updateByPrimaryKey(ChanPinJiaoFuXiangMuEntity record);

    // ////////////////////////////////////








    List<ChanPinJiaoFuXiangMuEntity> findSanJiShu();

    List<ChanPinJiaoFuXiangMuEntity> findDiErJi(Integer xiangmuState);

    void addXiangMu(ChanPinJiaoFuXiangMuEntity chanPinJiaoFuXiangMuEntity);

    void editXiangMuById(ChanPinJiaoFuXiangMuEntity chanPinJiaoFuXiangMuEntity);

    void deletXiagMuById(Integer id);

    List<ChanPinJiaoFuXiangMuEntity> findAll();

    void addXiangMuFile(ChanPinJiaoFuXiangMuFileEntity chanPinJiaoFuXiangMuFileEntity);

    void editXiangMuFileById(ChanPinJiaoFuXiangMuFileEntity chanPinJiaoFuXiangMuFileEntity);

    ChanPinJiaoFuXiangMuFileEntity findById(Integer id);

    void deletXiangMuFileById(Integer id);

    void deletXiangMuFileByIds(Integer[] ids);
}