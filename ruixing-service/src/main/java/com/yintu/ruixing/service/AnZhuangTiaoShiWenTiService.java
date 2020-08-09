package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.AnZhuangTiaoShiWenTiEntity;
import com.yintu.ruixing.entity.AnZhuangTiaoShiWenTiFileEntity;

import java.util.List;

/**
 * @Author Mr.liu
 * @Date 2020/8/9 10:30
 * @Version 1.0
 * 需求:安装调试 问题跟踪
 */
public interface AnZhuangTiaoShiWenTiService {
    void addWenTi(AnZhuangTiaoShiWenTiEntity anZhuangTiaoShiWenTiEntity);

    void editWenTiById(AnZhuangTiaoShiWenTiEntity anZhuangTiaoShiWenTiEntity);

    List<AnZhuangTiaoShiWenTiEntity> findSomeWenTi(Integer page, Integer size, String xdname, String wenTiMiaoShu);

    void deleteWenTiByIds(Integer[] ids);

    List<AnZhuangTiaoShiWenTiFileEntity> findAllFanKuiFileById(Integer id, Integer page, Integer size,String fileName);

    List<AnZhuangTiaoShiWenTiFileEntity> findAllShuChuFileById(Integer id, Integer page, Integer size,String fileName);

    void addFile(AnZhuangTiaoShiWenTiFileEntity anZhuangTiaoShiWenTiFileEntity);

    AnZhuangTiaoShiWenTiFileEntity findById(Integer id);

    void deleteFileByIds(Integer[] ids);
}
