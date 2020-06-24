package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.SolutionStatusDao;
import com.yintu.ruixing.entity.SolutionStatusEntity;
import com.yintu.ruixing.service.SolutionStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

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

    @Override
    public void removeMuch(Integer[] ids) {
        for (Integer id : ids) {
            this.remove(id);
        }
    }

    @Override
    public List<SolutionStatusEntity> findByYearIdOrProjectIdOrFileTypeIdAndType(Integer id, Short nameType, Short type) {
        return solutionStatusDao.selectByYearIdOrProjectIdOrFileTypeIdAndType(id, nameType, type);
    }

    @Override
    public List<SolutionStatusEntity> findByProjectNameAndType(String projectName, Short type) {
        return solutionStatusDao.selectByProjectNameAndType(projectName, type);
    }
}
