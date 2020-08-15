package com.yintu.ruixing.jiejuefangan;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.jiejuefangan.DesignLiaisonFileEntity;
import com.yintu.ruixing.xitongguanli.UserEntity;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author:mlf
 * @date:2020/7/3 11:08
 */
public interface DesignLiaisonFileService extends BaseService<DesignLiaisonFileEntity, Integer> {

    /**
     * @param designLiaisonFileEntity 设计联络文件实体类
     * @param auditorIds              审核人ids
     */
    void add(DesignLiaisonFileEntity designLiaisonFileEntity, Integer[] auditorIds);

    /**
     * @param designLiaisonFileEntity 设计联络文件实体类
     * @param auditorIds              审核人ids
     */
    void edit(DesignLiaisonFileEntity designLiaisonFileEntity, Integer[] auditorIds);

    /**
     * 批量删除
     *
     * @param ids id集合
     */
    void remove(Integer[] ids);

    /**
     * @param id 设计联络id
     * @return 设计联络文件
     */
    DesignLiaisonFileEntity findDesignLiaisonById(Integer id);

    /**
     * @param year        年份
     * @param projectName 项目名称
     * @param type        文件类型
     * @return
     */
    List<DesignLiaisonFileEntity> findByYearAndProjectNameAndType(Integer year, String projectName, String type);

    /**
     * @param outputStream 输出流
     * @param ids          id 集合
     * @throws IOException io异常
     */
    void exportFile(OutputStream outputStream, Integer[] ids) throws IOException;

    /**
     * 查询审核人
     *
     * @return 审核人列表
     */
    List<UserEntity> findUserEntitiesBytTruename(String truename);
}
