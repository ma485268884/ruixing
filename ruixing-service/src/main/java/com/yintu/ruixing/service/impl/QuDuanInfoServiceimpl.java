package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.QuDuanInfoDao;
import com.yintu.ruixing.entity.QuDuanInfoEntity;
import com.yintu.ruixing.service.QuDuanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/6/3 11:53
 */
@Service
@Transactional
public class QuDuanInfoServiceimpl implements QuDuanInfoService {

    @Autowired
    private QuDuanInfoDao quDuanInfoDao;

    @Override
    public void add(QuDuanInfoEntity quDuanInfoEntity) {
        quDuanInfoDao.insertSelective(quDuanInfoEntity);
    }

    @Override
    public void remove(Integer id) {
        quDuanInfoDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(QuDuanInfoEntity quDuanInfoEntity) {
        quDuanInfoDao.updateByPrimaryKeySelective(quDuanInfoEntity);
    }

    @Override
    public QuDuanInfoEntity findById(Integer id) {
        return quDuanInfoDao.selectByPrimaryKey(id);
    }

    @Override
    public List<QuDuanInfoEntity> findByCidAndXid(Integer cid, Integer xid) {
        return quDuanInfoDao.selectByXidAndCid(cid, xid);
    }

    @Override
    public List<QuDuanInfoEntity> findAll() {
        return quDuanInfoDao.selectAll();
    }


    @Override
    public List<Map<String, Object>> findSongDuanAll() {
        return quDuanInfoDao.selectSongDuanAll();
    }

    @Override
    public List<Map<String, Object>> findFenXianPanSongDuanAll() {
        return quDuanInfoDao.selectFenXianPanSongDuanAll();
    }

    @Override
    public List<Map<String, Object>> findFenXianPanShouDuanAll() {
        return quDuanInfoDao.selectFenXianPanShouDuanAll();
    }

    @Override
    public List<Map<String, Object>> findShouDuanAll() {
        return quDuanInfoDao.selectShouDuanAll();
    }


    @Override
    public List<Map<String, Object>> findSongDuanTransformerAll() {
        return quDuanInfoDao.selectSongDuanTransformerAll();
    }

    @Override
    public List<Map<String, Object>> findSongDuanTuneAll() {
        return quDuanInfoDao.selectSongDuanTuneAll();
    }

    @Override
    public List<Map<String, Object>> findShouDuanTuneAll() {
        return quDuanInfoDao.selectShouDuanTuneAll();
    }

    @Override
    public List<Map<String, Object>> findShouDuanTransformerAll() {
        return quDuanInfoDao.selectShouDuanTransformerAll();
    }


    @Override
    public List<Map<String, Object>> findStatisticsSongDuanByDate(Date time) {
        return quDuanInfoDao.selectStatisticsSongDuanByDate(time);
    }


    @Override
    public List<Map<String, Object>> findStatisticsFenXianPanSongDuanByDate(Date time) {
        return quDuanInfoDao.selectStatisticsFenXianPanSongDuanByDate(time);
    }

    @Override
    public List<Map<String, Object>> findStatisticsFenXianPanShouDuanByDate(Date time) {
        return quDuanInfoDao.selectStatisticsFenXianPanShouDuanByDate(time);
    }

    @Override
    public List<Map<String, Object>> findStatisticsShouDuanByDate(Date time) {
        return quDuanInfoDao.selectStatisticsShouDuanByDate(time);
    }

    @Override
    public List<Map<String, Object>> findStatisticsByDate(Date data) {
        return quDuanInfoDao.selectStatisticsByDate(data);
    }


}
