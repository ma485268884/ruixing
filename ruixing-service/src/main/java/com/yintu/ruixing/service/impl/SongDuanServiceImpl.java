package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.SongDuanDao;
import com.yintu.ruixing.entity.ShouDuanEntity;
import com.yintu.ruixing.entity.SongDuanEntity;
import com.yintu.ruixing.service.SongDuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/6/2 15:37
 */
@Service
@Transactional
public class SongDuanServiceImpl implements SongDuanService {
    @Autowired
    private SongDuanDao songDuanDao;

    @Override
    public void add(SongDuanEntity songDuanEntity) {
        songDuanDao.insertSelective(songDuanEntity);
    }

    @Override
    public void remove(Integer id) {
        songDuanDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(SongDuanEntity songDuanEntity) {
        songDuanDao.updateByPrimaryKeySelective(songDuanEntity);
    }

    @Override
    public SongDuanEntity findById(Integer id) {
        return songDuanDao.selectByPrimaryKey(id);
    }

    @Override
    public List<SongDuanEntity> findAll() {
        return songDuanDao.selectByAll();
    }

    @Override
    public List<SongDuanEntity> findByCidAndXid(Integer cid, Integer xid) {
        return songDuanDao.selectByCidAndXid(cid, xid);
    }
}
