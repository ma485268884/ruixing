package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.common.exception.BaseRuntimeException;
import com.yintu.ruixing.common.util.ExportExcelUtil;
import com.yintu.ruixing.common.util.FileUtil;
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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
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
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(entity.getCreateDate());
        switch (entity.getStorageTime()) {
            case 1:
                calendar.add(Calendar.MONTH, 3);
                break;
            case 2:
                calendar.add(Calendar.MONTH, 6);
                break;
            case 3:
                calendar.add(Calendar.YEAR, 1);
                break;
            case 4:
                calendar.add(Calendar.YEAR, 2);
                break;
            default:
                throw new BaseRuntimeException("存储时间添加有误");
        }
        entity.setEndDate(calendar.getTime());
        sparePartsDao.insertSelective(entity);
    }

    @Override
    public void remove(Integer id) {
        sparePartsDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(SparePartsEntity entity) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(entity.getCreateDate());
        switch (entity.getStorageTime()) {
            case 1:
                calendar.add(Calendar.MONTH, 3);
                break;
            case 2:
                calendar.add(Calendar.MONTH, 6);
                break;
            case 3:
                calendar.add(Calendar.YEAR, 1);
                break;
            case 4:
                calendar.add(Calendar.YEAR, 2);
                break;
            default:
                throw new BaseRuntimeException("存储时间修改有误");
        }
        entity.setEndDate(calendar.getTime());
        sparePartsDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public SparePartsEntity findById(Integer id) {
        List<SparePartsEntity> sparePartsEntities = sparePartsDao.selectByCondition(new Integer[]{id}, null);
        return sparePartsEntities.isEmpty() ? null : sparePartsEntities.get(0);
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
        if ("xls".equals(FileUtil.getExtensionName(fileName))) {
            content = ImportExcelUtil.getHSSFData(title, new HSSFWorkbook(inputStream));
        } else if ("xlsx".equals(FileUtil.getExtensionName(fileName))) {
            content = ImportExcelUtil.getXSSFData(title, new XSSFWorkbook(inputStream));
        } else {
            throw new BaseRuntimeException("文件格式有误");
        }
        List<SparePartsEntity> sparePartsEntities = new ArrayList<>();
        for (String[] columns : content) {
            SparePartsEntity sparePartsEntity = new SparePartsEntity();
//            sparePartsEntity.setEquipmentName(columns[1]);
//            sparePartsEntity.setStorageTime(columns[2]);
//            sparePartsEntity.setExaminationPeriod(columns[3]);
//            String examinationStatus = columns[4];
//            sparePartsEntity.setExaminationStatus("未检查".equals(examinationStatus) ? (short) 1 : "复查".equals(examinationStatus) ? (short) 2 : "开箱通风".equals(examinationStatus) ? (short) 3 : (short) 1);
//            String functionalStatus = columns[5];
//            sparePartsEntity.setFunctionalStatus("一般".equals(functionalStatus) ? (short) 1 : "良好".equals(functionalStatus) ? (short) 2 : (short) 1);
//            sparePartsEntity.setCreatedDate(new Date());
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
        String[] headers = {"序号", "车站名称", "设备名称", "设备编号", "设备状态", "创建日期", "存储时间", "是否倒换"};
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
            content[i][1] = sparePartsEntity.getCheZhanEntity().getCzName();
            content[i][2] = sparePartsEntity.getEquipmentEntity().getName();
            content[i][3] = sparePartsEntity.getEquipmentNumber();
            Short equipmentStatus = sparePartsEntity.getEquipmentStatus();
            content[i][4] = equipmentStatus.equals((short) 1) ? "良好" : equipmentStatus.equals((short) 2) ? "一般" : equipmentStatus.equals((short) 3) ? "不可用" : "";
            content[i][5] = new SimpleDateFormat("yyyy-MM-dd").format(sparePartsEntity.getCreateDate());
            Short storageTime = sparePartsEntity.getStorageTime();
            content[i][6] = storageTime.equals((short) 1) ? "三个月" : storageTime.equals((short) 2) ? "半年" : storageTime.equals((short) 3) ? "一年" : storageTime.equals((short) 4) ? "两年" : "";
            content[i][7] = sparePartsEntity.getIsReplace().equals((short) 0) ? "未倒换" : sparePartsEntity.getIsReplace().equals((short) 1) ? "倒换" : "";
        }
        //创建HSSFWorkbook
        XSSFWorkbook wb = ExportExcelUtil.getXSSFWorkbook(title, headers, content);
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }
}
