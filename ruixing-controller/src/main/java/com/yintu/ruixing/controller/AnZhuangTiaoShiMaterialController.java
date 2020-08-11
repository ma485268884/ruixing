package com.yintu.ruixing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.AnZhuangTiaoShiMaterialEntity;
import com.yintu.ruixing.entity.AnZhuangTiaoShiMaterialOutInEntity;
import com.yintu.ruixing.service.AnZhuangTiaoShiMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author Mr.liu
 * @Date 2020/8/10 15:16
 * @Version 1.0
 * 需求:安装调试  库存管理
 */
@RestController
@RequestMapping("/MaterialAll")
public class AnZhuangTiaoShiMaterialController {
    @Autowired
    private AnZhuangTiaoShiMaterialService anZhuangTiaoShiMaterialService;

    //查询所有的库存物料  或者根据物料编码查询
    @GetMapping("findAllMaterial")
    public Map<String, Object> findAllMaterial(Integer page, Integer size,String materialName) {
        PageHelper.startPage(page, size);
        List<AnZhuangTiaoShiMaterialEntity> materialEntityList = anZhuangTiaoShiMaterialService.findAllMaterial(page, size,materialName);
        PageInfo<AnZhuangTiaoShiMaterialEntity> materialEntityPageInfo = new PageInfo<>(materialEntityList);
        return ResponseDataUtil.ok("查询所有的物料数据成功", materialEntityPageInfo);
    }

    //新增物料类别
    @PostMapping("/addMaterial")
    public Map<String, Object> addMaterial(AnZhuangTiaoShiMaterialEntity anZhuangTiaoShiMaterialEntity) {
        anZhuangTiaoShiMaterialService.addMaterial(anZhuangTiaoShiMaterialEntity);
        return ResponseDataUtil.ok("新增物料成功");
    }

    //根据物料类别id  编辑对应的物料
    @PutMapping("/editMaterialById/{id}")
    public Map<String, Object> editMaterialById(@PathVariable Integer id, AnZhuangTiaoShiMaterialEntity anZhuangTiaoShiMaterialEntity) {
        anZhuangTiaoShiMaterialService.editMaterialById(anZhuangTiaoShiMaterialEntity);
        return ResponseDataUtil.ok("编辑物料数据成功");
    }

    //初始化类别数据  或者根据物料编号模糊查询类别
    @GetMapping("/findAllMaterialDatas")
    public Map<String, Object> findAllMaterialDatas(Integer page, Integer size, String materialNumber) {
        PageHelper.startPage(page, size);
        List<AnZhuangTiaoShiMaterialEntity> materialEntityList = anZhuangTiaoShiMaterialService.findAllMaterialDatas(page, size, materialNumber);
        PageInfo<AnZhuangTiaoShiMaterialEntity> materialEntityPageInfo = new PageInfo<>(materialEntityList);
        return ResponseDataUtil.ok("查询物料数据成功", materialEntityPageInfo);
    }

    //根据id  单个或者批量删除库存物料
    @DeleteMapping("/deleteMaterialByIds/{ids}")
    public Map<String, Object> deleteMaterialByIds(@PathVariable Integer[] ids) {
        for (int i = 0; i < ids.length; i++) {
            Integer totalNumber = anZhuangTiaoShiMaterialService.totalNumber(ids[i]);
            if (totalNumber == 0) {
                anZhuangTiaoShiMaterialService.deleteMaterialByIds(ids[i]);
                return ResponseDataUtil.ok("删除成功");
            } else {
                return ResponseDataUtil.error("物料库存数量不为0,无法删除");
            }

        }
        return ResponseDataUtil.ok("ok");
    }


    //////////////////////////////物料出入库////////////////////////////////

