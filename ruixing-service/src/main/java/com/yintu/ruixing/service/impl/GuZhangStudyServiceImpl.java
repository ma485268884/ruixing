package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.GuZhangStudyDao;
import com.yintu.ruixing.dao.QuDuanInfoDao;
import com.yintu.ruixing.entity.*;
import com.yintu.ruixing.service.GuZhangStudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author:lcy
 * @date:2020-06-04 16
 */
@Service
@Transactional
public class GuZhangStudyServiceImpl implements GuZhangStudyService {
    @Autowired
    private GuZhangStudyDao guZhangStudyDao;

    @Autowired
    private QuDuanInfoDao quDuanInfoDao;

    @Override //1
    public List<GuZhangStudyEntity> findGuZhangList(Integer page, Integer size) {
        return guZhangStudyDao.findGuZhangList();
    }

    @Override
    public GuZhangStudyEntity findGuZhangById(Long id) {
        return guZhangStudyDao.selectByPrimaryKey(id);
    }

    @Override
    public void addGuZhang(GuZhangStudyEntity guZhangStudyEntity) {
        guZhangStudyDao.addGuZhang(guZhangStudyEntity);
    }

    @Override
    public void editGuZhang(GuZhangStudyEntity guZhangStudyEntity) {
        guZhangStudyDao.editGuZhang(guZhangStudyEntity);
    }

    @Override
    public void deletGuZhang(Long id) {
        guZhangStudyDao.deletGuZhang(id);
    }

    @Override
    public void deletGuZhangList(int[] ids) {
        guZhangStudyDao.deletGuZhangList(ids);
    }


    @Override
    public List<GuZhangStudyEntity> GuZhangListExcelDownloads(Long[] ids) {
        return guZhangStudyDao.GuZhangListExcelDownloads(ids);


    }

    @Override
    public List<GuZhangStudyEntity> GuZhangListExcelDownloadsById(Long id) {
        return guZhangStudyDao.GuZhangListExcelDownloadsById(id);
    }

    @Override
    public List<XianDuanEntity> getXianDuan(XianDuanEntity xianDuanEntity) {
        return guZhangStudyDao.getXianDuan(xianDuanEntity);
    }

    @Override
    public List<CheZhanEntity> getCheZhanByXid(Long xid) {
        return guZhangStudyDao.getCheZhanByXid(xid);
    }

    @Override
    public List<QuDuanBaseEntity> getQuDuanByCid(Long cid) {
        return guZhangStudyDao.getQuDuanByCid(cid);
    }

    @Override
    public List<QuDuanInfoEntity> findGuZhangKuData(Integer id, Integer page, Integer size) {
        return quDuanInfoDao.findGuZhangKuData(id);

    }

    @Override
    public List<QuDuanBaseEntity> findFristId(Integer id) {
        return guZhangStudyDao.findFristId(id);
    }

    @Override
    public List<QuDuanBaseEntity> findLastId(Integer id) {
        return guZhangStudyDao.findLastId(id);
    }
}
