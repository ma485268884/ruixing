package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.*;

import java.util.List;
import java.util.Map;

public interface GuZhangStudyDao {
    int deleteByPrimaryKey(Integer id);

    int insert(GuZhangStudyEntity record);

    int insertSelective(GuZhangStudyEntity record);

    GuZhangStudyEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GuZhangStudyEntity record);

    int updateByPrimaryKey(GuZhangStudyEntity record);

    List<GuZhangStudyEntity> findGuZhangList();

    void addGuZhang(GuZhangStudyEntity guZhangStudyEntity);

    void editGuZhang(Long id);

    void deletGuZhang(Long id);

    void deletGuZhangList(int[] ids);






    List<GuZhangStudyEntity> GuZhangListExcelDownloads();

    List<GuZhangStudyEntity> GuZhangListExcelDownloadsById(Long id);

    List<XianDuanEntity> getXianDuan(XianDuanEntity xianDuanEntity);

    List<CheZhanEntity> getCheZhanByXid(Long xid);

    List<QuDuanBaseEntity> getQuDuanByXid(Long cid);

    List<QuDuanInfoEntity> findGuZhangKuData(Long id);
}