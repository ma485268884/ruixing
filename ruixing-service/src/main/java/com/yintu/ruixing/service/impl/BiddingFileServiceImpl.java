package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.common.util.ExportExcelUtil;
import com.yintu.ruixing.dao.BiddingFileDao;
import com.yintu.ruixing.entity.BiddingEntity;
import com.yintu.ruixing.entity.BiddingFileEntity;
import com.yintu.ruixing.service.BiddingFileService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author:mlf
 * @date:2020/7/2 14:25
 */
@Service
@Transactional
public class BiddingFileServiceImpl implements BiddingFileService {

    @Autowired
    private BiddingFileDao biddingFileDao;

    @Override
    public void add(BiddingFileEntity entity) {
        biddingFileDao.insertSelective(entity);
    }

    @Override
    public void remove(Integer id) {
        biddingFileDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(BiddingFileEntity entity) {
        biddingFileDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public BiddingFileEntity findById(Integer id) {
        return biddingFileDao.selectByPrimaryKey(id);
    }

    @Override
    public void remove(Integer[] ids) {
        for (Integer id : ids) {
            this.remove(id);
        }
    }

    @Override
    public List<BiddingFileEntity> findByYearAndProjectNameAndType(Integer year, String projectName, String type) {
        return biddingFileDao.selectByCondition(year, projectName, null, type == null ? null : "输入文件".equals(type) ? (short) 1 : (short) 2);
    }

    @Override
    public void exportFile(OutputStream outputStream, Integer[] ids) throws IOException {
        //excel标题
        String title = "投招标技术支持列表";
        //excel表名
        String[] headers = {"序号", "年份", "项目名称", "招标人", "项目状态", "任务状态", "文件类型", "文件名称"};
        //获取数据
        List<BiddingFileEntity> biddingFileEntities = biddingFileDao.selectByCondition(null, null, ids, null);
        //excel元素
        String[][] content = new String[biddingFileEntities.size()][headers.length];
        for (int i = 0; i < biddingFileEntities.size(); i++) {
            BiddingFileEntity biddingFileEntity = biddingFileEntities.get(i);
            BiddingEntity biddingEntity = biddingFileEntity.getBiddingEntity();
            content[i][0] = biddingFileEntity.getId().toString();
            content[i][1] = Integer.valueOf(biddingEntity.getProjectDate().getYear() + 1900).toString();
            content[i][2] = biddingEntity.getProjectName();
            content[i][3] = biddingEntity.getBidder();
            Short projectStatus = biddingEntity.getProjectStatus();
            content[i][4] = projectStatus.equals((short) 1) ? "未知" : projectStatus.equals((short) 2) ? "后续招标" : projectStatus.equals((short) 3) ? "确定采用" : projectStatus.equals((short) 4) ? "关闭" : "未知";
            Short taskStatus = biddingEntity.getTaskStatus();
            content[i][5] = taskStatus.equals((short) 1) ? "正在进行" : taskStatus.equals((short) 2) ? "已完成" : "正在进行";
            Short type = biddingFileEntity.getType();
            content[i][6] = type.equals((short) 1) ? "输入文件" : type.equals((short) 2) ? "输出文件" : "输入文件";
            content[i][7] = biddingFileEntity.getName();
        }
        //创建HSSFWorkbook
        XSSFWorkbook wb = ExportExcelUtil.getXSSFWorkbook(title, headers, content);
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }
}
