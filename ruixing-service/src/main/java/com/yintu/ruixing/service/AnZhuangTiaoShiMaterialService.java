package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.AnZhuangTiaoShiMaterialEntity;
import com.yintu.ruixing.entity.AnZhuangTiaoShiMaterialOutInEntity;

import java.util.List;

/**
 * @Author Mr.liu
 * @Date 2020/8/10 15:19
 * @Version 1.0
 * 需求:安装调试  库存管理
 */
public interface AnZhuangTiaoShiMaterialService {
    List<AnZhuangTiaoShiMaterialEntity> findAllMaterial(Integer page, Integer size);

    void addMaterial(AnZhuangTiaoShiMaterialEntity anZhuangTiaoShiMaterialEntity);

    void editMaterialById(AnZhuangTiaoShiMaterialEntity anZhuangTiaoShiMaterialEntity);

    List<AnZhuangTiaoShiMaterialEntity> findAllMaterialDatas(Integer page, Integer size, String materialNumber);

    Integer totalNumber(Integer id);

    void deleteMaterialByIds(Integer id);

    List<AnZhuangTiaoShiMaterialOutInEntity> findAllOutMaterial(Integer page, Integer size, String materialNumber);

    void addOutMaterial(AnZhuangTiaoShiMaterialOutInEntity anZhuangTiaoShiMaterialOutInEntity);

    AnZhuangTiaoShiMaterialEntity fiandMaterial(Integer id);

    void addInMaterial(AnZhuangTiaoShiMaterialOutInEntity anZhuangTiaoShiMaterialOutInEntity);

    List<AnZhuangTiaoShiMaterialOutInEntity> findAllInMaterial(Integer page, Integer size, String materialNumber);

    List<AnZhuangTiaoShiMaterialEntity> findAllMaterials();

    void editMaterial(AnZhuangTiaoShiMaterialEntity anZhuangTiaoShiMaterialEntity,Integer id);
}
