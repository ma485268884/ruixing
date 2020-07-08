package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.*;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author:lcy
 * @date:2020-06-04 16
 */
public interface GuZhangStudyService {
    List<GuZhangStudyEntity> findGuZhangList(Integer page, Integer size);

    GuZhangStudyEntity findGuZhangById(Long id);

    void addGuZhang(GuZhangStudyEntity guZhangStudyEntity);

    void editGuZhang(GuZhangStudyEntity guZhangStudyEntity);

    void deletGuZhang(Long id);

    void deletGuZhangList(int[] ids);

    List<GuZhangStudyEntity> GuZhangListExcelDownloads(Long[] ids);

    List<GuZhangStudyEntity> GuZhangListExcelDownloadsById(Long id);

    List<XianDuanEntity> getXianDuan(XianDuanEntity xianDuanEntity);

    List<CheZhanEntity> getCheZhanByXid(Long xid);

    List<QuDuanBaseEntity> getQuDuanByCid(Long cid);





    List<QuDuanInfoEntity> findGuZhangKuData(Integer id,Integer page,Integer size);

    List<QuDuanBaseEntity> findFristId(Integer id);

    List<QuDuanBaseEntity> findLastId(Integer id);


    void exportFile(ServletOutputStream outputStream, Integer[] ids)throws IOException;
}
