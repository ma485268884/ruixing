package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.QuDuanInfoEntity;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/6/3 11:52
 */
public interface QuDuanInfoService {
    /**
     * 添加区段详情信息
     *
     * @param quDuanInfoEntity 区段详情
     */
    void add(QuDuanInfoEntity quDuanInfoEntity);

    /**
     * 删除区段详情信息
     *
     * @param id 区段详情id
     */
    void remove(Integer id);

    /**
     * 修改区段详情
     *
     * @param quDuanInfoEntity 区段详情
     */
    void edit(QuDuanInfoEntity quDuanInfoEntity);

    /**
     * 按照id查询区段详情
     *
     * @param id 区段详情id
     * @return 区段详情
     */
    QuDuanInfoEntity findById(Integer id);

    /**
     * 按照车站和线段查询区段详情集
     *
     * @param cid 车站id
     * @param xid 线段id
     * @return 区段详情集
     */
    List<QuDuanInfoEntity> findByCidAndXid(Integer cid, Integer xid);


    List<Map<String, Object>> findSongDuanAll();

    List<Map<String, Object>> findFenXianPanSongDuanAll();

    List<Map<String, Object>> findFenXianPanShouDuanAll();

    List<Map<String, Object>> findShouDuanAll();


    List<Map<String, Object>> findSongDuanTransformerAll();

    List<Map<String, Object>> findSongDuanTuneAll();

    List<Map<String, Object>> findShouDuanTuneAll();

    List<Map<String, Object>> findShouDuanTransformerAll();


    List<Map<String, Object>> findStatisticsSongDuanByDate(Date data);

    List<Map<String, Object>> findStatisticsFenXianPanSongDuanByDate(Date data);

    List<Map<String, Object>> findStatisticsFenXianPanShouDuanByDate(Date data);

    List<Map<String, Object>> findStatisticsShouDuanByDate(Date data);


}
