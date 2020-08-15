package com.yintu.ruixing.jiejuefangan;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.jiejuefangan.BiddingEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/7/2 11:11
 */
public interface BiddingService extends BaseService<BiddingEntity, Integer> {

    List<BiddingEntity> findAll();

    /**
     * 根据年份查询项目名称
     *
     * @param year 年份
     * @return 项目id  项目名称
     */
    List<BiddingEntity> findByYear(Integer year);


    /**
     * 按照项目日期去重
     *
     * @return 年份集合
     */
    List<Integer> findByDistinctProjectDate();

    /**
     * 年份 项目名 文件类型三级树
     *
     * @return 树信息集合
     */
    List<TreeNodeUtil> findByTree();

}
