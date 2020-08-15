package com.yintu.ruixing.paigongguanli.impl;

import com.yintu.ruixing.paigongguanli.PaiGongGuanLiBusinessTypeDao;
import com.yintu.ruixing.paigongguanli.PaiGongGuanLiBusinessTypeEntity;
import com.yintu.ruixing.paigongguanli.PaiGongGuanLiBusinessTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Mr.liu
 * @Date 2020/8/14 15:17
 * @Version 1.0
 * 需求:派工管理  任务类型
 */
@Service
@Transactional
public class PaiGongGuanLiBusinessTypeServiceImpl implements PaiGongGuanLiBusinessTypeService {
    @Autowired
    private PaiGongGuanLiBusinessTypeDao paiGongGuanLiBusinessTypeDao;

    @Override
    public void deleteBusinessTypeByIds(Integer[] ids) {
        for (int i = 0; i < ids.length; i++) {
            paiGongGuanLiBusinessTypeDao.deleteByPrimaryKey(ids[i]);
        }
    }

    @Override
    public List<PaiGongGuanLiBusinessTypeEntity> findBusinessType(Integer page, Integer size, String typeName, String businessName) {
        return paiGongGuanLiBusinessTypeDao.findBusinessType(typeName,businessName);
    }

    @Override
    public void editBusinessTypeById(PaiGongGuanLiBusinessTypeEntity paiGongGuanLiBusinessTypeEntity) {
        paiGongGuanLiBusinessTypeDao.updateByPrimaryKeySelective(paiGongGuanLiBusinessTypeEntity);
    }

    @Override
    public void addBusinessType(PaiGongGuanLiBusinessTypeEntity paiGongGuanLiBusinessTypeEntity) {
        paiGongGuanLiBusinessTypeDao.insertSelective(paiGongGuanLiBusinessTypeEntity);
    }
}