    //物料出库 初始化  或者根据物料编码查询数据
    @GetMapping("/findAllOutMaterial")
    public Map<String, Object> findAllOutMaterial(Integer page, Integer size, String materialNumber) {
        PageHelper.startPage(page, size);
        List<AnZhuangTiaoShiMaterialOutInEntity> materialOutInEntityList = anZhuangTiaoShiMaterialService.findAllOutMaterial(page, size, materialNumber);
        PageInfo<AnZhuangTiaoShiMaterialOutInEntity> materialOutInEntityPageInfo = new PageInfo<>(materialOutInEntityList);
        return ResponseDataUtil.ok("查询物料出库数据成功", materialOutInEntityPageInfo);
    }

    //物料入库 初始化  或者根据物料编码查询数据
    @GetMapping("/findAllInMaterial")
    public Map<String,Object>findAllInMaterial(Integer page, Integer size, String materialNumber){
        PageHelper.startPage(page,size);
        List<AnZhuangTiaoShiMaterialOutInEntity> materialOutInEntityList = anZhuangTiaoShiMaterialService.findAllInMaterial(page, size, materialNumber);
        PageInfo<AnZhuangTiaoShiMaterialOutInEntity> materialOutInEntityPageInfo = new PageInfo<>(materialOutInEntityList);
        return ResponseDataUtil.ok("查询物料出库数据成功", materialOutInEntityPageInfo);
    }

    //查询所有的物料类别
    @GetMapping("/findAllMaterials")
    public Map<String,Object>findAllMaterials(){
        List<AnZhuangTiaoShiMaterialEntity>materialEntityList=anZhuangTiaoShiMaterialService.findAllMaterials();
        return ResponseDataUtil.ok("查询物料类别成功",materialEntityList);
    }
    //新增物料出库
    @PostMapping("/addOutMaterial")
    public Map<String, Object> addOutMaterial(AnZhuangTiaoShiMaterialOutInEntity anZhuangTiaoShiMaterialOutInEntity, AnZhuangTiaoShiMaterialEntity anZhuangTiaoShiMaterialEntity, Integer mid) {
        AnZhuangTiaoShiMaterialEntity materialEntityList = anZhuangTiaoShiMaterialService.fiandMaterial(mid);
        Integer totalnumber = materialEntityList.getTotalnumber();
        if (totalnumber > anZhuangTiaoShiMaterialOutInEntity.getMaterialsoutnumber()) {
            anZhuangTiaoShiMaterialService.addOutMaterial(anZhuangTiaoShiMaterialOutInEntity);
            Integer total = totalnumber - anZhuangTiaoShiMaterialOutInEntity.getMaterialsoutnumber();
            anZhuangTiaoShiMaterialEntity.setTotalnumber(total);
            anZhuangTiaoShiMaterialService.editMaterial(anZhuangTiaoShiMaterialEntity,mid);
            return ResponseDataUtil.ok("新增物料出库数据成功");
        } else {
            return ResponseDataUtil.error("库存物料小于出库数量,请正确确认出库数量");
        }
    }

    //新增物料入库
    @PostMapping("/addInMaterial")
    public Map<String,Object>addInMaterial(AnZhuangTiaoShiMaterialOutInEntity anZhuangTiaoShiMaterialOutInEntity,AnZhuangTiaoShiMaterialEntity anZhuangTiaoShiMaterialEntity, Integer mid){
        AnZhuangTiaoShiMaterialEntity materialEntityList = anZhuangTiaoShiMaterialService.fiandMaterial(mid);
        Integer totalnumber = materialEntityList.getTotalnumber();
        anZhuangTiaoShiMaterialService.addInMaterial(anZhuangTiaoShiMaterialOutInEntity);
        Integer total = totalnumber + anZhuangTiaoShiMaterialOutInEntity.getMaterialsinnumber();
        anZhuangTiaoShiMaterialEntity.setTotalnumber(total);
        anZhuangTiaoShiMaterialService.editMaterial(anZhuangTiaoShiMaterialEntity,mid);
        return ResponseDataUtil.ok("新增物料入库数据成功");
    }
}
