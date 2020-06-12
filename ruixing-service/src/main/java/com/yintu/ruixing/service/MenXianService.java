package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.MenXianEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/6/12 11:39
 */
public interface MenXianService {

    /**
     * 添加门限参数信息
     *
     * @param menXianEntity 门限参数信息
     */
    void add(MenXianEntity menXianEntity);


    /**
     * 按照id删除门限参数
     *
     * @param id 门限参数id
     */
    void remove(Integer id);

    /**
     * 修改门限参数信息
     *
     * @param menXianEntity 门限参数信息
     */
    void edit(MenXianEntity menXianEntity);

    /**
     * @param id 门限参数id
     * @return 门限参数信息
     */
    MenXianEntity findById(Integer id);

    /**
     * @param menXianEntity 门限参数信息
     */
    void addByQuDuan(MenXianEntity menXianEntity);

    /**
     * 按照属性id集查询门限参数集
     *
     * @return 门限参数集
     */
    List<MenXianEntity> findByPropertyIds(Integer[] propertyIds);


}
