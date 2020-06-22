package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.SolutionStatusDao;
import com.yintu.ruixing.entity.SolutionStatusEntity;
import com.yintu.ruixing.service.SolutionStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author:mlf
 * @date:2020/6/22 16:02
 */
@Service
@Transactional
public class SolutionStatusServiceImpl implements SolutionStatusService {
    @Autowired
    private SolutionStatusDao solutionStatusDao;


    @Override
    public void add(SolutionStatusEntity entity) {
        solutionStatusDao.insertSelective(entity);
    }

    @Override
    public void remove(Integer id) {
        solutionStatusDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(SolutionStatusEntity entity) {
        solutionStatusDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public SolutionStatusEntity findById(Integer id) {
        return solutionStatusDao.selectByPrimaryKey(id);
    }
}
