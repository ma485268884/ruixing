package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.QuDuanInfoEntity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface QuDuanInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(QuDuanInfoEntity record);

    int insertSelective(QuDuanInfoEntity record);

    QuDuanInfoEntity selectByPrimaryKey(Integer id);

    List<QuDuanInfoEntity> selectByXidAndCid(Integer xid, Integer cid);


    List<Map<String, Object>> selectSongDuanAll();

    List<Map<String, Object>> selectFenXianPanSongDuanAll();

    List<Map<String, Object>> selectFenXianPanShouDuanAll();

    List<Map<String, Object>> selectShouDuanAll();


    List<Map<String, Object>> selectSongDuanTransformerAll();

    List<Map<String, Object>> selectSongDuanTuneAll();

    List<Map<String, Object>> selectShouDuanTuneAll();

    List<Map<String, Object>> selectShouDuanTransformerAll();


    List<Map<String, Object>> selectSongDuanByDate(Date data);

    List<Map<String, Object>> selectFenXianPanSongDuanByDate(Date data);

    List<Map<String, Object>> selectFenXianPanShouDuanByDate(Date data);

    List<Map<String, Object>> selectShouDuanByDate();


    int updateByPrimaryKeySelective(QuDuanInfoEntity record);

    int updateByPrimaryKey(QuDuanInfoEntity record);

}