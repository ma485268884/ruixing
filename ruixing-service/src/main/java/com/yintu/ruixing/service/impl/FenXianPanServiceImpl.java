package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.FenXianPanDao;
import com.yintu.ruixing.entity.FenXianPanEntity;
import com.yintu.ruixing.service.FenXianPanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/6/2 14:47
 */
@Service
@Transactional
public class FenXianPanServiceImpl implements FenXianPanService {
    @Autowired
    private FenXianPanDao fenXianPanDao;

    @Override
    public void add(FenXianPanEntity fenXianPanEntity) {

        fenXianPanDao.insertSelective(fenXianPanEntity);
    }

    @Override
    public void remove(Integer id) {
        fenXianPanDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(FenXianPanEntity fenXianPanEntity) {
        fenXianPanDao.updateByPrimaryKeySelective(fenXianPanEntity);
    }

    @Override
    public FenXianPanEntity findById(Integer id) {
        return fenXianPanDao.selectByPrimaryKey(id);
    }

    @Override
    public List<FenXianPanEntity> findAll() {
        return fenXianPanDao.selectAll();
    }

    @Override
    public List<FenXianPanEntity> findByCidAndXid(Integer cid, Integer xid) {
        return fenXianPanDao.selectByCidAndXid(cid, xid);
    }
}
