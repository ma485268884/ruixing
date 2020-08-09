package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.AnZhuangTiaoShiWenTiDao;
import com.yintu.ruixing.dao.AnZhuangTiaoShiWenTiFileDao;
import com.yintu.ruixing.entity.AnZhuangTiaoShiWenTiEntity;
import com.yintu.ruixing.entity.AnZhuangTiaoShiWenTiFileEntity;
import com.yintu.ruixing.service.AnZhuangTiaoShiWenTiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Mr.liu
 * @Date 2020/8/9 10:30
 * @Version 1.0
 * 需求:安装调试 问题跟踪
 */
@Service
@Transactional
public class AnZhuangTiaoShiWenTiServiceImpl implements AnZhuangTiaoShiWenTiService {
    @Autowired
    private AnZhuangTiaoShiWenTiDao anZhuangTiaoShiWenTiDao;

    @Autowired
    private AnZhuangTiaoShiWenTiFileDao anZhuangTiaoShiWenTiFileDao;

    @Override
    public void deleteFileByIds(Integer[] ids) {
        for (int i = 0; i < ids.length; i++) {
            anZhuangTiaoShiWenTiFileDao.deleteByPrimaryKey(ids[i]);
        }
    }

    @Override
    public AnZhuangTiaoShiWenTiFileEntity findById(Integer id) {
        return anZhuangTiaoShiWenTiFileDao.selectByPrimaryKey(id);
    }

    @Override
    public void addFile(AnZhuangTiaoShiWenTiFileEntity anZhuangTiaoShiWenTiFileEntity) {
        anZhuangTiaoShiWenTiFileDao.insertSelective(anZhuangTiaoShiWenTiFileEntity);
    }

    @Override
    public List<AnZhuangTiaoShiWenTiFileEntity> findAllShuChuFileById(Integer id, Integer page, Integer size,String fileName) {
        return anZhuangTiaoShiWenTiFileDao.findAllShuChuFileById(id,fileName);
    }

    @Override
    public List<AnZhuangTiaoShiWenTiFileEntity> findAllFanKuiFileById(Integer id, Integer page, Integer size,String fileName) {
        return anZhuangTiaoShiWenTiFileDao.findAllFanKuiFileById(id,fileName);
    }

    @Override
    public void deleteWenTiByIds(Integer[] ids) {
        for (int i = 0; i < ids.length; i++) {
            anZhuangTiaoShiWenTiDao.deleteByPrimaryKey(ids[i]);
        }
    }

    @Override
    public List<AnZhuangTiaoShiWenTiEntity> findSomeWenTi(Integer page, Integer size, String xdname, String wenTiMiaoShu) {
        return anZhuangTiaoShiWenTiDao.findSomeWenTi(xdname,wenTiMiaoShu);
    }

    @Override
    public void editWenTiById(AnZhuangTiaoShiWenTiEntity anZhuangTiaoShiWenTiEntity) {
        anZhuangTiaoShiWenTiDao.updateByPrimaryKeySelective(anZhuangTiaoShiWenTiEntity);
    }

    @Override
    public void addWenTi(AnZhuangTiaoShiWenTiEntity anZhuangTiaoShiWenTiEntity) {
        anZhuangTiaoShiWenTiEntity.setWentiisover(0);
        anZhuangTiaoShiWenTiDao.insertSelective(anZhuangTiaoShiWenTiEntity);
    }
}
