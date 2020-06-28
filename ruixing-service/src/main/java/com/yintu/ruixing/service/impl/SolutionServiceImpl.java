package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.dao.SolutionDao;
import com.yintu.ruixing.entity.SolutionEntity;
import com.yintu.ruixing.entity.SolutionStatusEntity;
import com.yintu.ruixing.service.SolutionService;
import com.yintu.ruixing.service.SolutionStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/6/22 15:56
 */
@Service
@Transactional
public class SolutionServiceImpl implements SolutionService {

    @Autowired
    private SolutionDao solutionDao;
    @Autowired
    private SolutionStatusService solutionStatusService;

    @Override
    public void add(SolutionEntity entity) {
        SolutionEntity s = this.findById(entity.getParentId());
        if (s != null || entity.getParentId() == -1) {
            List<SolutionEntity> solutionEntities = this.findByNameAndType(entity.getName(), entity.getType());
            if (solutionEntities.size() == 0) {
                solutionDao.insertSelective(entity);
            }
        }
        if (entity.getNameType().equals((short) 2)) {
            SolutionEntity solutionEntity = new SolutionEntity();
            solutionEntity.setParentId(entity.getId());
            solutionEntity.setName("输入文件");
            solutionEntity.setNameType((short) 3);
            solutionEntity.setType(entity.getType());
            solutionDao.insertSelective(solutionEntity);
            solutionEntity.setName("输出文件");
            solutionDao.insertSelective(solutionEntity);
        }
    }

    @Override
    public void remove(Integer id) {
        solutionDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(SolutionEntity entity) {
        SolutionEntity s = this.findById(entity.getParentId());
        if (s != null || entity.getParentId() == -1) {
            List<SolutionEntity> solutionEntities = this.findByNameAndType(entity.getName(), entity.getType());
            if (solutionEntities.size() == 0 || !solutionEntities.get(0).getId().equals(entity.getId())) {
                solutionDao.updateByPrimaryKeySelective(entity);
            }
        }

    }

    @Override
    public SolutionEntity findById(Integer id) {
        return solutionDao.selectByPrimaryKey(id);
    }


    @Override
    public List<SolutionEntity> findByNameAndType(String name, Short type) {
        return solutionDao.selectByNameAndType(name, type);
    }

    @Override
    public List<SolutionEntity> findByParentIdAndType(Integer parentId, Short type) {
        return solutionDao.selectPartByParentIdAndType(parentId, type);
    }

    @Override
    public List<TreeNodeUtil> findTreeByParentIdAndType(Integer parentId, Short type) {
        List<SolutionEntity> solutionEntities = this.findByParentIdAndType(parentId, type);
        List<TreeNodeUtil> treeNodeUtils = new ArrayList<>();
        for (SolutionEntity solutionEntity : solutionEntities) {
            TreeNodeUtil treeNodeUtil = new TreeNodeUtil();
            treeNodeUtil.setId(Long.valueOf(solutionEntity.getId().toString()));
            treeNodeUtil.setLabel(solutionEntity.getName());
            Map<String, Object> map = new HashMap<>();
            map.put("parentId", Long.valueOf(solutionEntity.getParentId().toString()));
            map.put("nameType", solutionEntity.getNameType());
            map.put("type", solutionEntity.getType());
            treeNodeUtil.setA_attr(map);
            if (this.findByParentIdAndType(solutionEntity.getId(), type).size() > 0) {
                treeNodeUtil.setChildren(this.findTreeByParentIdAndType(solutionEntity.getId(), type));
            }
            treeNodeUtils.add(treeNodeUtil);
        }
        return treeNodeUtils;
    }

    @Override
    public void removeTreeByIdAndType(Integer id, Short type) {
        List<SolutionEntity> solutionEntities = solutionDao.selectPartByParentIdAndType(id, type);
        for (SolutionEntity solutionEntity : solutionEntities) {
            this.remove(solutionEntity.getId());
            this.removeTreeByIdAndType(solutionEntity.getId(), type);
        }
    }

    @Override
    public List<SolutionStatusEntity> findStatusById(Integer id, Short nameType, Short type) {
        return solutionStatusService.findByYearIdOrProjectIdOrFileTypeIdAndType(id, nameType, type);
    }
}
