package com.yintu.ruixing.guzhangzhenduan;


import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author:lcy
 * @date:2020-06-17 10
 */
@Mapper
public interface BaoJingYuJingPropertyDao {
    List<BaoJingYuJingPropertyEntity> findBaoJingYuJingTree(Integer parentId);
}
