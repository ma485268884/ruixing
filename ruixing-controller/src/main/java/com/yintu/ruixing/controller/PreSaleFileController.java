package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.util.BaseController;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.PreSaleFileEntity;
import com.yintu.ruixing.service.PreSaleFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author:mlf
 * @date:2020/7/1 10:55
 */

@Controller
@RequestMapping("/pre/sales/files")
public class PreSaleFileController extends SessionController implements BaseController<PreSaleFileEntity, Integer> {

    @Autowired
    private PreSaleFileService preSaleFileService;

    @PostMapping
    @ResponseBody
    public Map<String, Object> add(PreSaleFileEntity entity) {
        preSaleFileService.add(entity);
        return ResponseDataUtil.ok("添加售前技术支持文件信息成功");
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Map<String, Object> remove(@PathVariable Integer id) {
        return null;
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Map<String, Object> edit(Integer id, PreSaleFileEntity entity) {
        return null;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Map<String, Object> findById(Integer id) {
        return null;
    }
}
