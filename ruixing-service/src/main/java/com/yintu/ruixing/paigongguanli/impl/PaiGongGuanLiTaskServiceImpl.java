package com.yintu.ruixing.paigongguanli.impl;

import com.yintu.ruixing.paigongguanli.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Mr.liu
 * @Date 2020/8/18 10:47
 * @Version 1.0
 * 需求:派工管理  任务
 */
@Service
@Transactional
public class PaiGongGuanLiTaskServiceImpl implements PaiGongGuanLiTaskService {
    @Autowired
    private PaiGongGuanLiTaskDao paiGongGuanLiTaskDao;

    @Autowired
    private PaiGongGuanLiTaskUserDao paiGongGuanLiTaskUserDao;

    @Override
    public List<PaiGongGuanLiTaskUserEntity> findUserPowerScoreById(Integer page, Integer size, Integer id) {
        return paiGongGuanLiTaskUserDao.findUserPowerScoreById(id);
    }

    @Override
    public List<PaiGongGuanLiTaskUserEntity> findSomeUserPowerScore(Integer page, Integer size, String userName) {
        return paiGongGuanLiTaskUserDao.findSomeUserPowerScore(userName);
    }

    @Override
    public void addUser(Integer[] uid) {
        List<Integer> Tid=paiGongGuanLiTaskDao.findId();
        for (int i = 0; i < uid.length; i++) {
            for (Integer tid : Tid) {
                paiGongGuanLiTaskUserDao.addTask(uid[i],tid);
            }
        }
    }

    @Override
    public List<PaiGongGuanLiTaskEntity> findSomeTask(Integer page, Integer size, String taskname) {
        return paiGongGuanLiTaskDao.findSomeTask(taskname);
    }

    @Override
    public void editTaskById(PaiGongGuanLiTaskEntity paiGongGuanLiTaskEntity) {
        String taskname = paiGongGuanLiTaskEntity.getTaskname();
        String businesstask = paiGongGuanLiTaskEntity.getBusinesstask();
        String businesstype = paiGongGuanLiTaskEntity.getBusinesstype();
        String taskName = taskname + businesstype + "——" + businesstask;
        paiGongGuanLiTaskEntity.setTasktotalname(taskName);
        paiGongGuanLiTaskDao.updateByPrimaryKeySelective(paiGongGuanLiTaskEntity);
    }

    @Override
    public void addTask(PaiGongGuanLiTaskEntity paiGongGuanLiTaskEntity) {
        String taskname = paiGongGuanLiTaskEntity.getTaskname();
        String businesstask = paiGongGuanLiTaskEntity.getBusinesstask();
        String businesstype = paiGongGuanLiTaskEntity.getBusinesstype();
        String taskName = taskname + businesstype + "——" + businesstask;
        paiGongGuanLiTaskEntity.setTasktotalname(taskName);
        paiGongGuanLiTaskDao.insertSelective(paiGongGuanLiTaskEntity);
        Integer id = paiGongGuanLiTaskEntity.getId();
        List<Integer> Uid = paiGongGuanLiTaskUserDao.findUid();
        if (Uid.size()!=0){
            for (Integer uid : Uid) {
                paiGongGuanLiTaskUserDao.addTask(id,uid);
            }
        }
    }
}
