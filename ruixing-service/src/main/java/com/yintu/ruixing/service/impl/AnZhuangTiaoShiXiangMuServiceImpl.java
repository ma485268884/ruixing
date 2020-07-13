package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.dao.AnZhuangTiaoShiCheZhanXiangMuTypeDao;
import com.yintu.ruixing.dao.AnZhuangTiaoShiFileDao;
import com.yintu.ruixing.dao.AnZhuangTiaoShiXiangMuDao;
import com.yintu.ruixing.dao.ChanPinJiaoFuXiangMuDao;
import com.yintu.ruixing.entity.*;
import com.yintu.ruixing.service.AnZhuangTiaoShiXiangMuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Mr.liu
 * @Date 2020/7/11 10:44
 * @Version 1.0
 * 需求:安装调试模块
 */
@Service
@Transactional
public class AnZhuangTiaoShiXiangMuServiceImpl implements AnZhuangTiaoShiXiangMuService {


    @Autowired
    private AnZhuangTiaoShiXiangMuDao anZhuangTiaoShiXiangMuDao;

    @Autowired
    private AnZhuangTiaoShiCheZhanXiangMuTypeDao anZhuangTiaoShiCheZhanXiangMuTypeDao;

    @Autowired
    private ChanPinJiaoFuXiangMuDao chanPinJiaoFuXiangMuDao;

    @Autowired
    private AnZhuangTiaoShiFileDao anZhuangTiaoShiFileDao;

    @Override
    public AnZhuangTiaoShiFileEntity findById(Integer id) {
        return anZhuangTiaoShiFileDao.selectByPrimaryKey(id);
    }

    @Override
    public List<TreeNodeUtil> findSanJiShu() {
        List<AnZhuangTiaoShiXiangMuEntity> anZhuangTiaoShiXiangMuEntities = anZhuangTiaoShiXiangMuDao.findSanJiShu();
        List<TreeNodeUtil> treeNodeUtils = new ArrayList<>();
        for (AnZhuangTiaoShiXiangMuEntity anZhuangTiaoShiXiangMuEntity : anZhuangTiaoShiXiangMuEntities) {
            TreeNodeUtil treeNodeUtil = new TreeNodeUtil();
            //第一级
            treeNodeUtil.setId((long) anZhuangTiaoShiXiangMuEntity.getId());
            treeNodeUtil.setLabel(anZhuangTiaoShiXiangMuEntity.getXdFenlei().toString());
            List<AnZhuangTiaoShiXiangMuEntity> anZhuangTiaoShiXiangMuEntities1 = anZhuangTiaoShiXiangMuDao.findDiErJi(anZhuangTiaoShiXiangMuEntity.getXdFenlei());
            List<TreeNodeUtil> treeNodeUtilss = new ArrayList<>();
            for (AnZhuangTiaoShiXiangMuEntity zhuangTiaoShiXiangMuEntity : anZhuangTiaoShiXiangMuEntities1) {
                //第二级
                TreeNodeUtil treeNodeUtil1 = new TreeNodeUtil();
                Map<String, Object> map = new HashMap();
                treeNodeUtil1.setId((long) zhuangTiaoShiXiangMuEntity.getId());
                treeNodeUtil1.setLabel(zhuangTiaoShiXiangMuEntity.getXdName());
                map.put("xiangmu", anZhuangTiaoShiXiangMuDao.findOneXiangMU(zhuangTiaoShiXiangMuEntity.getId()));
                treeNodeUtil1.setLi_attr(map);
                treeNodeUtilss.add(treeNodeUtil1);
                treeNodeUtil.setChildren(treeNodeUtilss);
                //第三级
                List<TreeNodeUtil> treeNodeUtilss2 = new ArrayList<>();
                List<TreeNodeUtil> treeNodeUtilss3 = new ArrayList<>();
                TreeNodeUtil treeNodeUtil2 = new TreeNodeUtil();
                TreeNodeUtil treeNodeUtil3 = new TreeNodeUtil();
                treeNodeUtil2.setId((long) 1);
                treeNodeUtil2.setLabel("输入文件");
                treeNodeUtil2.setChildren(treeNodeUtilss3);
                treeNodeUtil3.setId((long) 2);
                treeNodeUtil3.setLabel("输出文件");
                treeNodeUtil3.setChildren(treeNodeUtilss3);
                treeNodeUtilss2.add(treeNodeUtil2);
                treeNodeUtilss2.add(treeNodeUtil3);
                treeNodeUtil1.setChildren(treeNodeUtilss2);
            }
            treeNodeUtils.add(treeNodeUtil);
        }
        return treeNodeUtils;
    }

    @Override
    public void addSanJiShuXiangMu(AnZhuangTiaoShiXiangMuEntity anZhuangTiaoShiXiangMuEntity) {
        anZhuangTiaoShiXiangMuDao.addSanJiShuXiangMu(anZhuangTiaoShiXiangMuEntity);
    }

    @Override
    public void editSanJiShu(AnZhuangTiaoShiXiangMuEntity anZhuangTiaoShiXiangMuEntity) {
        anZhuangTiaoShiXiangMuDao.editSanJiShu(anZhuangTiaoShiXiangMuEntity);
    }

    @Override
    public List<AnZhuangTiaoShiCheZhanXiangMuTypeEntity> findAllXiangMuType() {
        return anZhuangTiaoShiCheZhanXiangMuTypeDao.findAllXiangMuType();
    }

    @Override
    public void deletSanJiShuById(Integer id) {
        anZhuangTiaoShiXiangMuDao.deletSanJiShuById(id);
    }

    @Override
    public List<ChanPinJiaoFuXiangMuFileEntity> findXiangMuAndBianHao() {
        return chanPinJiaoFuXiangMuDao.findXiangMuAndBianHao();
    }
}
