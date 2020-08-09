package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.AnZhuangTiaoShiWenTiDao;
import com.yintu.ruixing.entity.AnZhuangTiaoShiWenTiEntity;
import com.yintu.ruixing.service.AnZhuangTiaoShiWenTiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Mr.liu
 * @Date 2020/8/9 10:30
 * @Version 1.0
 * 需求:安装调试 问题跟踪
 */
@Service
@Transactional
public class AnZhuangTiaoShiWenTiServiceImpl implements AnZhuangTiaoShiWenTiService {
    @Autowired
    private AnZhuangTiaoShiWenTiDao anZhuangTiaoShiWenTiDao;

    @Override
    public void deleteWenTiByIds(Integer[] ids) {
        for (int i = 0; i < ids.length; i++) {
            anZhuangTiaoShiWenTiDao.deleteByPrimaryKey(ids[i]);
        }
    }

    @Override
    public List<AnZhuangTiaoShiWenTiEntity> findSomeWenTi(Integer page, Integer size, String xdname, String wenTiMiaoShu) {
        return anZhuangTiaoShiWenTiDao.findSomeWenTi(xdname,wenTiMiaoShu);
    }

    @Override
    public void editWenTiById(AnZhuangTiaoShiWenTiEntity anZhuangTiaoShiWenTiEntity) {
        anZhuangTiaoShiWenTiDao.updateByPrimaryKeySelective(anZhuangTiaoShiWenTiEntity);
    }

    @Override
    public void addWenTi(AnZhuangTiaoShiWenTiEntity anZhuangTiaoShiWenTiEntity) {
        anZhuangTiaoShiWenTiEntity.setWentiisover(0);
        anZhuangTiaoShiWenTiDao.insertSelective(anZhuangTiaoShiWenTiEntity);
    }
}
