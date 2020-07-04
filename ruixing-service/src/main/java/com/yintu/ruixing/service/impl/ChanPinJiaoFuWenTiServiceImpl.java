package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.ChanPinJiaoFuWenTiDao;
import com.yintu.ruixing.entity.ChanPinJiaoFuWenTiEntity;
import com.yintu.ruixing.entity.DepartmentEntity;
import com.yintu.ruixing.service.ChanPinJiaoFuWenTiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Mr.liu
 * @Date 2020/7/3 20:40
 * @Version 1.0
 * 需求:产品交付的问题反馈
 */
@Service
@Transactional
public class ChanPinJiaoFuWenTiServiceImpl implements ChanPinJiaoFuWenTiService {
    @Autowired
    private ChanPinJiaoFuWenTiDao chanPinJiaoFuWenTiDao;

    @Override
    public void deletWenTiByIds(Integer[] ids) {
        chanPinJiaoFuWenTiDao.deletWenTiByIds(ids);
    }

    @Override
    public List<ChanPinJiaoFuWenTiEntity> findWenTiByName(String xiangMuName, Integer page, Integer size) {
        return chanPinJiaoFuWenTiDao.findWenTiByName(xiangMuName);
    }

    @Override
    public void editWenTiById(ChanPinJiaoFuWenTiEntity chanPinJiaoFuWenTiEntity) {
        chanPinJiaoFuWenTiDao.editWenTiById(chanPinJiaoFuWenTiEntity);
    }

    @Override
    public void addWenTi(ChanPinJiaoFuWenTiEntity chanPinJiaoFuWenTiEntity) {
        chanPinJiaoFuWenTiDao.addWenTi(chanPinJiaoFuWenTiEntity);
    }

    @Override
    public List<DepartmentEntity> findAllDepartment() {
        return chanPinJiaoFuWenTiDao.findAllDepartment();
    }

    @Override
    public List<ChanPinJiaoFuWenTiEntity> findAllData(Integer page, Integer size) {
        return chanPinJiaoFuWenTiDao.findAllData();
    }
}
