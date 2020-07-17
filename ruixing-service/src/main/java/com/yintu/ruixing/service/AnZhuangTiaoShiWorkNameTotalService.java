package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.AnZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity;
import com.yintu.ruixing.entity.AnZhuangTiaoShiWorkNameTotalEntity;

import java.util.List;

/**
 * @Author Mr.liu
 * @Date 2020/7/17 11:13
 * @Version 1.0
 * 需求:
 */
public interface AnZhuangTiaoShiWorkNameTotalService {
    void addWorkNameTotal(AnZhuangTiaoShiWorkNameTotalEntity anZhuangTiaoShiWorkNameTotalEntity);

    List<AnZhuangTiaoShiWorkNameTotalEntity> findWorkNameTotal(Integer page, Integer size, String workname);

    void editWorkNameTotalById(AnZhuangTiaoShiWorkNameTotalEntity anZhuangTiaoShiWorkNameTotalEntity);

    void deleteWorkNameTotalByIds(Integer[] ids);

    void addWorkNameEdition(AnZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity anZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity,Integer[] wnlids);

}
