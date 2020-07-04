package com.yintu.ruixing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.exception.BaseRuntimeException;
import com.yintu.ruixing.common.util.BaseController;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.entity.BiddingFileEntity;
import com.yintu.ruixing.entity.DesignLiaisonEntity;
import com.yintu.ruixing.entity.DesignLiaisonFileEntity;
import com.yintu.ruixing.service.DesignLiaisonFileService;
import com.yintu.ruixing.service.DesignLiaisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/7/3 11:31
 */
@RestController
@RequestMapping("/design/liaisons")
public class DesignLiaisonController extends SessionController implements BaseController<DesignLiaisonEntity, Integer> {

    @Autowired
    private DesignLiaisonService designLiaisonService;

    @Autowired
    private DesignLiaisonFileService designLiaisonFileService;

    @PostMapping
    public Map<String, Object> add(@Validated DesignLiaisonEntity entity) {
        if (entity.getProjectDate() == null) {
            throw new BaseRuntimeException("项目日期不能为空");
        }
        designLiaisonService.add(entity);
        return ResponseDataUtil.ok("添加设计联络及后续技术交流信息成功");
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> remove(@PathVariable Integer id) {
        designLiaisonService.remove(id);
        return ResponseDataUtil.ok("删除设计联络及后续技术交流信息成功");

    }

    @PutMapping("/{id}")
    public Map<String, Object> edit(@PathVariable Integer id, @Validated DesignLiaisonEntity entity) {
        if (entity.getProjectDate() == null) {
            throw new BaseRuntimeException("项目日期不能为空");
        }
        designLiaisonService.edit(entity);
        return ResponseDataUtil.ok("修改设计联络及后续技术交流信息成功");
    }

    @GetMapping("/{id}")
    public Map<String, Object> findById(@PathVariable Integer id) {
        DesignLiaisonEntity designLiaisonEntity = designLiaisonService.findById(id);
        return ResponseDataUtil.ok("查询设计联络及后续技术交流信息成功", designLiaisonEntity);
    }

    @GetMapping
    public Map<String, Object> findTree() {
        List<TreeNodeUtil> treeNodeUtils = designLiaisonService.findByTree();
        return ResponseDataUtil.ok("查询设计联络及后续技术交流信息树成功", treeNodeUtils);
    }

    @GetMapping("/list")
    public Map<String, Object> findAll() {
        List<DesignLiaisonEntity> designLiaisonEntities = designLiaisonService.findAll();
        return ResponseDataUtil.ok("查询设计联络及后续技术交流信息列表成功", designLiaisonEntities);
    }

    @GetMapping("/search")
    public Map<String, Object> findBySearch(@RequestParam("page_number") Integer pageNumber,
                                            @RequestParam("page_size") Integer pageSize,
                                            @RequestParam(value = "order_by", required = false, defaultValue = "dlf.id DESC") String orderBy,
                                            @RequestParam(value = "year", required = false) Integer year,
                                            @RequestParam(value = "project_name", required = false) String projectName,
                                            @RequestParam(value = "type", required = false) String type) {
        PageHelper.startPage(pageNumber, pageSize, orderBy);
        List<DesignLiaisonFileEntity> designLiaisonEntities = designLiaisonFileService.findByYearAndProjectNameAndType(year, projectName, type);
        PageInfo<DesignLiaisonFileEntity> pageInfo = new PageInfo<>(designLiaisonEntities);
        return ResponseDataUtil.ok("查询设计联络及后续技术交流信息以及文件信息列表成功", pageInfo);
    }
}
