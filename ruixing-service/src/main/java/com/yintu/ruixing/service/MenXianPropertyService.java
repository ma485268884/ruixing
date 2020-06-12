package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.MenXianPropertyEntity;

/**
 * @author:mlf
 * @date:2020/6/12 12:03
 */
public interface MenXianPropertyService {
    /**
     * 添加门限属性信息
     *
     * @param menXianPropertyEntity 门限参数属性信息
     */
    void add(MenXianPropertyEntity menXianPropertyEntity);

    /**
     * 删除门限参数属性信息
     *
     * @param id 门限参数属性信息id
     */
    void remove(Integer id);

    /***
     *
     * @param menXianPropertyEntity 门限参数属性信息
     */
    void edit(MenXianPropertyEntity menXianPropertyEntity);

    /**
     * 按照id查询门限参数属性信息
     *
     * @param id 门限参数属性信息id
     * @return 门限参数属性信息
     */
    MenXianPropertyEntity findById(Integer id);

}
