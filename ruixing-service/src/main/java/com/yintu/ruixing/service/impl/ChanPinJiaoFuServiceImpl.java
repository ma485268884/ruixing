package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.dao.ChanPinJiaoFuDao;
import com.yintu.ruixing.entity.ChanPinJiaoFuEntity;
import com.yintu.ruixing.entity.ChanPinJiaoFuPropertyEntity;
import com.yintu.ruixing.service.ChanPinJiaoFuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mr.liu
 * @Date 2020/6/23 16:33
 * @Version 1.0
 * 需求:产品交付模块
 */
@Service
@Transactional
public class ChanPinJiaoFuServiceImpl implements ChanPinJiaoFuService {
    @Autowired
    private ChanPinJiaoFuDao chanPinJiaoFuDao;

    @Override
    public Integer findAllDataShu() {
        return chanPinJiaoFuDao.findAllDataShu();
    }

    @Override
    public List<Integer> findParedId(Integer id) {
        return chanPinJiaoFuDao.findParedId(id);
    }


    @Override
    public List<ChanPinJiaoFuEntity> findXiangMuDataById(Integer idd) {
        return chanPinJiaoFuDao.findXiangMuDataById(idd);
    }

    @Override
    public List<Integer> findIdS(Integer id) {
        return chanPinJiaoFuDao.findIdS(id);
    }

    @Override
    public List<ChanPinJiaoFuEntity> findXiangMuData(String bianhao, String name, Integer page, Integer size) {
        return chanPinJiaoFuDao.findXiangMuData(bianhao,name);
    }

    @Override
    public List<ChanPinJiaoFuEntity> findAllXiangMuState(Integer page,Integer size) {
        return chanPinJiaoFuDao.findAllXiangMuState();
    }

    @Override
    public void deleteDataShuById(Integer id) {
        chanPinJiaoFuDao.deleteDataShuById(id);
    }

    @Override
    public void editDataShuById(ChanPinJiaoFuPropertyEntity chanPinJiaoFuPropertyEntity) {
        chanPinJiaoFuDao.editDataShuById(chanPinJiaoFuPropertyEntity);
    }

    @Override
    public List<TreeNodeUtil> findChanPinJiaoFuShuXing(int i) {
        List<ChanPinJiaoFuPropertyEntity>chanPinJiaoFuPropertyEntities=chanPinJiaoFuDao.findChanPinJiaoFuShuXing(i);
        List<TreeNodeUtil> treeNodeUtils = new ArrayList<>();
        for (ChanPinJiaoFuPropertyEntity chanPinJiaoFuPropertyEntity : chanPinJiaoFuPropertyEntities) {
            TreeNodeUtil treeNodeUtil=new TreeNodeUtil();
            treeNodeUtil.setId((long) chanPinJiaoFuPropertyEntity.getId());
            treeNodeUtil.setLabel(chanPinJiaoFuPropertyEntity.getName());
            treeNodeUtil.setChildren(this.findChanPinJiaoFuShuXing(chanPinJiaoFuPropertyEntity.getId()));
            treeNodeUtils.add(treeNodeUtil);
        }
        return treeNodeUtils;
    }

    @Override
    public void addDataShu(ChanPinJiaoFuPropertyEntity chanPinJiaoFuPropertyEntity) {
        chanPinJiaoFuDao.fristData(chanPinJiaoFuPropertyEntity);
    }

    @Override
    public void addfristData(ChanPinJiaoFuPropertyEntity chanPinJiaoFuPropertyEntity) {
        chanPinJiaoFuPropertyEntity.setParentId(-1);
        chanPinJiaoFuDao.fristData(chanPinJiaoFuPropertyEntity);
    }
}
