package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.util.BaseController;
import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.PreSaleEntity;
import com.yintu.ruixing.service.PreSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author:mlf
 * @date:2020/6/30 19:12
 */
@RestController
@RequestMapping("/pre/sale")
public class PreSaleController extends SessionController implements BaseController<PreSaleEntity, Integer> {

    @Autowired
    private PreSaleService preSaleService;


    @PostMapping
    public Map<String, Object> add(PreSaleEntity entity) {
        preSaleService.add(entity);
        return ResponseDataUtil.ok("添加售前技术支持信息成功");
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> remove(@PathVariable Integer id) {
        preSaleService.remove(id);
        return ResponseDataUtil.ok("删除售前技术支持信息成功");
    }

    @PutMapping("/{id}")
    public Map<String, Object> edit(@PathVariable Integer id, PreSaleEntity entity) {
        preSaleService.edit(entity);
        return ResponseDataUtil.ok("修改售前技术支持信息成功");
    }

    @GetMapping("/{id}")
    public Map<String, Object> findById(@PathVariable Integer id) {
        PreSaleEntity preSaleEntity = preSaleService.findById(id);
        return ResponseDataUtil.ok("查询售前技术支持信息成功", preSaleEntity);
    }

}
