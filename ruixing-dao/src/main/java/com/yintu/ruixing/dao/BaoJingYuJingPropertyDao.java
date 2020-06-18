package com.yintu.ruixing.dao;


import com.yintu.ruixing.entity.BaoJingYuJingPropertyEntity;

import java.util.List;

/**
 * @author:lcy
 * @date:2020-06-17 10
 */
public interface BaoJingYuJingPropertyDao {
    List<BaoJingYuJingPropertyEntity> findBaoJingYuJingTree(Integer parentId);
}
