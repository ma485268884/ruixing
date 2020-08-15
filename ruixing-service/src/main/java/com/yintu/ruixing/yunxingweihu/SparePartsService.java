package com.yintu.ruixing.yunxingweihu;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.yunxingweihu.SparePartsEntity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @author:mlf
 * @date:2020/7/11 11:52
 */
public interface SparePartsService extends BaseService<SparePartsEntity, Integer> {

    /**
     * 批量添加备品实验信息
     *
     * @param sparePartsEntities 备品实验集合
     */
    void add(List<SparePartsEntity> sparePartsEntities);

    /**
     * 批量删除
     *
     * @param ids id集合
     */
    void delete(Integer[] ids);

    /**
     * 按照条件查询 备品实验集合集
     *
     * @param ids           id集合
     * @param equipmentName 器材名称
     * @return
     */
    List<SparePartsEntity> findByCondition(Integer[] ids, String equipmentName);

    /**
     * 批量导入excel数据
     *
     * @param inputStream 输入流
     */
    void importFile(InputStream inputStream, String fileName) throws IOException;


    /**
     * 下载excel数据模板
     *
     * @param outputStream 输出流
     * @throws IOException io异常
     */
    void templateFile(OutputStream outputStream) throws IOException;

    /**
     * 批量导出excel数据
     *
     * @param outputStream 输出流
     * @param ids          配品实验id集
     * @throws IOException io异常
     */
    void exportFile(OutputStream outputStream, Integer[] ids) throws IOException;


}
