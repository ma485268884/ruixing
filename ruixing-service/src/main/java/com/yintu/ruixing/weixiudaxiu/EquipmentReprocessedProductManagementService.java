package com.yintu.ruixing.weixiudaxiu;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.weixiudaxiu.EquipmentReprocessedProductManagementEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/8/3 16:28
 */
public interface EquipmentReprocessedProductManagementService extends BaseService<EquipmentReprocessedProductManagementEntity, Integer> {


    void remove(Integer[] ids);

    List<EquipmentReprocessedProductManagementEntity> findByEquipmentNumber(String equipmentNumber);

}
