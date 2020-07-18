package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.entity.EquipmentNumberEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/7/13 11:06
 */
public interface EquipmentNumberService extends BaseService<EquipmentNumberEntity, Integer> {


    List<EquipmentNumberEntity> findByCondition(Integer[] ids, String equipmentNumber);

    void removeMuch(Integer[] ids);

}
