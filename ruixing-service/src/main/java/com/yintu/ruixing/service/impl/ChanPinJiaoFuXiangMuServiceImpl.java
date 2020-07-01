package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.dao.ChanPinJiaoFuXiangMuDao;
import com.yintu.ruixing.entity.ChanPinJiaoFuXiangMuEntity;
import com.yintu.ruixing.entity.ChanPinJiaoFuXiangMuFileEntity;
import com.yintu.ruixing.service.ChanPinJiaoFuXiangMuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mr.liu
 * @Date 2020/7/1 13:44
 * @Version 1.0
 * 需求:产品交付
 */
@Service
@Transactional
public class ChanPinJiaoFuXiangMuServiceImpl implements ChanPinJiaoFuXiangMuService {
    @Autowired
    private ChanPinJiaoFuXiangMuDao chanPinJiaoFuXiangMuDao;

    @Override
    public void deletXiangMuFileByIds(Integer[] ids) {
        chanPinJiaoFuXiangMuDao.deletXiangMuFileByIds(ids);
    }

    @Override
    public void deletXiangMuFileById(Integer id) {
        chanPinJiaoFuXiangMuDao.deletXiangMuFileById(id);
    }

    @Override
    public ChanPinJiaoFuXiangMuFileEntity findById(Integer id) {
        return chanPinJiaoFuXiangMuDao.findById(id);
    }

    @Override
    public void editXiangMuFileById(ChanPinJiaoFuXiangMuFileEntity chanPinJiaoFuXiangMuFileEntity) {
        chanPinJiaoFuXiangMuDao.editXiangMuFileById(chanPinJiaoFuXiangMuFileEntity);
    }

    @Override
    public void addXiangMuFile(ChanPinJiaoFuXiangMuFileEntity chanPinJiaoFuXiangMuFileEntity) {
        chanPinJiaoFuXiangMuDao.addXiangMuFile(chanPinJiaoFuXiangMuFileEntity);
    }

    @Override
    public List<ChanPinJiaoFuXiangMuEntity> findAll(Integer page,Integer size) {
        return chanPinJiaoFuXiangMuDao.findAll();
    }

    @Override
    public void deletXiagMuById(Integer id) {
        chanPinJiaoFuXiangMuDao.deletXiagMuById(id);
    }

    @Override
    public void editXiangMuById(ChanPinJiaoFuXiangMuEntity chanPinJiaoFuXiangMuEntity) {
        chanPinJiaoFuXiangMuDao.editXiangMuById(chanPinJiaoFuXiangMuEntity);
    }

    @Override
    public void addXiangMu(ChanPinJiaoFuXiangMuEntity chanPinJiaoFuXiangMuEntity) {
        chanPinJiaoFuXiangMuDao.addXiangMu(chanPinJiaoFuXiangMuEntity);
    }

    //展示树形结构
    @Override
    public List<TreeNodeUtil> findSanJiShu() {
        List<ChanPinJiaoFuXiangMuEntity> chanPinJiaoFuXiangMuEntities = chanPinJiaoFuXiangMuDao.findSanJiShu();
        List<TreeNodeUtil> treeNodeUtils = new ArrayList<>();
        for (ChanPinJiaoFuXiangMuEntity chanPinJiaoFuXiangMuEntity : chanPinJiaoFuXiangMuEntities) {
            TreeNodeUtil treeNodeUtil = new TreeNodeUtil();
            if (chanPinJiaoFuXiangMuEntity.getXiangmuState() == 1 || chanPinJiaoFuXiangMuEntity.getXiangmuState() == 2 || chanPinJiaoFuXiangMuEntity.getXiangmuState() == 3) {
                //第一级
                treeNodeUtil.setId((long) chanPinJiaoFuXiangMuEntity.getId());
                treeNodeUtil.setLabel(chanPinJiaoFuXiangMuEntity.getXiangmuState().toString());
                List<ChanPinJiaoFuXiangMuEntity> chanPinJiaoFuXiangMuEntities1 = chanPinJiaoFuXiangMuDao.findDiErJi(chanPinJiaoFuXiangMuEntity.getXiangmuState());
                List<TreeNodeUtil> treeNodeUtilss = new ArrayList<>();
                for (ChanPinJiaoFuXiangMuEntity pinJiaoFuXiangMuEntity : chanPinJiaoFuXiangMuEntities1) {
                    //第二级
                    TreeNodeUtil treeNodeUtil1 = new TreeNodeUtil();
                    treeNodeUtil1.setId((long) pinJiaoFuXiangMuEntity.getId());
                    treeNodeUtil1.setLabel(pinJiaoFuXiangMuEntity.getXiangmuBianhao());
                    treeNodeUtilss.add(treeNodeUtil1);
                    treeNodeUtil.setChildren(treeNodeUtilss);
                    //第三级
                    List<TreeNodeUtil> treeNodeUtilss2 = new ArrayList<>();
                    TreeNodeUtil treeNodeUtil2 = new TreeNodeUtil();
                    TreeNodeUtil treeNodeUtil3 = new TreeNodeUtil();
                    treeNodeUtil2.setId((long) 1);
                    treeNodeUtil2.setLabel("输入文件");
                    treeNodeUtil3.setId((long) 2);
                    treeNodeUtil3.setLabel("输出文件");
                    treeNodeUtilss2.add(treeNodeUtil2);
                    treeNodeUtilss2.add(treeNodeUtil3);
                    treeNodeUtil1.setChildren(treeNodeUtilss2);
                }
            }
            treeNodeUtils.add(treeNodeUtil);
        }
        return treeNodeUtils;
    }

}




