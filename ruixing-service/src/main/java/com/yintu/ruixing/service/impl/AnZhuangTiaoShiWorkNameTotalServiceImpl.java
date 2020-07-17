package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.AnZhuangTiaoShiWorkNameLibraryShiWorkNameTotalDao;
import com.yintu.ruixing.dao.AnZhuangTiaoShiWorkNameTotalDao;
import com.yintu.ruixing.entity.AnZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity;
import com.yintu.ruixing.entity.AnZhuangTiaoShiWorkNameTotalEntity;
import com.yintu.ruixing.service.AnZhuangTiaoShiWorkNameTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Mr.liu
 * @Date 2020/7/17 11:13
 * @Version 1.0
 * 需求:现场作业的作业项配置
 */
@Service
@Transactional
public class AnZhuangTiaoShiWorkNameTotalServiceImpl implements AnZhuangTiaoShiWorkNameTotalService {

    @Autowired
    private AnZhuangTiaoShiWorkNameTotalDao anZhuangTiaoShiWorkNameTotalDao;

    @Autowired
    private AnZhuangTiaoShiWorkNameLibraryShiWorkNameTotalDao anZhuangTiaoShiWorkNameLibraryShiWorkNameTotalDao;

    @Override
    public void addWorkNameEdition(AnZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity anZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity,Integer[] wnlids) {
        for (int i = 0; i < wnlids.length; i++) {
            anZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity.setWnlid(wnlids[i]);
            anZhuangTiaoShiWorkNameLibraryShiWorkNameTotalDao.insertSelective(anZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity);
        }
    }

    @Override
    public void deleteWorkNameTotalByIds(Integer[] ids) {
        anZhuangTiaoShiWorkNameTotalDao.deleteWorkNameTotalByIds(ids);
    }

    @Override
    public void editWorkNameTotalById(AnZhuangTiaoShiWorkNameTotalEntity anZhuangTiaoShiWorkNameTotalEntity) {
        anZhuangTiaoShiWorkNameTotalDao.updateByPrimaryKeySelective(anZhuangTiaoShiWorkNameTotalEntity);
    }

    @Override
    public List<AnZhuangTiaoShiWorkNameTotalEntity> findWorkNameTotal(Integer page, Integer size, String workname) {
        return anZhuangTiaoShiWorkNameTotalDao.findWorkNameTotal(workname);
    }

    @Override
    public void
    addWorkNameTotal(AnZhuangTiaoShiWorkNameTotalEntity anZhuangTiaoShiWorkNameTotalEntity) {
        anZhuangTiaoShiWorkNameTotalDao.insertSelective(anZhuangTiaoShiWorkNameTotalEntity);
    }
}
