package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.common.exception.BaseRuntimeException;
import com.yintu.ruixing.common.util.ExportExcelUtil;
import com.yintu.ruixing.common.util.FileUtil;
import com.yintu.ruixing.common.util.ImportExcelUtil;
import com.yintu.ruixing.dao.SparePartsDao;
import com.yintu.ruixing.entity.CheZhanEntity;
import com.yintu.ruixing.entity.EquipmentEntity;
import com.yintu.ruixing.entity.SparePartsEntity;
import com.yintu.ruixing.service.CheZhanService;
import com.yintu.ruixing.service.EquipmentService;
import com.yintu.ruixing.service.SparePartsService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
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
    @Autowired
    private CheZhanService cheZhanService;
    @Autowired
    private EquipmentService equipmentService;

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
        for (String[] rows : content) {
            SparePartsEntity sparePartsEntity = new SparePartsEntity();
            String cheZhanName = rows[1];
            List<CheZhanEntity> cheZhanEntities = cheZhanService.findByCzName(cheZhanName);
            if (!cheZhanEntities.isEmpty())
                sparePartsEntity.setCheZhanId((int) cheZhanEntities.get(0).getCid());

            String equipmentName = rows[2];
            List<EquipmentEntity> equipmentEntities = equipmentService.findByName(equipmentName);
            if (!equipmentEntities.isEmpty())
                sparePartsEntity.setEquipmentId(equipmentEntities.get(0).getId());
            sparePartsEntity.setEquipmentNumber(rows[3]);
            String equipmentStatus = rows[4];
            sparePartsEntity.setEquipmentStatus("良好".equals(equipmentStatus) ? (short) 1 : "一般".equals(equipmentStatus) ? (short) 2 :
                    "不可用".equals(equipmentStatus) ? (short) 3 : 1);
            if (rows[5] == null) {
                throw new BaseRuntimeException("开始日期或者结束日期不能为空");
            }
            Date createDate = null;
            try {
                createDate = new SimpleDateFormat("yyyy-MM-dd").parse(rows[5]);
            } catch (ParseException e) {
                throw new BaseRuntimeException("日期转换有误");
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(createDate);
            Short storageTime = null;
            switch (rows[6]) {
                case "三个月":
                    storageTime = (short) 1;
                    calendar.add(Calendar.MONTH, 3);
                    break;
                case "半年":
                    storageTime = (short) 2;
                    calendar.add(Calendar.MONTH, 6);
                    break;
                case "一年":
                    storageTime = (short) 3;
                    calendar.add(Calendar.YEAR, 1);
                    break;
                case "二年":
                    storageTime = (short) 4;
                    calendar.add(Calendar.YEAR, 2);
                    break;
                default:
                    throw new BaseRuntimeException("存储时间修改有误");
            }
            sparePartsEntity.setCreateDate(createDate);
            sparePartsEntity.setStorageTime(storageTime);
            sparePartsEntity.setEndDate(calendar.getTime());
            sparePartsEntity.setIsReplace("否".equals(rows[7]) ? (short) 0 : "是".equals(rows[7]) ? (short) 1 : 0);
            sparePartsEntities.add(sparePartsEntity);
        }
        if (!sparePartsEntities.isEmpty())
            this.add(sparePartsEntities);
    }

    @Override
    public void templateFile(OutputStream outputStream) throws IOException {
        //excel标题
        String title = "备品实验列表";
        //excel表名
        String[] headers = {"序号", "车站名称", "设备名称", "设备编号", "设备状态", "创建日期", "存储时间", "是否倒换"};
        //创建HSSFWorkbook
        XSSFWorkbook wb = ExportExcelUtil.getXSSFWorkbook(title, headers, new String[0][0]);
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
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
            content[i][7] = sparePartsEntity.getIsReplace().equals((short) 0) ? "否" : sparePartsEntity.getIsReplace().equals((short) 1) ? "是" : "";
        }
        //创建HSSFWorkbook
        XSSFWorkbook wb = ExportExcelUtil.getXSSFWorkbook(title, headers, content);
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }
}
