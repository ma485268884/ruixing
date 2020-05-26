package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.DianWuDuanEntity;
import com.yintu.ruixing.service.DianWuDuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author:lcy
 * @date:2020-05-26 11
 * 电务段相关
 */
@RestController
@RequestMapping("/dianwuduanAll")
public class DianWuDuanController {
    @Autowired
    private DianWuDuanService dianWuDuanService;
    //查询电务段
    @GetMapping("/findDianWuDuanById/{id}")
    public Map<String,Object>findDianWuDuanById(@PathVariable Long id){
        DianWuDuanEntity dianWuDuanEntity=dianWuDuanService.findDianWuDuanById(id);
        return ResponseDataUtil.ok("查询电务段成功",dianWuDuanEntity);
    }

    //新增电务段
    @PostMapping("/addDianWuDuan")
    public Map<String,Object> addDianWuDuan(DianWuDuanEntity dianWuDuanEntity){
        dianWuDuanService.addDianWuDuan(dianWuDuanEntity);

        return ResponseDataUtil.ok("新增电务段成功");
    }

    //修改电务段
    @PutMapping("/editDianWuDuan/{id}")
    public Map<String,Object>editDianWuDuan(Long id, DianWuDuanEntity dianWuDuanEntity){
        dianWuDuanService.editDianWuDuan(dianWuDuanEntity);
        return ResponseDataUtil.ok("修改电务段信息成功");
    }
    //删除电务段
    @DeleteMapping("/delDianWuDuan/{id}")
    public Map<String,Object>delDianWuDuan(@PathVariable Long id){
        dianWuDuanService.delDianWuDuan(id);
        return ResponseDataUtil.ok("删除电务段成功");
    }

}
