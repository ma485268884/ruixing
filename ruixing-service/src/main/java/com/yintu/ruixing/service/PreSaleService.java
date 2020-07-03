package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.entity.PreSaleEntity;

import java.util.Date;
import java.util.List;

/**
 * @author:mlf
 * @date:2020/6/30 18:52
 */
public interface PreSaleService extends BaseService<PreSaleEntity, Integer> {


    List<PreSaleEntity> findAll();

    /**
     * 根据年份查询项目名称
     *
     * @param year 年份
     * @return 项目id  项目名称
     */
    List<PreSaleEntity> findByYear(Integer year);

    /**
     * 按照项目日期去重
     *
     * @return 年份集合
     */
    List<Integer> findByDistinctProjectDate();

    /**
     * 统计任务完成情况
     *
     * @param selectType 1.年  2.年-月  3.年-月-日
     * @param date       日期
     * @return 任务状态统计值
     */
    List<Integer> countTaskStatusByGroupBy(Integer selectType, Date date);


    /**
     * 年份 项目名 文件类型三级树
     *
     * @return 树信息集合
     */
    List<TreeNodeUtil> findByTree();


}
