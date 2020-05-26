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
    //分页查询
    @Override
    public PageResponseDto<DataStats> getByPage(Integer page, Integer limit) {
        List<DataStats> userList = dataStatsDao.getByPage();
        PageHelper.startPage(page, limit);
        PageInfo<DataStats> info = new PageInfo<>(userList);
        PageResponseDto<DataStats> response = new PageResponseDto<>();
        response.setPage(info.getPageNum());
        response.setTotal(info.getTotal());
        response.setSize(info.getSize());
        response.setResult(info.getList());
        return response;

    }

    @Override
    public TieLuJuEntity findTieLuJuById(Long id) {
        return dataStatsDao.findTieLuJuById(id);
    }

    @Override
    public DataStats findDianWuDuanById(@Param("tid") Long tid,@Param("did") Long did) {
        return dataStatsDao.findDianWuDuanById(tid,did);
    }

    @Override
    public DataStats findXianDuanById(Long tid, Long did, Long xid) {
        return dataStatsDao.findXianDuanById(tid,did,xid);
    }

    @Override
    public DataStats findCheZhanById(Long tid, Long did, Long xid, Long cid) {
        return dataStatsDao.findCheZhanById(tid,did,xid,cid);
    }


}
