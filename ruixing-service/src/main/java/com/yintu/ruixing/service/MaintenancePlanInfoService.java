package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.entity.MaintenancePlanEntity;
import com.yintu.ruixing.entity.MaintenancePlanInfoEntity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @author:mlf
 * @date:2020/7/9 16:40
 */
public interface MaintenancePlanInfoService extends BaseService<MaintenancePlanInfoEntity, Integer> {

    /**
     * @param id 维护计划详情id
     * @return
     */
    MaintenancePlanInfoEntity findMaintenancePlanById(Integer id);


    void remove(Integer[] ids);

    /**
     * @param ids               维护计划详情id
     * @param maintenancePlanId 维护计划id
     * @param work              维护工作
     * @return
     */
    List<MaintenancePlanInfoEntity> findByCondition(Integer[] ids, Integer maintenancePlanId, String work);

    /**
     * 批量添加
     *
     * @param maintenancePlanInfoEntities 维护计划详情实体类集
     */
    void add(List<MaintenancePlanInfoEntity> maintenancePlanInfoEntities);

    /**
     * 批量导入excel数据
     *
     * @param inputStream 输入流
     */
    void importFile(InputStream inputStream, String fileName, Integer maintenancePlanId) throws IOException;

    /**
     * 批量导出excel数据
     *
     * @param outputStream 输出流
     * @param ids          维护计划详情id集
     * @throws IOException io异常
     */
    void exportFile(OutputStream outputStream, Integer[] ids) throws IOException;


}
