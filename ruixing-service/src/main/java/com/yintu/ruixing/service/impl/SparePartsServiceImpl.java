package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.common.exception.BaseRuntimeException;
import com.yintu.ruixing.common.util.ExportExcelUtil;
import com.yintu.ruixing.common.util.FileUtils;
import com.yintu.ruixing.common.util.ImportExcelUtil;
import com.yintu.ruixing.dao.SparePartsDao;
import com.yintu.ruixing.entity.SparePartsEntity;
import com.yintu.ruixing.service.SparePartsService;
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
 * @date:2020/7/11 11:54
 */
@Service
@Transactional
public class SparePartsServiceImpl implements SparePartsService {
    @Autowired
    private SparePartsDao sparePartsDao;

    @Override
    public void add(SparePartsEntity entity) {
        entity.setCreatedDate(new Date());
        sparePartsDao.insertSelective(entity);
    }

    @Override
    public void remove(Integer id) {
        sparePartsDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(SparePartsEntity entity) {
        sparePartsDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public SparePartsEntity findById(Integer id) {
        return sparePartsDao.selectByPrimaryKey(id);
    }

    @Override
    public void add(List<SparePartsEntity> sparePartsEntities) {
        sparePartsDao.insertMuch(sparePartsEntities);
    }

    @Override
    public void delete(Integer[] ids) {
        sparePartsDao.deleteMuch(ids);
    }

    @Override
    public List<SparePartsEntity> findByCondition(Integer[] ids, String equipmentName) {
        return sparePartsDao.selectByCondition(ids, equipmentName);
    }

    @Override
    public void importFile(InputStream inputStream, String fileName) throws IOException {
        //excel标题
        String title = "备品实验列表";
        String[][] content;
        if ("xls".equals(FileUtils.getExtensionName(fileName))) {
            content = ImportExcelUtil.getHSSFData(title, new HSSFWorkbook(inputStream));
        } else if ("xlsx".equals(FileUtils.getExtensionName(fileName))) {
            content = ImportExcelUtil.getXSSFData(title, new XSSFWorkbook(inputStream));
        } else {
            throw new BaseRuntimeException("文件格式有误");
        }
        List<SparePartsEntity> sparePartsEntities = new ArrayList<>();
        for (String[] columns : content) {
            SparePartsEntity sparePartsEntity = new SparePartsEntity();
            sparePartsEntity.setEquipmentName(columns[1]);
            sparePartsEntity.setStorageTime(columns[2]);
            sparePartsEntity.setExaminationPeriod(columns[3]);
            String examinationStatus = columns[4];
            sparePartsEntity.setExaminationStatus("未检查".equals(examinationStatus) ? (short) 1 : "复查".equals(examinationStatus) ? (short) 2 : "开箱通风".equals(examinationStatus) ? (short) 3 : (short) 1);
            String functionalStatus = columns[5];
            sparePartsEntity.setFunctionalStatus("一般".equals(functionalStatus) ? (short) 1 : "良好".equals(functionalStatus) ? (short) 2 : (short) 1);
            sparePartsEntity.setCreatedDate(new Date());
            sparePartsEntities.add(sparePartsEntity);
        }
        if (!sparePartsEntities.isEmpty())
            this.add(sparePartsEntities);
    }

    @Override
    public void exportFile(OutputStream outputStream, Integer[] ids) throws IOException {
        //excel标题
        String title = "备品实验列表";
        //excel表名
        String[] headers = {"序号", "器材名称", "存储时间", "检查周期", "检查状态", "功能状态"};
        //获取数据
        List<SparePartsEntity> sparePartsEntities = this.findByCondition(ids, null);
        sparePartsEntities = sparePartsEntities.stream()
                .sorted(Comparator.comparing(SparePartsEntity::getId).reversed())
                .collect(Collectors.toList());
        //excel元素
        String[][] content = new String[sparePartsEntities.size()][headers.length];
        for (int i = 0; i < sparePartsEntities.size(); i++) {
            SparePartsEntity sparePartsEntity = sparePartsEntities.get(i);
            content[i][0] = sparePartsEntity.getId().toString();
            content[i][1] = sparePartsEntity.getEquipmentName();
            content[i][2] = sparePartsEntity.getStorageTime();
            content[i][3] = sparePartsEntity.getExaminationPeriod();
            Short examinationStatus = sparePartsEntity.getExaminationStatus();
            content[i][4] = examinationStatus.equals((short) 1) ? "未检查" : examinationStatus.equals((short) 2) ? "复查" : examinationStatus.equals((short) 3) ? "开箱通风" : "未检查";
            Short functionalStatus = sparePartsEntity.getFunctionalStatus();
            content[i][5] = functionalStatus.equals((short) 1) ? "一般" : functionalStatus.equals((short) 2) ? "良好" : "一般";
        }
        //创建HSSFWorkbook
        XSSFWorkbook wb = ExportExcelUtil.getXSSFWorkbook(title, headers, content);
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }
}
