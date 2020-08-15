package com.yintu.ruixing.guzhangzhenduan;

import com.yintu.ruixing.guzhangzhenduan.YuJingEntity;

/**
 * @author:mlf
 * @date:2020/6/1 11:29
 */
public interface YuJingService {

    /**
     * 添加预警信息
     *
     * @param yuJingEntity 预警信息
     */
    void add(YuJingEntity yuJingEntity);

    /**
     * id删除预警信息
     *
     * @param id 预警信息id
     */
    void remove(Integer id);

    /**
     * 修改预警信息
     *
     * @param yuJingEntity 预警信息
     */
    void edit(YuJingEntity yuJingEntity);

    /**
     * 按照id查询预警信息
     *
     * @param id 预警信息id
     * @return 预警信息
     */
    YuJingEntity findById(Integer id);
}
