package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.TransformerShouDuanDao;
import com.yintu.ruixing.entity.SongDuanEntity;
import com.yintu.ruixing.entity.TransformerShouDuanEntity;
import com.yintu.ruixing.entity.TransformerSongDuanEntity;
import com.yintu.ruixing.service.TransformerShouDuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/6/2 15:46
 */
@Service
@Transactional
public class TransformerShouDuanServiceImpl implements TransformerShouDuanService {
    @Autowired
    private TransformerShouDuanDao transformerShouDuanDao;

    @Override
    public void add(TransformerShouDuanEntity transformerSongDuanEntity) {
        transformerShouDuanDao.insertSelective(transformerSongDuanEntity);
    }

    @Override
    public void remove(Integer id) {
        transformerShouDuanDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(TransformerShouDuanEntity transformerShouDuanEntity) {
        transformerShouDuanDao.updateByPrimaryKeySelective(transformerShouDuanEntity);
    }

    @Override
    public TransformerShouDuanEntity findById(Integer id) {
        return transformerShouDuanDao.selectByPrimaryKey(id);
    }

    @Override
    public List<TransformerShouDuanEntity> findAll() {
        return transformerShouDuanDao.selectByAll();
    }

    @Override
    public List<TransformerShouDuanEntity> findByCidAndXid(Integer cid, Integer xid) {
        return transformerShouDuanDao.selectByCidAndXid(cid, xid);
    }
}
