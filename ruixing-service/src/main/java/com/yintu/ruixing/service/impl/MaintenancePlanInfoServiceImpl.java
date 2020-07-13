package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.common.exception.BaseRuntimeException;
import com.yintu.ruixing.common.util.ExportExcelUtil;
import com.yintu.ruixing.common.util.FileUtil;
import com.yintu.ruixing.common.util.ImportExcelUtil;
import com.yintu.ruixing.dao.MaintenancePlanInfoDao;
import com.yintu.ruixing.entity.MaintenancePlanEntity;
import com.yintu.ruixing.entity.MaintenancePlanInfoEntity;
import com.yintu.ruixing.service.MaintenancePlanInfoService;
import com.yintu.ruixing.service.MaintenancePlanService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author:mlf
 * @date:2020/7/9 16:40
 */
@Service
@Transactional
public class MaintenancePlanInfoServiceImpl implements MaintenancePlanInfoService {

    @Autowired
    private MaintenancePlanInfoDao maintenancePlanInfoDao;
    @Autowired
    private MaintenancePlanService maintenancePlanService;

    @Override
    public void add(MaintenancePlanInfoEntity entity) {
        entity.setCreatedDate(new Date());
        maintenancePlanInfoDao.insertSelective(entity);
    }

    @Override
    public void remove(Integer id) {
        maintenancePlanInfoDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(MaintenancePlanInfoEntity entity) {
        maintenancePlanInfoDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public MaintenancePlanInfoEntity findById(Integer id) {
        return maintenancePlanInfoDao.selectByPrimaryKey(id);
    }


    @Override
    public MaintenancePlanInfoEntity findMaintenancePlanById(Integer id) {
        MaintenancePlanInfoEntity maintenancePlanInfoEntity = this.findById(id);
        if (maintenancePlanInfoEntity != null) {
            Integer maintenancePlanId = maintenancePlanInfoEntity.getMaintenancePlanId();
            MaintenancePlanEntity maintenancePlanEntity = maintenancePlanService.findById(maintenancePlanId);
            maintenancePlanInfoEntity.setMaintenancePlanEntity(maintenancePlanEntity);
        }
        return maintenancePlanInfoEntity;
    }

    @Override
    public void remove(Integer[] ids) {
        for (Integer id : ids) {
            this.remove(id);
        }
    }

    @Override
    public List<MaintenancePlanInfoEntity> findByCondition(Integer[] ids, Integer maintenancePlanId, String work) {
        return maintenancePlanInfoDao.selectByCondition(ids, maintenancePlanId, work);
    }

    @Override
    public void add(List<MaintenancePlanInfoEntity> maintenancePlanInfoEntities) {
        maintenancePlanInfoDao.insertMuch(maintenancePlanInfoEntities);
    }

    @Override
    public void importFile(InputStream inputStream, String fileName, Integer maintenancePlanId) throws IOException {
        MaintenancePlanEntity maintenancePlanEntity = maintenancePlanService.findById(maintenancePlanId);
        String name = maintenancePlanEntity.getName();
        //excel标题
        String title = "维护计划详情列表";
        String[][] content;
        if ("xls".equals(FileUtil.getExtensionName(fileName))) {
            content = ImportExcelUtil.getHSSFData(title, new HSSFWorkbook(inputStream));
        } else if ("xlsx".equals(FileUtil.getExtensionName(fileName))) {
            content = ImportExcelUtil.getXSSFData(title, new XSSFWorkbook(inputStream));
        } else {
            throw new BaseRuntimeException("文件格式有误");
        }
        List<MaintenancePlanInfoEntity> maintenancePlanInfoEntities = new ArrayList<>();
        for (String[] rows : content) {
            if (name.contains(rows[1])) {
                MaintenancePlanInfoEntity maintenancePlanInfoEntity = new MaintenancePlanInfoEntity();
                maintenancePlanInfoEntity.setWork(rows[2]);
                maintenancePlanInfoEntity.setPeriod(rows[3]);
                maintenancePlanInfoEntity.setResult(rows[3]);
                maintenancePlanInfoEntity.setMaintenancePlanId(maintenancePlanId);
                maintenancePlanInfoEntity.setCreatedDate(new Date());
                maintenancePlanInfoEntities.add(maintenancePlanInfoEntity);
            }
        }
        if (!maintenancePlanInfoEntities.isEmpty())
            this.add(maintenancePlanInfoEntities);
    }

    @Override
    public void exportFile(OutputStream outputStream, Integer[] ids) throws IOException {
        //excel标题
        String title = "维护计划详情列表";
        //excel表名
        String[] headers = {"序号", "维护计划", "维护工作", "维护周期", "维护结果"};
        //获取数据
        List<MaintenancePlanInfoEntity> maintenancePlanInfoEntities = this.findByCondition(ids, null, null);
        maintenancePlanInfoEntities = maintenancePlanInfoEntities.stream()
                .sorted(Comparator.comparing(MaintenancePlanInfoEntity::getId).reversed())
                .collect(Collectors.toList());
        //excel元素
        String[][] content = new String[maintenancePlanInfoEntities.size()][headers.length];
        for (int i = 0; i < maintenancePlanInfoEntities.size(); i++) {
            MaintenancePlanInfoEntity maintenancePlanInfoEntity = maintenancePlanInfoEntities.get(i);
            content[i][0] = maintenancePlanInfoEntity.getId().toString();
            content[i][1] = maintenancePlanInfoEntity.getMaintenancePlanEntity().getName();
            content[i][2] = maintenancePlanInfoEntity.getWork();
            content[i][3] = maintenancePlanInfoEntity.getPeriod();
            content[i][4] = maintenancePlanInfoEntity.getResult();
        }
        //创建HSSFWorkbook
        XSSFWorkbook wb = ExportExcelUtil.getXSSFWorkbook(title, headers, content);
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }

}
