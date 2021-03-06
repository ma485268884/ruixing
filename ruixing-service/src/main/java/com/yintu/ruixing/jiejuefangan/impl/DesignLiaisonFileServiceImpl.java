package com.yintu.ruixing.jiejuefangan.impl;

import com.yintu.ruixing.common.util.ExportExcelUtil;
import com.yintu.ruixing.jiejuefangan.DesignLiaisonEntity;
import com.yintu.ruixing.jiejuefangan.DesignLiaisonFileAuditorEntity;
import com.yintu.ruixing.jiejuefangan.DesignLiaisonFileDao;
import com.yintu.ruixing.jiejuefangan.DesignLiaisonFileEntity;
import com.yintu.ruixing.jiejuefangan.DesignLiaisonFileAuditorService;
import com.yintu.ruixing.jiejuefangan.DesignLiaisonFileService;
import com.yintu.ruixing.jiejuefangan.DesignLiaisonService;
import com.yintu.ruixing.xitongguanli.UserService;
import com.yintu.ruixing.xitongguanli.UserEntity;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author:mlf
 * @date:2020/7/3 11:17
 */
@Service
@Transactional
public class DesignLiaisonFileServiceImpl implements DesignLiaisonFileService {

    @Autowired
    private DesignLiaisonFileDao designLiaisonFileDao;

    @Autowired
    private DesignLiaisonService designLiaisonService;
    @Autowired
    private DesignLiaisonFileAuditorService designLiaisonFileAuditorService;

    @Autowired
    private UserService userService;

    @Override
    public void add(DesignLiaisonFileEntity entity) {
        entity.setUploadDatetime(new Date());
        designLiaisonFileDao.insertSelective(entity);
    }


    @Override
    public void remove(Integer id) {
        designLiaisonFileDao.deleteByPrimaryKey(id);
        designLiaisonFileAuditorService.removeByDesignLiaisonFileId(id);
    }

