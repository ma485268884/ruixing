package com.yintu.ruixing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.BaseController;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.CustomerDutyEntity;
import com.yintu.ruixing.service.CustomerDutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 顾客职务
 *
 * @author:mlf
 * @date:2020/8/10 14:38
 */
@RestController
@RequestMapping("/customer/duty")
public class CustomerDutyController extends SessionController implements BaseController<CustomerDutyEntity, Integer> {
    @Autowired
    private CustomerDutyService customerDutyService;

    @PostMapping
    public Map<String, Object> add(@Validated CustomerDutyEntity entity) {
        entity.setCreateBy(this.getLoginUserName());
        entity.setModifiedBy(this.getLoginUserName());
        customerDutyService.add(entity);
        return ResponseDataUtil.ok("添加职务信息成功");
    }

    @Override
    public Map<String, Object> remove(Integer id) {
        return null;
    }

    @DeleteMapping("/{ids}")
    public Map<String, Object> remove(@PathVariable Integer[] ids) {
        customerDutyService.removeByIds(ids);
        return ResponseDataUtil.ok("删除职务信息成功");
    }

    @PutMapping("/{id}")
    public Map<String, Object> edit(@PathVariable Integer id, @Validated CustomerDutyEntity entity) {
        entity.setModifiedBy(this.getLoginUserName());
        customerDutyService.edit(entity);
        return ResponseDataUtil.ok("修改职务信息成功");
    }

    @GetMapping("/{id}")
    public Map<String, Object> findById(@PathVariable Integer id) {
        CustomerDutyEntity customerDutyEntity = customerDutyService.findById(id);
        return ResponseDataUtil.ok("修改职务信息成功", customerDutyEntity);
    }

    @GetMapping
    public Map<String, Object> findAll(@RequestParam("page_number") Integer pageNumber,
                                       @RequestParam("page_size") Integer pageSize,
                                       @RequestParam(value = "order_by", required = false, defaultValue = "id DESC") String orderBy,
                                       @RequestParam(value = "name", required = false) String name) {
        PageHelper.startPage(pageNumber, pageSize, orderBy);
        List<CustomerDutyEntity> customerDutyEntities = customerDutyService.findByExample(new CustomerDutyEntity(null, null, null, null, null, name));
        PageInfo<CustomerDutyEntity> pageInfo = new PageInfo<>(customerDutyEntities);
        return ResponseDataUtil.ok("查询职务列表信息成功", pageInfo);
    }

}
