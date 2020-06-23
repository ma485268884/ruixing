package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.entity.SolutionStatusEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/6/22 16:01
 */
public interface SolutionStatusService extends BaseService<SolutionStatusEntity, Integer> {

    /**
     * 批量删除数据
     *
     * @param ids id集合
     */
    void removeMuch(Integer[] ids);

    /**
     * @param id       外键id
     * @param nameType 字段名类型
     * @param type     解决方案模块标识
     * @return 项目状态集合
     */
    List<SolutionStatusEntity> findByYearIdOrProjectIdOrFileTypeIdAndType(Integer id, Short nameType, Short type);

    /**
     * @param projectName 项目名称
     * @param type        解决方案模块标识
     * @return 项目状态集合
     */
    List<SolutionStatusEntity> findByProjectNameAndType(String projectName, Short type);

}
