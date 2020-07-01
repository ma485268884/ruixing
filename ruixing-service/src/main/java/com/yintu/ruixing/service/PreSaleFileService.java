package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.entity.PreSaleFileEntity;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author:mlf
 * @date:2020/6/30 18:58
 */
public interface PreSaleFileService extends BaseService<PreSaleFileEntity, Integer> {

    void remove(Integer[] ids);


    List<PreSaleFileEntity> findByYearAndProjectNameAndType(Integer year, String projectName, String type);


    void exportFile(OutputStream outputStream, Integer[] ids) throws IOException;
}
