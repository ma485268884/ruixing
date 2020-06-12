package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.MenXianDao;
import com.yintu.ruixing.entity.MenXianEntity;
import com.yintu.ruixing.service.MenXianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/6/12 11:54
 */
@Service
@Transactional
public class MenXianServiceImpl implements MenXianService {
    @Autowired
    private MenXianDao menXianDao;

    @Override
    public void add(MenXianEntity menXianEntity) {
        menXianDao.insert(menXianEntity);
    }

    @Override
    public void remove(Integer id) {
        menXianDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(MenXianEntity menXianEntity) {
        menXianDao.updateByPrimaryKey(menXianEntity);
    }

    @Override
    public MenXianEntity findById(Integer id) {
        return menXianDao.selectByPrimaryKey(id);
    }


}
