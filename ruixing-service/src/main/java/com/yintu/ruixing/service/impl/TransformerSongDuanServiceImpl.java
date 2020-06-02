package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.TransformerSongDuanDao;
import com.yintu.ruixing.entity.TransformerSongDuanEntity;
import com.yintu.ruixing.service.TransformerSongDuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/6/2 16:00
 */
@Service
@Transactional
public class TransformerSongDuanServiceImpl implements TransformerSongDuanService {

    @Autowired
    private TransformerSongDuanDao transformerSongDuanDao;

    @Override
    public void add(TransformerSongDuanEntity transformerSongDuanEntity) {
        transformerSongDuanDao.insertSelective(transformerSongDuanEntity);
    }

    @Override
    public void remove(Integer id) {
        transformerSongDuanDao.deleteByPrimaryKey(id);

    }

    @Override
    public void edit(TransformerSongDuanEntity transformerSongDuanEntity) {
        transformerSongDuanDao.updateByPrimaryKeySelective(transformerSongDuanEntity);
    }

    @Override
    public TransformerSongDuanEntity findById(Integer id) {
        return transformerSongDuanDao.selectByPrimaryKey(id);
    }

    @Override
    public List<TransformerSongDuanEntity> findAll() {
        return transformerSongDuanDao.selectByAll();
    }

    @Override
    public List<TransformerSongDuanEntity> findByCidAndXid(Integer cid, Integer xid) {
        return transformerSongDuanDao.selectByCidAndXid(cid, xid);
    }
}
