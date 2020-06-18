package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.TreeNodeUtil;

import java.util.List;

/**
 * @author:lcy
 * @date:2020-06-17 10
 */
public interface BaoJingYuJingPropertyService {
    List<TreeNodeUtil> findBaoJingYuJingTree(Integer parentId);
}
