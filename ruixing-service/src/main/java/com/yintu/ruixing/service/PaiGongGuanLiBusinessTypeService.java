package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.PaiGongGuanLiBusinessTypeEntity;

import java.util.List;

/**
 * @Author Mr.liu
 * @Date 2020/8/14 15:18
 * @Version 1.0
 * 需求:派工管理  任务类型
 */
public interface PaiGongGuanLiBusinessTypeService {
    void addBusinessType(PaiGongGuanLiBusinessTypeEntity paiGongGuanLiBusinessTypeEntity);

    void editBusinessTypeById(PaiGongGuanLiBusinessTypeEntity paiGongGuanLiBusinessTypeEntity);

    List<PaiGongGuanLiBusinessTypeEntity> findBusinessType(Integer page, Integer size, String typeName, String businessName);

    void deleteBusinessTypeByIds(Integer[] ids);
}
