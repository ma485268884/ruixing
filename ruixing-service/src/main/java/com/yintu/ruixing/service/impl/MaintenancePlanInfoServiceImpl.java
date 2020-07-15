package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.common.exception.BaseRuntimeException;
import com.yintu.ruixing.common.util.ExportExcelUtil;
import com.yintu.ruixing.common.util.FileUtil;
import com.yintu.ruixing.common.util.ImportExcelUtil;
import com.yintu.ruixing.dao.MaintenancePlanInfoDao;
import com.yintu.ruixing.entity.CheZhanEntity;
import com.yintu.ruixing.entity.EquipmentEntity;
import com.yintu.ruixing.entity.MaintenancePlanEntity;
import com.yintu.ruixing.entity.MaintenancePlanInfoEntity;
import com.yintu.ruixing.service.CheZhanService;
import com.yintu.ruixing.service.EquipmentService;
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
import java.text.SimpleDateFormat;
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
        if (entity.getStartDate().after(entity.getEndDate()))
            throw new BaseRuntimeException("开始日期不能大于结束日期");
        entity.setCreatedDate(new Date());
        maintenancePlanInfoDao.insertSelective(entity);
    }

    @Override
    public void remove(Integer id) {
        maintenancePlanInfoDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(MaintenancePlanInfoEntity entity) {
        if (entity.getStartDate().after(entity.getEndDate()))
            throw new BaseRuntimeException("开始日期不能大于结束日期");
        maintenancePlanInfoDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public MaintenancePlanInfoEntity findById(Integer id) {
        List<MaintenancePlanInfoEntity> maintenancePlanInfoEntities = maintenancePlanInfoDao.selectByCondition(new Integer[]{id}, null, null);
        return maintenancePlanInfoEntities.size() > 0 ? maintenancePlanInfoEntities.get(0) : null;
    }

    @Override
    public void remove(Integer[] ids) {
        for (Integer id : ids) {
            this.remove(id);
        }
    }

    @Override
    public List<MaintenancePlanInfoEntity> findByCondition(Integer[] ids, Integer maintenancePlanId, String equipmentName) {
        return maintenancePlanInfoDao.selectByCondition(ids, maintenancePlanId, equipmentName);
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
        String[] headers = {"序号", "维护计划", "车站名称", "设备类型", "开始日期", "结束日期"};
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
            content[i][2] = maintenancePlanInfoEntity.getCheZhanEntity().getCzName();
            content[i][3] = maintenancePlanInfoEntity.getEquipmentEntity().getName();
            content[i][4] = new SimpleDateFormat("yyyy-MM-dd").format(maintenancePlanInfoEntity.getStartDate());
            content[i][5] = new SimpleDateFormat("yyyy-MM-dd").format(maintenancePlanInfoEntity.getEndDate());

        }
        //创建HSSFWorkbook
        XSSFWorkbook wb = ExportExcelUtil.getXSSFWorkbook(title, headers, content);
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }

}
