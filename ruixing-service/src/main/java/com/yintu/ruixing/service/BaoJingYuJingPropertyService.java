package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.entity.BaoJingYuJingEntity;
import com.yintu.ruixing.entity.QuDuanBaseEntity;

import java.util.Date;
import java.util.List;

/**
 * @author:lcy
 * @date:2020-06-17 10
 */
public interface BaoJingYuJingPropertyService {
    List<TreeNodeUtil> findBaoJingYuJingTree(Integer parentId);

    List<BaoJingYuJingEntity> findAllYuJingBaoJing(Integer page, Integer size);

    List<BaoJingYuJingEntity> findYuJingBaoJingBySouSuo(Integer[] ids, Integer sid, Integer qid,
                                                        Date startTime, Date huifuTime, Integer tianChuang,
                                                        Integer lvChuHuiFu, Integer lvChuKaiTong, Integer page, Integer size);

    List<QuDuanBaseEntity> findAllQuDuan();

}
