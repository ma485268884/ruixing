package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.entity.BiddingFileEntity;
import com.yintu.ruixing.entity.PreSaleFileEntity;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author:mlf
 * @date:2020/7/2 14:26
 */
public interface BiddingFileService extends BaseService<BiddingFileEntity, Integer> {
    /**
     * 批量删除
     *
     * @param ids id集合
     */
    void remove(Integer[] ids);

    /**
     * @param year        年份
     * @param projectName 项目名称
     * @param type        文件类型
     * @return
     */
    List<BiddingFileEntity> findByYearAndProjectNameAndType(Integer year, String projectName, String type);

    /**
     * @param outputStream 输出流
     * @param ids          id 集合
     * @throws IOException io异常
     */
    void exportFile(OutputStream outputStream, Integer[] ids) throws IOException;
}
