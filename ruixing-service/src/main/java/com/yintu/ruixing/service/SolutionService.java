package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.entity.SolutionEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/6/22 15:35
 */
public interface SolutionService extends BaseService<SolutionEntity, Integer> {
    /**
     * 按照父级id查询树结构
     *
     * @param parentId 父级id
     * @param type     解决方案模块标识
     * @return 树结构的解决方案中目录集合
     */
    List<TreeNodeUtil> findTreeByParentIdAndType(Integer parentId, Short type);

    /**
     * 移除指定id和模块标识的条目
     *
     * @param id   主键
     * @param type 解决方案模块标识
     */
    void removeTreeByIdAndType(Integer id, Short type);
}
