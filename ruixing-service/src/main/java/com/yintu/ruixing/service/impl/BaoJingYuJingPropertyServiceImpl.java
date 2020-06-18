package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.dao.BaoJingYuJingPropertyDao;
import com.yintu.ruixing.entity.BaoJingYuJingPropertyEntity;
import com.yintu.ruixing.service.BaoJingYuJingPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:lcy
 * @date:2020-06-17 10
 */
@Service
@Transactional
public class BaoJingYuJingPropertyServiceImpl implements BaoJingYuJingPropertyService {
    @Autowired
    private BaoJingYuJingPropertyDao baoJingYuJingPropertyDao;

    @Override
    public List<TreeNodeUtil> findBaoJingYuJingTree(Integer parentId) {
        List<BaoJingYuJingPropertyEntity> baoJingYuJingPropertyEntities = baoJingYuJingPropertyDao.findBaoJingYuJingTree(parentId);
        List<TreeNodeUtil> treeNodeUtils = new ArrayList<>();
        for (BaoJingYuJingPropertyEntity baoJingYuJingPropertyEntity : baoJingYuJingPropertyEntities) {
            TreeNodeUtil treeNodeUtil=new TreeNodeUtil();
            treeNodeUtil.setId((long) baoJingYuJingPropertyEntity.getId());
            treeNodeUtil.setLabel(baoJingYuJingPropertyEntity.getName());
            treeNodeUtil.setChildren(this.findBaoJingYuJingTree(baoJingYuJingPropertyEntity.getId()));
            treeNodeUtils.add(treeNodeUtil);

        }
        return treeNodeUtils;
    }
}
