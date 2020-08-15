package com.yintu.ruixing.weixiudaxiu;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.weixiudaxiu.FieldFaultInvestigationManagementEntity;

import java.util.Date;
import java.util.List;

/**
 * @author:mlf
 * @date:2020/7/30 19:22
 */
public interface FieldFaultInvestigationManagementService extends BaseService<FieldFaultInvestigationManagementEntity, Integer> {
    void remove(Integer[] ids);

    List<FieldFaultInvestigationManagementEntity> findByStartDateAndEndDate(Date startDate, Date endDate);

}
