package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.AnZhuangTiaoShiTrainEntity;
import com.yintu.ruixing.entity.AnZhuangTiaoShiTrainFileEntity;
import com.yintu.ruixing.entity.AnZhuangTiaoShiXiangMuEntity;

import java.util.List;

/**
 * @Author Mr.liu
 * @Date 2020/8/4 10:45
 * @Version 1.0
 * 需求:安装调试 培训管理
 */
public interface AnZhuangTiaoShiTrainService {
    List<AnZhuangTiaoShiXiangMuEntity> findXianDuan();

    void addTrain(AnZhuangTiaoShiTrainEntity anZhuangTiaoShiTrainEntity);

    void editTrainById(AnZhuangTiaoShiTrainEntity anZhuangTiaoShiTrainEntity);

    List<AnZhuangTiaoShiTrainEntity> findAllTrain(Integer page, Integer size, String xdName, String customer);

    void deleteTrainByIds(Integer[] ids);

    void addFile(AnZhuangTiaoShiTrainFileEntity anZhuangTiaoShiFileEntity);

    AnZhuangTiaoShiTrainFileEntity findById(Integer id);

    List<AnZhuangTiaoShiTrainFileEntity> findAllTrainFiles(Integer page, Integer size, String filename);

    void deleteTrainFilesByIds(Integer[] ids);

    List<AnZhuangTiaoShiTrainFileEntity> findTrainFile(Integer id);
}
