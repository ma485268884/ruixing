package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.QuDuanInfoEntity;

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


    List<Map<String, Object>> selectSongDuanByDate();

    List<Map<String, Object>> selectFenXianPanSongDuanByDate();

    List<Map<String, Object>> selectFenXianPanShouDuanByDate();

    List<Map<String, Object>> selectShouDuanByDate();


    int updateByPrimaryKeySelective(QuDuanInfoEntity record);

    int updateByPrimaryKey(QuDuanInfoEntity record);

}