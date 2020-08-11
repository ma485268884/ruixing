package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.ZhiShiGuanLiFileTypeDao;
import com.yintu.ruixing.dao.ZhiShiGuanLiFileTypeFileDao;
import com.yintu.ruixing.entity.ZhiShiGuanLiFileTypeEntity;
import com.yintu.ruixing.entity.ZhiShiGuanLiFileTypeFileEntity;
import com.yintu.ruixing.service.ZhiShiGuanLiFileTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author Mr.liu
 * @Date 2020/8/11 17:22
 * @Version 1.0
 * 需求:知识管理  文件类型
 */
@Service
@Transactional
public class ZhiShiGuanLiFileTypeServiceImpl implements ZhiShiGuanLiFileTypeService {
    @Autowired
    private ZhiShiGuanLiFileTypeDao zhiShiGuanLiFileTypeDao;

    @Autowired
    private ZhiShiGuanLiFileTypeFileDao zhiShiGuanLiFileTypeFileDao;

    @Override
    public void updateFileById(ZhiShiGuanLiFileTypeFileEntity zhiShiGuanLiFileTypeFileEntity) {
        zhiShiGuanLiFileTypeFileDao.updateByPrimaryKeySelective(zhiShiGuanLiFileTypeFileEntity);
    }

    @Override
    public void addOneFile(String fileName, Date createtime, String filePath, Integer id1, Integer tid) {
        zhiShiGuanLiFileTypeFileDao.addOneFile(fileName,createtime,filePath,id1,tid);
    }

    @Override
    public ZhiShiGuanLiFileTypeFileEntity findFile(Integer id) {
        return zhiShiGuanLiFileTypeFileDao.selectByPrimaryKey(id);
    }

    @Override
    public void addFile(ZhiShiGuanLiFileTypeFileEntity zhiShiGuanLiFileTypeFileEntity) {
        zhiShiGuanLiFileTypeFileEntity.setParentid(0);
        zhiShiGuanLiFileTypeFileDao.insertSelective(zhiShiGuanLiFileTypeFileEntity);
    }

    @Override
    public void editFileTypeById(ZhiShiGuanLiFileTypeEntity zhiShiGuanLiFileTypeEntity) {
        zhiShiGuanLiFileTypeDao.updateByPrimaryKeySelective(zhiShiGuanLiFileTypeEntity);
    }

    @Override
    public void addFileType(ZhiShiGuanLiFileTypeEntity zhiShiGuanLiFileTypeEntity) {
        zhiShiGuanLiFileTypeDao.insertSelective(zhiShiGuanLiFileTypeEntity);
    }

    @Override
    public List<ZhiShiGuanLiFileTypeEntity> findSomeFileType(Integer page, Integer size, String fileTypeName) {
        return zhiShiGuanLiFileTypeDao.findSomeFileType(fileTypeName);
    }
}
