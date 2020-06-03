package com.yintu.ruixing.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.dao.DeleteDao;
import com.yintu.ruixing.entity.DataStats;
import com.yintu.ruixing.service.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


/**
 * @author:lcy
 * @date:2020-06-02 20
 * 分页
 */
@Service
@Transactional
public class DeleteServiceImpl implements DeleteService {
    @Autowired
    private DeleteDao deleteDao;
/*
    @Override
    public PageInfo<DataStats> tljPage(String id, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<DataStats> all=pageDao.tljPage();
        PageInfo<DataStats> pageInfo = new PageInfo<DataStats>(all);
        return pageInfo;

    }

    @Override
    public PageInfo<DataStats> dwdPage(String id, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<DataStats> all=pageDao.dwdPage();
        PageInfo<DataStats> pageInfo = new PageInfo<DataStats>(all);
        return pageInfo;
    }

    @Override
    public PageInfo<DataStats> czPage(String id, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<DataStats> all=pageDao.czPage();
        PageInfo<DataStats> pageInfo = new PageInfo<DataStats>(all);
        return pageInfo;
    }

    @Override
    public PageInfo<DataStats> xdPage(String id, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<DataStats> all=pageDao.xdPage();
        PageInfo<DataStats> pageInfo = new PageInfo<DataStats>(all);
        return pageInfo;
    }*/

    @Override
    public int delTieLuJU(int[] ids) {
        return deleteDao.delTieLuJU(ids);
    }

    @Override
    public int delDianDuDuan(int[] ids) {
        return deleteDao.delDianDuDuan(ids);
    }

    @Override
    public int delXianDuan(int[] ids) {
        return deleteDao.delXianDuan(ids);
    }

    @Override
    public int delCheZhan(int[] ids) {
        return deleteDao.delCheZhan(ids);
    }
}
