package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.common.util.ExportExcelUtil;
import com.yintu.ruixing.dao.SolutionStatusDao;
import com.yintu.ruixing.entity.SolutionStatusEntity;
import com.yintu.ruixing.service.SolutionStatusService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author:mlf
 * @date:2020/6/22 16:02
 */
@Service
@Transactional
public class SolutionStatusServiceImpl implements SolutionStatusService {
    @Autowired
    private SolutionStatusDao solutionStatusDao;


    @Override
    public void add(SolutionStatusEntity entity) {
        solutionStatusDao.insertSelective(entity);
    }

    @Override
    public void remove(Integer id) {
        solutionStatusDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(SolutionStatusEntity entity) {
        solutionStatusDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public SolutionStatusEntity findById(Integer id) {
        return solutionStatusDao.selectByPrimaryKey(id);
    }

    @Override
    public void removeMuch(Integer[] ids) {
        for (Integer id : ids) {
            this.remove(id);
        }
    }

    @Override
    public List<SolutionStatusEntity> findByYearIdOrProjectIdOrFileTypeIdAndType(Integer id, Short nameType, Short type) {
        return solutionStatusDao.selectByYearIdOrProjectIdOrFileTypeIdAndType(id, nameType, type);
    }

    @Override
    public List<SolutionStatusEntity> findByProjectNameAndType(String projectName, Short type) {
        return solutionStatusDao.selectByProjectNameAndType(projectName, type);
    }

    @Override
    public List<SolutionStatusEntity> findByFileNameAndType(String fileName, Short type) {
        return solutionStatusDao.selectByFileNameAndType(fileName, type);
    }

    @Override
    public List<SolutionStatusEntity> findByIdsAndType(Integer[] ids, Short type) {
        return solutionStatusDao.selectByIdsAndType(ids, type);
    }

    @Override
    public void exportFile(HttpServletResponse response, Integer[] ids, Short type) throws IOException {
        //excel标题
        String title = "售前技术支持项目状态列表";
        //excel表名
        String[] headers = {"序号", "年份", "项目名称", "文件类型", "文件名称", "任务状态", "项目状态"};
        //excel文件名
        String fileName = title + System.currentTimeMillis() + ".xlsx";
        //获取数据
        List<SolutionStatusEntity> solutionStatusEntities = this.findByIdsAndType(ids, type);
        //excel元素
        String[][] content = new String[solutionStatusEntities.size()][headers.length];
        for (int i = 0; i < solutionStatusEntities.size(); i++) {
            SolutionStatusEntity solutionStatusEntity = solutionStatusEntities.get(i);
            content[i][0] = solutionStatusEntity.getId().toString();
            content[i][1] = solutionStatusEntity.getYearName();
            content[i][2] = solutionStatusEntity.getProjectName();
            content[i][3] = solutionStatusEntity.getFileTypeName();
            content[i][4] = solutionStatusEntity.getFileName();
            Short taskStatus = solutionStatusEntity.getTaskStatus();
            content[i][5] = taskStatus.equals((short) 1) ? "正在进行" : taskStatus.equals((short) 2) ? "已完成" : "正在进行";
            Short projectStatus = solutionStatusEntity.getProjectStatus();
            content[i][6] = projectStatus.equals((short) 1) ? "未知" : projectStatus.equals((short) 2) ? "后续招标" : projectStatus.equals((short) 3) ? "确定采用" : projectStatus.equals((short) 4) ? "关闭" : "未知";
        }
        //创建HSSFWorkbook
        XSSFWorkbook wb = ExportExcelUtil.getXSSFWorkbook(title, headers, content);

        //响应到客户端
        response.setContentType("application/octet-stream;charset=ISO8859-1");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1"));
        response.addHeader("Pargam", "no-cache");
        response.addHeader("Cache-Control", "no-cache");
        OutputStream os = response.getOutputStream();
        wb.write(os);
        os.flush();
        os.close();

    }

}
