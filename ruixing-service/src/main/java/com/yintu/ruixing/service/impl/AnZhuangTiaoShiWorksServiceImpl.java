package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.*;
import com.yintu.ruixing.entity.*;
import com.yintu.ruixing.service.AnZhuangTiaoShiWorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Mr.liu
 * @Date 2020/7/27 19:38
 * @Version 1.0
 * 需求:安装调试现场作业
 */
@Service
@Transactional
public class AnZhuangTiaoShiWorksServiceImpl implements AnZhuangTiaoShiWorksService {
    @Autowired
    private AnZhuangTiaoShiWorksCheZhanDao anZhuangTiaoShiWorksCheZhanDao;

    @Autowired
    private AnZhuangTiaoShiCheZhanDao anZhuangTiaoShiCheZhanDao;

    @Autowired
    private AnZhuangTiaoShiWorksDingDao anZhuangTiaoShiWorksDingDao;

    @Autowired
    private AnZhuangTiaoShiWorkNameTotalDao anZhuangTiaoShiWorkNameTotalDao;

    @Autowired
    private AnZhuangTiaoShiWorksFileDao anZhuangTiaoShiWorksFileDao;

    @Override
    public void deletFileByIds(Integer[] ids) {
        anZhuangTiaoShiWorksFileDao.deletFileByIds(ids);
    }

    @Override
    public List<AnZhuangTiaoShiWorksFileEntity> findFileByNmae(Integer page, Integer size, Integer xdid, Integer filetype, String filename) {
        return anZhuangTiaoShiWorksFileDao.findFileByNmae(xdid,filename,filetype);
    }

    @Override
    public AnZhuangTiaoShiWorksFileEntity findById(Integer id) {
        return anZhuangTiaoShiWorksFileDao.selectByPrimaryKey(id);
    }

    @Override
    public void editFileById(AnZhuangTiaoShiWorksFileEntity anZhuangTiaoShiWorksFileEntity) {
        anZhuangTiaoShiWorksFileDao.updateByPrimaryKeySelective(anZhuangTiaoShiWorksFileEntity);
    }

    @Override
    public void addFile(AnZhuangTiaoShiWorksFileEntity anZhuangTiaoShiWorksFileEntity) {
        anZhuangTiaoShiWorksFileDao.insertSelective(anZhuangTiaoShiWorksFileEntity);
    }

    @Override
    public List<AnZhuangTiaoShiWorksFileEntity> findShuRuFileByXid(Integer id, Integer page, Integer size) {
        return anZhuangTiaoShiWorksFileDao.findShuRuFileByXid(id);
    }

    @Override
    public List<AnZhuangTiaoShiWorksFileEntity> findShuChuFileByXid(Integer id, Integer page, Integer size) {
        return anZhuangTiaoShiWorksFileDao.findShuChuFileByXid(id);
    }

    @Override
    public List<AnZhuangTiaoShiWorkNameTotalEntity> findAllWorks() {
        return anZhuangTiaoShiWorkNameTotalDao.findAllWorks();
    }

    @Override
    public void addWorksDatas(AnZhuangTiaoShiWorksDingEntity anZhuangTiaoShiWorksDingEntity) {
        anZhuangTiaoShiWorksDingDao.insertSelective(anZhuangTiaoShiWorksDingEntity);
    }

    @Override
    public List<AnZhuangTiaoShiWorkNameLibraryEntity> findWorksDatasByCid(Integer cid, Integer page, Integer size) {
        return anZhuangTiaoShiWorksDingDao.findWorksDatasByCid(cid);
    }

    @Override
    public List<AnZhuangTiaoShiWorksCheZhanEntity> findCheZhanDatasByXid(Integer xid, Integer page, Integer size) {
        return anZhuangTiaoShiWorksDingDao.findCheZhanDatasByXid(xid);
    }

    @Override
    public List<AnZhuangTiaoShiCheZhanEntity> findCheZhanByXid(Integer xid) {
        return anZhuangTiaoShiCheZhanDao.findCheZhanByXid(xid);
    }

    @Override
    public void editWorksCheZhanByXid(AnZhuangTiaoShiWorksCheZhanEntity anZhuangTiaoShiWorksCheZhanEntity) {
        anZhuangTiaoShiWorksCheZhanDao.updateByPrimaryKey(anZhuangTiaoShiWorksCheZhanEntity);
    }

    @Override
    public void addWorksCheZhan(AnZhuangTiaoShiWorksCheZhanEntity anZhuangTiaoShiWorksCheZhanEntity, String[] chezhanname) {
        for (int i = 0; i < chezhanname.length; i++) {
            anZhuangTiaoShiWorksCheZhanEntity.setCzName(chezhanname[i]);
            anZhuangTiaoShiWorksCheZhanDao.insertSelective(anZhuangTiaoShiWorksCheZhanEntity);
        }
    }
}
