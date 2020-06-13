package com.yintu.ruixing.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.MenXianEntity;
import com.yintu.ruixing.entity.UserEntity;
import com.yintu.ruixing.service.MenXianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/6/12 11:56
 */
@RestController
@RequestMapping("/menxians")
public class MenXianController extends BaseController {
    @Autowired
    private MenXianService menXianService;


    @PostMapping
    public Map<String, Object> add(MenXianEntity menXianEntity) {
        Assert.notNull(menXianEntity.getQuduanId(), "区段id不能为空");
        Assert.notNull(menXianEntity.getPropertyId(), "属性id不能为空");
        menXianService.add(menXianEntity);
        return ResponseDataUtil.ok("添加门限参数信息成功");
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> remove(@PathVariable Integer id) {
        menXianService.remove(id);
        return ResponseDataUtil.ok("删除门限参数信息成功");
    }

    @PutMapping("/{id}")
    public Map<String, Object> edit(@PathVariable Integer id, MenXianEntity menXianEntity) {
        Assert.notNull(menXianEntity.getQuduanId(), "区段id不能为空");
        Assert.notNull(menXianEntity.getPropertyId(), "属性id不能为空");
        menXianService.edit(menXianEntity);
        return ResponseDataUtil.ok("修改门限参数信息成功");
    }

    @GetMapping("/{id}")
    public Map<String, Object> findById(@PathVariable Integer id) {
        MenXianEntity menXianEntity = menXianService.findById(id);
        return ResponseDataUtil.ok("查询门限参数信息成功", menXianEntity);
    }

    @GetMapping
    public Map<String, Object> findAll(@RequestParam("page_number") Integer pageNumber,
                                       @RequestParam("page_size") Integer pageSize,
                                       @RequestParam(value = "sortby", required = false) String sortby,
                                       @RequestParam(value = "order", required = false) String order,
                                       @RequestParam Integer[] propertyIds) {
        String orderBy = "id DESC";
        if (sortby != null && !"".equals(sortby) && order != null && !"".equals(order))
            orderBy = sortby + " " + order;
        PageHelper.startPage(pageNumber, pageSize, orderBy);
        List<MenXianEntity> menXianEntities = menXianService.findByPropertyIds(propertyIds);
        PageInfo<MenXianEntity> pageInfo = new PageInfo<>(menXianEntities);
        return ResponseDataUtil.ok("查询门限参数列表成功", pageInfo);
    }
}
