package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.entity.IndexAnalysisEquipmentEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/7/14 10:36
 */
public interface IndexAnalysisEquipmentService extends BaseService<IndexAnalysisEquipmentEntity, Integer> {


    /**
     * 按照器材编号查询器材集
     *
     * @param equipmentNumber 器材编号
     * @return 器材集
     */
    List<IndexAnalysisEquipmentEntity> findByCondition(String equipmentNumber);

}
