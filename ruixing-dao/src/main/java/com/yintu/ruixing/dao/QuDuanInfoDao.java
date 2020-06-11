package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.QuDuanInfoEntity;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface QuDuanInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(QuDuanInfoEntity record);

    int insertSelective(QuDuanInfoEntity record);

    QuDuanInfoEntity selectByPrimaryKey(Integer id);

    List<QuDuanInfoEntity> selectByXidAndCid(Integer xid, Integer cid);


//    List<Map<String, Object>> selectSongDuanAll();
//
//    List<Map<String, Object>> selectFenXianPanSongDuanAll();
//
//    List<Map<String, Object>> selectFenXianPanShouDuanAll();
//
//    List<Map<String, Object>> selectShouDuanAll();
//
//    List<Map<String, Object>> selectSongDuanTransformerAll();
//
//    List<Map<String, Object>> selectSongDuanTuneAll();
//
//    List<Map<String, Object>> selectShouDuanTuneAll();
//
//    List<Map<String, Object>> selectShouDuanTransformerAll();

    List<QuDuanInfoEntity> selectAll();
//
//    List<Map<String, Object>> selectStatisticsSongDuanByDate(Date data);
//
//    List<Map<String, Object>> selectStatisticsFenXianPanSongDuanByDate(Date data);
//
//    List<Map<String, Object>> selectStatisticsFenXianPanShouDuanByDate(Date data);
//
//    List<Map<String, Object>> selectStatisticsShouDuanByDate(Date data);

    List<Map<String, Object>> selectStatisticsByDate(Date data);


    int updateByPrimaryKeySelective(QuDuanInfoEntity record);

    int updateByPrimaryKey(QuDuanInfoEntity record);


    //根据区段id  查询相关的数据

    List<QuDuanInfoEntity> findGuZhangKuData(Integer id);
}