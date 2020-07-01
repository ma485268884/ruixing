package com.yintu.ruixing.controller;

import com.github.pagehelper.PageHelper;
import com.yintu.ruixing.common.util.BaseController;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.entity.PreSaleEntity;
import com.yintu.ruixing.entity.PreSaleFileEntity;
import com.yintu.ruixing.service.PreSaleFileService;
import com.yintu.ruixing.service.PreSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/6/30 19:12
 */
@RestController
@RequestMapping("/pre/sales")
public class PreSaleController extends SessionController implements BaseController<PreSaleEntity, Integer> {

    @Autowired
    private PreSaleService preSaleService;
    @Autowired
    private PreSaleFileService preSaleFileService;


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

    @GetMapping
    public Map<String, Object> findTree() {
        List<TreeNodeUtil> treeNodeUtils = preSaleService.findByTree();
        return ResponseDataUtil.ok("查询售前技术支持信息树成功", treeNodeUtils);
    }

    @GetMapping("/list")
    public Map<String, Object> findByAll() {
        List<PreSaleEntity> preSaleEntities = preSaleService.findAll();
        return ResponseDataUtil.ok("查询售前技术支持信息树成功", preSaleEntities);
    }

    @GetMapping("/search")
    public Map<String, Object> search(@RequestParam("page_number") Integer pageNumber,
                                      @RequestParam("page_size") Integer pageSize,
                                      @RequestParam(value = "order_by", required = false, defaultValue = "psf.id DESC") String orderBy,
                                      @RequestParam(value = "year", required = false) Integer year,
                                      @RequestParam(value = "project_name", required = false) String projectName,
                                      @RequestParam(value = "type", required = false) String type) {
        PageHelper.startPage(pageNumber, pageSize, orderBy);
        List<PreSaleFileEntity> preSaleFileEntities = preSaleFileService.findByYearAndProjectNameAndType(year, projectName, type);
        return ResponseDataUtil.ok("查询售前技术支持文件信息成功", preSaleFileEntities);
    }


}