    @Override
    public void edit(DesignLiaisonFileEntity entity) {
        designLiaisonFileDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public DesignLiaisonFileEntity findById(Integer id) {
        return designLiaisonFileDao.selectByPrimaryKey(id);
    }

    @Override
    public void add(DesignLiaisonFileEntity designLiaisonFileEntity, Integer[] auditorIds) {
        this.add(designLiaisonFileEntity);
        Integer id = designLiaisonFileEntity.getId();
        if (auditorIds != null) {
            List<DesignLiaisonFileAuditorEntity> designLiaisonFileAuditorEntities = new ArrayList<>(auditorIds.length);
            for (Integer auditorId : auditorIds) {
                if (auditorId != null) {
                    DesignLiaisonFileAuditorEntity designLiaisonFileAuditorEntity = new DesignLiaisonFileAuditorEntity();
                    designLiaisonFileAuditorEntity.setDesignLiaisonFileId(id);
                    designLiaisonFileAuditorEntity.setAuditorId(auditorId);
                    designLiaisonFileAuditorEntity.setIsPass((short) 0);
                    designLiaisonFileAuditorEntities.add(designLiaisonFileAuditorEntity);
                }
            }
            if (designLiaisonFileAuditorEntities.size() > 0)
                designLiaisonFileAuditorService.addMuch(designLiaisonFileAuditorEntities);
        }
    }

    @Override
    public void edit(DesignLiaisonFileEntity designLiaisonFileEntity, Integer[] auditorIds) {
        this.edit(designLiaisonFileEntity);
        Integer id = designLiaisonFileEntity.getId();
        designLiaisonFileAuditorService.removeByDesignLiaisonFileId(id);
        if (auditorIds != null) {
            List<DesignLiaisonFileAuditorEntity> designLiaisonFileAuditorEntities = new ArrayList<>(auditorIds.length);
            for (Integer auditorId : auditorIds) {
                if (auditorId != null) {
                    DesignLiaisonFileAuditorEntity designLiaisonFileAuditorEntity = new DesignLiaisonFileAuditorEntity();
                    designLiaisonFileAuditorEntity.setDesignLiaisonFileId(id);
                    designLiaisonFileAuditorEntity.setAuditorId(auditorId);
                    designLiaisonFileAuditorEntity.setIsPass((short) 0);
                    designLiaisonFileAuditorEntities.add(designLiaisonFileAuditorEntity);
                }
            }
            if (designLiaisonFileAuditorEntities.size() > 0)
                designLiaisonFileAuditorService.addMuch(designLiaisonFileAuditorEntities);
        }
    }

    @Override
    public DesignLiaisonFileEntity findDesignLiaisonById(Integer id) {
        DesignLiaisonFileEntity designLiaisonFileEntity = this.findById(id);
        Integer designLiaisonId = designLiaisonFileEntity.getDesignLiaisonId();
        if (designLiaisonId != null) {
            DesignLiaisonEntity designLiaisonEntity = designLiaisonService.findById(designLiaisonId);
            designLiaisonFileEntity.setDesignLiaisonEntity(designLiaisonEntity);
        }
        List<DesignLiaisonFileAuditorEntity> designLiaisonFileAuditorEntities = designLiaisonFileAuditorService.findByDesignLiaisonFileId(id);
        designLiaisonFileEntity.setDesignLiaisonFileAuditorEntities(designLiaisonFileAuditorEntities);
        return designLiaisonFileEntity;
    }


    @Override
    public void remove(Integer[] ids) {
        for (Integer id : ids) {
            this.remove(id);
        }
    }

    @Override
    public List<DesignLiaisonFileEntity> findByYearAndProjectNameAndType(Integer year, String projectName, String type) {
        return designLiaisonFileDao.selectByCondition(year, projectName, null, type == null ? null : "输入文件".equals(type) ? (short) 1 : (short) 2);
    }

    @Override
    public void exportFile(OutputStream outputStream, Integer[] ids) throws IOException {
        //excel标题
        String title = "设计联络及后续技术交流列表";
        //excel表名
        String[] headers = {"序号", "年份", "项目名称", "招标人", "项目状态", "任务状态", "会议状态", "变更状态", "文件类型", "文件名称"};
        //获取数据
        List<DesignLiaisonFileEntity> designLiaisonFileEntities = designLiaisonFileDao.selectByCondition(null, null, ids, null);
        designLiaisonFileEntities = designLiaisonFileEntities.stream()
                .sorted(Comparator.comparing(DesignLiaisonFileEntity::getId).reversed())
                .collect(Collectors.toList());
        //excel元素
        String[][] content = new String[designLiaisonFileEntities.size()][headers.length];
        for (int i = 0; i < designLiaisonFileEntities.size(); i++) {
            DesignLiaisonFileEntity designLiaisonFileEntity = designLiaisonFileEntities.get(i);
            DesignLiaisonEntity designLiaisonEntity = designLiaisonFileEntity.getDesignLiaisonEntity();
            content[i][0] = designLiaisonFileEntity.getId().toString();
            content[i][1] = Integer.valueOf(designLiaisonEntity.getProjectDate().getYear() + 1900).toString();
            content[i][2] = designLiaisonEntity.getProjectName();
            content[i][3] = designLiaisonEntity.getBidder();
            Short projectStatus = designLiaisonEntity.getProjectStatus();
            content[i][4] = projectStatus.equals((short) 1) ? "未知" : projectStatus.equals((short) 2) ? "后续招标" : projectStatus.equals((short) 3) ? "确定采用" : projectStatus.equals((short) 4) ? "关闭" : "未知";
            Short taskStatus = designLiaisonEntity.getTaskStatus();
            content[i][5] = taskStatus.equals((short) 1) ? "正在进行" : taskStatus.equals((short) 2) ? "已完成" : "正在进行";
            Short meetingStatus = designLiaisonEntity.getMeetingStatus();
            content[i][6] = meetingStatus.equals((short) 1) ? "不召开会议" : meetingStatus.equals((short) 2) ? "尚未开会" : meetingStatus.equals((short) 3) ? "已召开设计联络会" : "不召开会议";
            Short changeStatus = designLiaisonEntity.getChangeStatus();
            content[i][7] = changeStatus.equals((short) 1) ? "无变更" : changeStatus.equals((short) 2) ? "变更设计中" : changeStatus.equals((short) 3) ? "变更已定型" : "无变更";
            Short type = designLiaisonFileEntity.getType();
            content[i][8] = type.equals((short) 1) ? "输入文件" : type.equals((short) 2) ? "输出文件" : "输入文件";
            content[i][9] = designLiaisonFileEntity.getName();
        }
        //创建HSSFWorkbook
        XSSFWorkbook wb = ExportExcelUtil.getXSSFWorkbook(title, headers, content);
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }

    @Override
    public List<UserEntity> findUserEntitiesBytTruename(String truename) {
        return userService.findByTruename(truename);
    }
}
