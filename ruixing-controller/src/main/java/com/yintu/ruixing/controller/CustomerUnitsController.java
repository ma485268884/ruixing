package com.yintu.ruixing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.BaseController;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.CustomerUnitsEntity;
import com.yintu.ruixing.service.CustomerUnitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author:mlf 顾客单位
 * @date:2020/8/8 21:02
 */
@RestController
@RequestMapping("/customer/units")
public class CustomerUnitsController extends SessionController implements BaseController<CustomerUnitsEntity, Integer> {
    @Autowired
    private CustomerUnitsService customerUnitsService;

    @PostMapping
    public Map<String, Object> add(@Validated CustomerUnitsEntity entity) {
        customerUnitsService.add(entity);
        return ResponseDataUtil.ok("添加顾客单位信息成功");
    }

    @Override
    public Map<String, Object> remove(Integer id) {
        return null;
    }

    @DeleteMapping("/{ids}")
    public Map<String, Object> remove(@PathVariable Integer[] ids) {
        customerUnitsService.removeByIds(ids);
        return ResponseDataUtil.ok("删除顾客单位信息成功");
    }

    @PutMapping("/{id}")
    public Map<String, Object> edit(@PathVariable Integer id, CustomerUnitsEntity entity) {
        customerUnitsService.edit(entity);
        return ResponseDataUtil.ok("修改顾客单位信息成功");
    }

    @GetMapping("/{id}")
    public Map<String, Object> findById(@PathVariable Integer id) {
        CustomerUnitsEntity customerUnitsEntity = customerUnitsService.findById(id);
        return ResponseDataUtil.ok("查询顾客单位信息成功", customerUnitsEntity);
    }

    @GetMapping
    public Map<String, Object> findAll(@RequestParam("page_number") Integer pageNumber,
                                       @RequestParam("page_size") Integer pageSize,
                                       @RequestParam(value = "order_by", required = false, defaultValue = "id DESC") String orderBy,
                                       @RequestParam(value = "name", required = false) String name) {
        PageHelper.startPage(pageNumber, pageSize, orderBy);
        List<CustomerUnitsEntity> customerUnitsEntities = customerUnitsService.findAll(new CustomerUnitsEntity(null, null, name, null));
        PageInfo<CustomerUnitsEntity> pageInfo = new PageInfo<>(customerUnitsEntities);
        return ResponseDataUtil.ok("查询顾客单位信息列表成功", pageInfo);
    }

}
