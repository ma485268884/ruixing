package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.entity.SolutionStatusEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author:mlf
 * @date:2020/6/22 16:01
 */
public interface SolutionStatusService extends BaseService<SolutionStatusEntity, Integer> {

    /**
     * 批量删除数据
     *
     * @param ids id集合
     */
    void removeMuch(Integer[] ids);

    /**
     * @param id       外键id
     * @param nameType 字段名类型
     * @param type     解决方案模块标识
     * @return 项目状态集合
     */
    List<SolutionStatusEntity> findByYearIdOrProjectIdOrFileTypeIdAndType(Integer id, Short nameType, Short type);

    /**
     * @param projectName 项目名称
     * @param type        解决方案模块标识
     * @return 项目状态集合
     */
    List<SolutionStatusEntity> findByProjectNameAndType(String projectName, Short type);

    /**
     * @param fileName 文件名
     * @param type     解决方案模块标识
     * @return
     */
    List<SolutionStatusEntity> findByFileNameAndType(String fileName, Short type);

    /**
     * @param ids  id集合
     * @param type 解决方案模块标识
     * @return
     */
    List<SolutionStatusEntity> findByIdsAndType(Integer[] ids, Short type);

    /**
     * 导出文件
     *
     * @param response
     * @param ids
     * @param type
     * @throws IOException
     */
    void exportFile(HttpServletResponse response, Integer[] ids, Short type) throws IOException;

}
