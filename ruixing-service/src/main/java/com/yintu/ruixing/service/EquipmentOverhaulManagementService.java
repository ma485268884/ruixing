package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.entity.EquipmentOverhaulManagementEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/7/28 16:32
 */
public interface EquipmentOverhaulManagementService extends BaseService<EquipmentOverhaulManagementEntity, Integer> {

    EquipmentOverhaulManagementEntity findById(Integer id);

    void remove(Integer[] ids);

    List<EquipmentOverhaulManagementEntity> findByEquipmentNumber(String equipmentNumber);

}
