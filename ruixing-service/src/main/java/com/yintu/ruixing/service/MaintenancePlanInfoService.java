package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.entity.MaintenancePlanInfoEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/7/9 16:40
 */
public interface MaintenancePlanInfoService extends BaseService<MaintenancePlanInfoEntity, Integer> {


    void remove(Integer[] ids);

    List<MaintenancePlanInfoEntity> findByMaintenancePlanIdAndWork(Integer maintenancePlanId,String work);
}
