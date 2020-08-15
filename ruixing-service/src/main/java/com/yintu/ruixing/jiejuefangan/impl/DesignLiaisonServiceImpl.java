package com.yintu.ruixing.jiejuefangan.impl;

import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.jiejuefangan.DesignLiaisonDao;
import com.yintu.ruixing.jiejuefangan.DesignLiaisonEntity;
import com.yintu.ruixing.jiejuefangan.DesignLiaisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author:mlf
 * @date:2020/7/3 11:06
 */
@Service
@Transactional
public class DesignLiaisonServiceImpl implements DesignLiaisonService {
    @Autowired
    private DesignLiaisonDao designLiaisonDao;

    @Override
    public void add(DesignLiaisonEntity entity) {
        designLiaisonDao.insertSelective(entity);
    }

    @Override
    public void remove(Integer id) {
        designLiaisonDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(DesignLiaisonEntity entity) {
        designLiaisonDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public DesignLiaisonEntity findById(Integer id) {
        return designLiaisonDao.selectByPrimaryKey(id);
    }

    @Override
    public List<DesignLiaisonEntity> findAll() {
        return designLiaisonDao.selectAll();
    }

    @Override
    public List<DesignLiaisonEntity> findByYear(Integer year) {
        return designLiaisonDao.selectByYear(year);
    }

    @Override
    public List<Integer> findByDistinctProjectDate() {
        return designLiaisonDao.selectByDistinctProjectDate();
    }

    @Override
    public List<TreeNodeUtil> findByTree() {
        List<Integer> years = this.findByDistinctProjectDate();
        List<TreeNodeUtil> firstTreeNodeUtils = new ArrayList<>();
        for (Integer year : years) {
            List<DesignLiaisonEntity> designLiaisonEntities = this.findByYear(year);
            List<TreeNodeUtil> secondTreeNodeUtils = new ArrayList<>();
            TreeNodeUtil firstTreeNodeUtil = new TreeNodeUtil();
            firstTreeNodeUtil.setId(1L);
            firstTreeNodeUtil.setLabel(String.valueOf(year));
            firstTreeNodeUtil.setChildren(secondTreeNodeUtils);
            firstTreeNodeUtils.add(firstTreeNodeUtil);
            for (DesignLiaisonEntity designLiaisonEntity : designLiaisonEntities) {
                List<TreeNodeUtil> thirdTreeNodeUtils = new ArrayList<>();
                TreeNodeUtil secondTreeNodeUtil = new TreeNodeUtil();
                secondTreeNodeUtil.setId(2L);
                secondTreeNodeUtil.setLabel(designLiaisonEntity.getProjectName());
                Map<String, Object> map = new HashMap<>();
                map.put("id", designLiaisonEntity.getId());
                map.put("projectDate", designLiaisonEntity.getProjectDate());
                map.put("projectName", designLiaisonEntity.getProjectName());
                map.put("projectStatus", designLiaisonEntity.getProjectStatus());
                map.put("taskStatus", designLiaisonEntity.getTaskStatus());
                map.put("taskFinishStatus", designLiaisonEntity.getTaskFinishDate());
                map.put("meetingStatus", designLiaisonEntity.getMeetingStatus());
                map.put("changeStatus", designLiaisonEntity.getChangeStatus());
                map.put("bidder", designLiaisonEntity.getBidder());
                map.put("railwayAdministrationId", designLiaisonEntity.getRailwayAdministrationId());
                map.put("biddingId", designLiaisonEntity.getBiddingId());
                secondTreeNodeUtil.setA_attr(map);
                secondTreeNodeUtil.setChildren(thirdTreeNodeUtils);
                secondTreeNodeUtils.add(secondTreeNodeUtil);
                TreeNodeUtil thirdTreeNodeUtil1 = new TreeNodeUtil();
                thirdTreeNodeUtil1.setId(3L);
                thirdTreeNodeUtil1.setLabel("输入文件");
                TreeNodeUtil thirdTreeNodeUtil2 = new TreeNodeUtil();
                thirdTreeNodeUtil2.setId(3L);
                thirdTreeNodeUtil2.setLabel("输出文件");
                thirdTreeNodeUtils.add(thirdTreeNodeUtil1);
                thirdTreeNodeUtils.add(thirdTreeNodeUtil2);
            }
        }
        return firstTreeNodeUtils;
    }
}
