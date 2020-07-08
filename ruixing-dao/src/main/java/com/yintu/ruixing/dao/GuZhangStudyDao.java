package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.CheZhanEntity;
import com.yintu.ruixing.entity.GuZhangStudyEntity;
import com.yintu.ruixing.entity.QuDuanBaseEntity;
import com.yintu.ruixing.entity.XianDuanEntity;

import java.util.List;

public interface GuZhangStudyDao {

    /*int deleteByPrimaryKey(Integer id);

    int insert(GuZhangStudyEntity record);

    int insertSelective(GuZhangStudyEntity record);

   // GuZhangStudyEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GuZhangStudyEntity record);

    int updateByPrimaryKey(GuZhangStudyEntity record);*/





    List<GuZhangStudyEntity> findGuZhangList();

    GuZhangStudyEntity selectByPrimaryKey(Long id);

    void addGuZhang(GuZhangStudyEntity guZhangStudyEntity);

    void editGuZhang(GuZhangStudyEntity guZhangStudyEntity);

    void deletGuZhang(Long id);

    void deletGuZhangList(int[] ids);

    List<GuZhangStudyEntity> GuZhangListExcelDownloads(Long[] ids);

    List<GuZhangStudyEntity> GuZhangListExcelDownloadsById(Long id);

    List<XianDuanEntity> getXianDuan(XianDuanEntity xianDuanEntity);

    List<CheZhanEntity> getCheZhanByXid(Long xid);

    List<QuDuanBaseEntity> getQuDuanByCid(Long cid);

    //List<QuDuanInfoEntity> findGuZhangKuData(Long id,Integer page,Integer size);

    List<QuDuanBaseEntity> findFristId(Integer id);

    List<QuDuanBaseEntity> findLastId(Integer id);

    List<GuZhangStudyEntity> selectByCondition(Integer[] ids);

}