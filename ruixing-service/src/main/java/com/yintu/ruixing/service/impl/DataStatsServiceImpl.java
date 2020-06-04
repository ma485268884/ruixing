package com.yintu.ruixing.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.dao.DataStatsDao;
import com.yintu.ruixing.entity.*;
import com.yintu.ruixing.service.DataStatsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * @author:lcy
 * @date:2020-05-21 11
 * 数据统计
 */

@Service
@Transactional
public class DataStatsServiceImpl implements DataStatsService {

    @Autowired
    private DataStatsDao dataStatsDao;
    //查询所有数据
    @Override
    public List<DataStats> findAll() {
        return dataStatsDao.findAll();
    }


    @Override
    public List<TieLuJuEntity> findTieLuJuById(Long tid,Integer page, Integer size) {
       List<TieLuJuEntity> tieLuJuEntities= dataStatsDao.findTieLuJuById(tid);

        return tieLuJuEntities;
    }

    @Override
    public List<DataStats> findDianWuDuanById(Long tid, Long did,Integer page, Integer size) {
         List<DataStats> dataStats =dataStatsDao.findDianWuDuanById(tid,did);
        System.out.println("从后端传来的数据"+dataStats);
        return dataStats;
    }

    @Override
    public List<DataStats> findXianDuanById(Long tid, Long did, Long xid,Integer page, Integer size) {
        List<DataStats> dataStats= dataStatsDao.findXianDuanById(tid,did,xid);
        return dataStats;
    }

    @Override
    public List<DataStats> findCheZhanById(Long tid, Long did, Long xid, Long cid,Integer page, Integer size) {
        List<DataStats> dataStats= dataStatsDao.findCheZhanById(tid,did,xid,cid);
        System.out.println("后端车站信息"+dataStats);
        return dataStats;
    }

    @Override
    public int  delCheZhanListById(int[] ids) {
      //  String[] id = ids.split(",");
        return dataStatsDao.delCheZhanListById(ids);
    }

    //分页查询
    @Override
    public PageInfo<DataStats> findPage(Integer page, Integer size) {
        //分页
        PageHelper.startPage(page,size);
        //集合查询
        List<DataStats> all = dataStatsDao.findAll();

        return new PageInfo<DataStats>(all);
    }


}
