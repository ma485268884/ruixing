package com.yintu.ruixing.anzhuangtiaoshi;

import com.yintu.ruixing.anzhuangtiaoshi.AnZhuangTiaoShiWenTiEntity;
import com.yintu.ruixing.anzhuangtiaoshi.AnZhuangTiaoShiWenTiFileEntity;
import com.yintu.ruixing.anzhuangtiaoshi.AnZhuangTiaoShiWorksFileEntity;
import com.yintu.ruixing.xitongguanli.DepartmentEntity;
import com.yintu.ruixing.xitongguanli.DepartmentEntityExample;

import java.util.List;

/**
 * @Author Mr.liu
 * @Date 2020/8/9 10:30
 * @Version 1.0
 * 需求:安装调试 问题跟踪
 */
public interface AnZhuangTiaoShiWenTiService {
    void addWenTi(AnZhuangTiaoShiWenTiEntity anZhuangTiaoShiWenTiEntity);

    void editWenTiById(AnZhuangTiaoShiWenTiEntity anZhuangTiaoShiWenTiEntity);

    List<AnZhuangTiaoShiWenTiEntity> findSomeWenTi(Integer page, Integer size, String xdname, String wenTiMiaoShu);

    void deleteWenTiByIds(Integer[] ids);

    List<AnZhuangTiaoShiWenTiFileEntity> findAllFanKuiFileById(Integer wid, Integer page, Integer size, String fileName);

    List<AnZhuangTiaoShiWenTiFileEntity> findAllShuChuFileById(Integer wid, Integer page, Integer size,String fileName);

    void addFanKuiFile(AnZhuangTiaoShiWenTiFileEntity anZhuangTiaoShiWenTiFileEntity);

    void addShuRuFile(AnZhuangTiaoShiWenTiFileEntity anZhuangTiaoShiWenTiFileEntity);

    AnZhuangTiaoShiWenTiFileEntity findById(Integer id);

    void deleteFileByIds(Integer[] ids);

    List<DepartmentEntity> findAllDepartment(DepartmentEntityExample departmentEntityExample);

    List<AnZhuangTiaoShiWorksFileEntity> findFileById(Integer id);

    List<AnZhuangTiaoShiWenTiEntity> findAllNotDoWellWenTi(Integer page, Integer size);

}
