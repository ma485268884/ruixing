package com.yintu.ruixing.paigongguanli;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.yintu.ruixing.common.util.ResponseDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author Mr.liu
 * @Date 2020/8/14 15:17
 * @Version 1.0
 * 需求:派工管理 任务类型
 */
@RestController
@RequestMapping("/BusinessTypeAll")
public class PaiGongGuanLiBusinessTypeController {
    @Autowired
    private PaiGongGuanLiBusinessTypeService paiGongGuanLiBusinessTypeService;

    //新增业务类别
    @PostMapping("/addBusinessType")
    public Map<String,Object>addBusinessTypea(PaiGongGuanLiBusinessTypeEntity paiGongGuanLiBusinessTypeEntity){
        paiGongGuanLiBusinessTypeService.addBusinessTypea(paiGongGuanLiBusinessTypeEntity);
        return ResponseDataUtil.ok("新增业务类别成功");
    }

    //根据id 编辑对应的业务类别
    @PutMapping("/editBusinessTypeById/{id}")
    public Map<String,Object>editBusinessTypeaById(@PathVariable Integer id,PaiGongGuanLiBusinessTypeEntity paiGongGuanLiBusinessTypeEntity){
        paiGongGuanLiBusinessTypeService.editBusinessTypeaById(paiGongGuanLiBusinessTypeEntity);
        return ResponseDataUtil.ok("编辑业务类型成功");
    }

    //初始化页面  或者根据业务类别名进行模糊查询
    @GetMapping("/findSomeBusinessType")
    public Map<String,Object>findSomeBusinessTypea(Integer page, Integer size,String businessTypeaName){
        PageHelper.startPage(page,size);
        List<PaiGongGuanLiBusinessTypeEntity>businessTypeEntityList=paiGongGuanLiBusinessTypeService.findSomeBusinessTypea(page,size,businessTypeaName);
        PageInfo<PaiGongGuanLiBusinessTypeEntity>businessTypeEntityPageInfo=new PageInfo<>(businessTypeEntityList);
        return ResponseDataUtil.ok("查询业务类别成功",businessTypeEntityPageInfo);
    }

    //根据id  批量  或者单个删除业务类别
    @DeleteMapping("/deleteBusinessTypeByIds/{ids}")
    public Map<String,Object>deleteBusinessTypeByIds(@PathVariable Integer[] ids){
        for (int i = 0; i < ids.length; i++) {
            List<PaiGongGuanLiBusinessTypeEntity>chuChaRenWu= paiGongGuanLiBusinessTypeService.findChuChaRenWu(ids[i]);
            if (chuChaRenWu.size()==0){
                paiGongGuanLiBusinessTypeService.deleteBusinessTypeByIds(ids[i]);
            }else {
                return ResponseDataUtil.error("存在出差任务，不能删除");
            }
        }
        return ResponseDataUtil.ok("删除业务类别成功");
    }


    ///////////////////////////出差任务/////////////////////////////////////


    //根据id  查询出差任务  或者根据出差任务名进行模糊查询
    @GetMapping("/findSomeChuChaRenWu/{id}")
    public Map<String, Object> findSomeChuChaRenWu(@PathVariable Integer id, Integer page, Integer size, String businessTypeaName) {
        PageHelper.startPage(page, size);
        List<PaiGongGuanLiBusinessTypeEntity> businessTypeEntityList = paiGongGuanLiBusinessTypeService.findSomeChuChaRenWu(id, page, size, businessTypeaName);
        PageInfo<PaiGongGuanLiBusinessTypeEntity> businessTypeEntityPageInfo = new PageInfo<>(businessTypeEntityList);
        return ResponseDataUtil.ok("查询出差任务成功", businessTypeEntityPageInfo);
    }

    //新增出差任务
    @PostMapping("/addChuChaRenWu")
    public Map<String,Object>addChuChaRenWu(Integer id,PaiGongGuanLiBusinessTypeEntity paiGongGuanLiBusinessTypeEntity){
        paiGongGuanLiBusinessTypeService.addChuChaRenWu(id,paiGongGuanLiBusinessTypeEntity);
        return ResponseDataUtil.ok("新增出差任务成功");
    }

    //根据id  编辑对应的出差任务
    @PutMapping("/editChuChaRenWuById/{id}")
    public Map<String,Object>editChuChaRenWuById(@PathVariable Integer id,PaiGongGuanLiBusinessTypeEntity paiGongGuanLiBusinessTypeEntity){
        paiGongGuanLiBusinessTypeService.editChuChaRenWuById(paiGongGuanLiBusinessTypeEntity);
        return ResponseDataUtil.ok("编辑出差任务成功");
    }

    //根据id  批量删除  或者单个删除
    @DeleteMapping("/deleteChuChaRenWuByIds/{ids}")
    public Map<String,Object>deleteChuChaRenWuByIds(@PathVariable Integer[] ids){
        paiGongGuanLiBusinessTypeService.deleteChuChaRenWuByIds(ids);
        return ResponseDataUtil.ok("删除出差任务成功");
    }
}
