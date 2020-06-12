package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.dao.MenXianPropertyDao;
import com.yintu.ruixing.entity.MenXianPropertyEntity;
import com.yintu.ruixing.service.MenXianPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:mlf
 * @date:2020/6/12 13:46
 */
@Service
@Transactional
public class MenXianPropertyServiceImpl implements MenXianPropertyService {

    @Autowired
    private MenXianPropertyDao menXianPropertyDao;

    @Override
    public void add(MenXianPropertyEntity menXianPropertyEntity) {
        menXianPropertyDao.insertSelective(menXianPropertyEntity);
    }

    @Override
    public void remove(Integer id) {
        menXianPropertyDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(MenXianPropertyEntity menXianPropertyEntity) {
        menXianPropertyDao.updateByPrimaryKeySelective(menXianPropertyEntity);
    }

    @Override
    public MenXianPropertyEntity findById(Integer id) {
        return menXianPropertyDao.selectByPrimaryKey(id);
    }

    @Override
    public List<TreeNodeUtil> findByParentId(Integer parentId) {
        List<MenXianPropertyEntity> menXianPropertyEntities = menXianPropertyDao.selectByParentId(parentId);
        List<TreeNodeUtil> treeNodeUtils = new ArrayList<>();
        for (MenXianPropertyEntity menXianPropertyEntity : menXianPropertyEntities) {
            TreeNodeUtil treeNodeUtil = new TreeNodeUtil();
            treeNodeUtil.setId((long) menXianPropertyEntity.getId());
            treeNodeUtil.setLabel(menXianPropertyEntity.getName());
            treeNodeUtil.setChildren(this.findByParentId(menXianPropertyEntity.getId()));
            treeNodeUtils.add(treeNodeUtil);
        }
        return treeNodeUtils;
    }

    @Override
    public List<MenXianPropertyEntity> findByNotParentId(Integer parentId) {
        return menXianPropertyDao.selectByNotParentId(parentId);
    }
}
