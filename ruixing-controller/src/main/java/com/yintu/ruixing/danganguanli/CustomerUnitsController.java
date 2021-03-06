package com.yintu.ruixing.danganguanli;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.BaseController;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.common.SessionController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 顾客单位
 *
 * @author:mlf
 * @date:2020/8/8 21:02
 */
@RestController
@RequestMapping("/customer/units")
public class CustomerUnitsController extends SessionController implements BaseController<CustomerUnitsEntity, Long> {
    @Autowired
    private CustomerUnitsService customerUnitsService;

    @PostMapping
    public Map<String, Object> add(@Validated CustomerUnitsEntity entity) {
        entity.setCreateBy(this.getLoginUserName());
        entity.setModifiedBy(this.getLoginUserName());
        customerUnitsService.add(entity);
        return ResponseDataUtil.ok("添加顾客单位信息成功");
    }

    @Override
    public Map<String, Object> remove(Long id) {
        return null;
    }

    @DeleteMapping("/{ids}")
    public Map<String, Object> remove(@PathVariable Long[] ids) {
        customerUnitsService.removeByIds(ids);
        return ResponseDataUtil.ok("删除顾客单位信息成功");
    }

    @PutMapping("/{id}")
    public Map<String, Object> edit(@PathVariable Long id, @Validated CustomerUnitsEntity entity) {
        entity.setModifiedBy(this.getLoginUserName());
        customerUnitsService.edit(entity);
        return ResponseDataUtil.ok("修改顾客单位信息成功");
    }

    @GetMapping("/{id}")
    public Map<String, Object> findById(@PathVariable Long id) {
        CustomerUnitsEntity customerUnitsEntity = customerUnitsService.findById(id);
        return ResponseDataUtil.ok("查询顾客单位信息成功", customerUnitsEntity);
    }

    @GetMapping
    public Map<String, Object> findAll(@RequestParam("page_number") Integer pageNumber,
                                       @RequestParam("page_size") Integer pageSize,
                                       @RequestParam(value = "order_by", required = false, defaultValue = "id DESC") String orderBy,
                                       @RequestParam(value = "name", required = false) String name) {
        PageHelper.startPage(pageNumber, pageSize, orderBy);
        List<CustomerUnitsEntity> customerUnitsEntities = customerUnitsService.findByExample(new CustomerUnitsEntity(null, null, null, null, null, null, name));
        PageInfo<CustomerUnitsEntity> pageInfo = new PageInfo<>(customerUnitsEntities);
        return ResponseDataUtil.ok("查询顾客单位列表信息成功", pageInfo);
    }

}
