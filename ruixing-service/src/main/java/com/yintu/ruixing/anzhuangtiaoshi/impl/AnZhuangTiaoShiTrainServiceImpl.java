package com.yintu.ruixing.anzhuangtiaoshi.impl;

import com.yintu.ruixing.anzhuangtiaoshi.AnZhuangTiaoShiTrainDao;
import com.yintu.ruixing.anzhuangtiaoshi.AnZhuangTiaoShiTrainFileDao;
import com.yintu.ruixing.anzhuangtiaoshi.AnZhuangTiaoShiXiangMuDao;
import com.yintu.ruixing.anzhuangtiaoshi.AnZhuangTiaoShiTrainEntity;
import com.yintu.ruixing.anzhuangtiaoshi.AnZhuangTiaoShiTrainFileEntity;
import com.yintu.ruixing.anzhuangtiaoshi.AnZhuangTiaoShiXiangMuEntity;
import com.yintu.ruixing.anzhuangtiaoshi.AnZhuangTiaoShiTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Mr.liu
 * @Date 2020/8/4 10:44
 * @Version 1.0
 * 需求:安装调试 培训管理
 */
@Service
@Transactional
public class AnZhuangTiaoShiTrainServiceImpl implements AnZhuangTiaoShiTrainService {
    @Autowired
    private AnZhuangTiaoShiTrainDao anZhuangTiaoShiTrainDao;

    @Autowired
    private AnZhuangTiaoShiXiangMuDao anZhuangTiaoShiXiangMuDao;

    @Autowired
    private AnZhuangTiaoShiTrainFileDao anZhuangTiaoShiTrainFileDao;

    @Override
    public List<AnZhuangTiaoShiTrainFileEntity> findTrainFile(Integer id) {
        return anZhuangTiaoShiTrainFileDao.findTrainFile(id);
    }

    @Override
    public void deleteTrainFilesByIds(Integer[] ids) {
        for (int i = 0; i < ids.length; i++) {
            anZhuangTiaoShiTrainFileDao.deleteByPrimaryKey(ids[i]);
        }
    }

    @Override
    public List<AnZhuangTiaoShiTrainFileEntity> findAllTrainFiles(Integer id,Integer page, Integer size, String filename) {
        return anZhuangTiaoShiTrainFileDao.findAllTrainFiles(id,filename);
    }

    @Override
    public AnZhuangTiaoShiTrainFileEntity findById(Integer id) {
        return anZhuangTiaoShiTrainFileDao.selectByPrimaryKey(id);
    }

    @Override
    public void addFile(AnZhuangTiaoShiTrainFileEntity anZhuangTiaoShiFileEntity) {
        anZhuangTiaoShiTrainFileDao.insertSelective(anZhuangTiaoShiFileEntity);
    }

    @Override
    public void deleteTrainByIds(Integer[] ids) {
        for (int i = 0; i < ids.length; i++) {
            anZhuangTiaoShiTrainDao.deleteByPrimaryKey(ids[i]);
        }
    }

    @Override
    public List<AnZhuangTiaoShiTrainEntity> findAllTrain(Integer page, Integer size, String xdName, String customer) {
        return anZhuangTiaoShiTrainDao.findAllTrain(xdName,customer);
    }

    @Override
    public void editTrainById(AnZhuangTiaoShiTrainEntity anZhuangTiaoShiTrainEntity) {
        anZhuangTiaoShiTrainDao.updateByPrimaryKeySelective(anZhuangTiaoShiTrainEntity);
    }

    @Override
    public void addTrain(AnZhuangTiaoShiTrainEntity anZhuangTiaoShiTrainEntity) {
        anZhuangTiaoShiTrainDao.insertSelective(anZhuangTiaoShiTrainEntity);
    }

    @Override
    public List<AnZhuangTiaoShiXiangMuEntity> findXianDuan() {
        return anZhuangTiaoShiXiangMuDao.findXianDuan();
    }
}
