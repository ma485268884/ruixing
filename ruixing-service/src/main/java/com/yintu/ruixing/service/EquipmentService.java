package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.entity.EquipmentEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/7/15 10:17
 */

public interface EquipmentService extends BaseService<EquipmentEntity, Integer> {

    List<EquipmentEntity> findAll();

}
