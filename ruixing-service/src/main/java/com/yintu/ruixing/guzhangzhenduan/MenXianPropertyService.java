package com.yintu.ruixing.guzhangzhenduan;

import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.guzhangzhenduan.MenXianPropertyEntity;

import java.util.List;

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

    /**
     * 按照父级id查询门限参数属性树
     *
     * @param parentId 父级id
     * @return 返回门限参数属性树
     */
    List<TreeNodeUtil> findByParentId(Integer parentId);

    /**
     * @param parentId 父级id
     * @return 返回门限参数属性列表
     */
    List<MenXianPropertyEntity> findByNotParentId(Integer parentId);

}
