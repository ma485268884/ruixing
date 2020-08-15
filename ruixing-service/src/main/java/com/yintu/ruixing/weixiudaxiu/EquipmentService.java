package com.yintu.ruixing.weixiudaxiu;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.weixiudaxiu.EquipmentEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/7/15 10:17
 */

public interface EquipmentService extends BaseService<EquipmentEntity, Integer> {

    List<EquipmentEntity> findAll();

    List<EquipmentEntity> findByName(String name);

}
