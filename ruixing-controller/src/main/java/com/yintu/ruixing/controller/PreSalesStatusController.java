package com.yintu.ruixing.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.exception.BaseRuntimeException;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.SolutionStatusEntity;
import com.yintu.ruixing.entity.UserEntity;
import com.yintu.ruixing.service.SolutionStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/6/23 9:56
 */
@RestController
@RequestMapping("/presales/status")
public class PreSalesStatusController extends BaseController {
    @Autowired
    private SolutionStatusService solutionStatusService;

    @PostMapping
    public Map<String, Object> add(@RequestParam("file") MultipartFile multipartFile, SolutionStatusEntity solutionStatusEntity) {

        Integer yearId = solutionStatusEntity.getYearId();
        Integer projectId = solutionStatusEntity.getProjectId();
        Integer fileTypeId = solutionStatusEntity.getFileTypeId();
        if (yearId == null)
            throw new BaseRuntimeException("年份id不能为空");
        if (projectId == null)
            throw new BaseRuntimeException("项目id不能为空");
        if (fileTypeId == null)
            throw new BaseRuntimeException("文件类型id不能为空");
        solutionStatusEntity.setType((short) 1);
        solutionStatusService.add(solutionStatusEntity);
        return ResponseDataUtil.ok("添加售前技术支持状态成功");
    }

    @DeleteMapping
    public Map<String, Object> removeMuch(Integer[] ids) {
        solutionStatusService.removeMuch(ids);
        return ResponseDataUtil.ok("删除售前技术支持状态成功");
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> remove(@PathVariable Integer id) {
        solutionStatusService.remove(id);
        return ResponseDataUtil.ok("删除售前技术支持状态成功");
    }

    @PutMapping("/{id}")
    public Map<String, Object> edit(SolutionStatusEntity solutionStatusEntity) {
        Integer yearId = solutionStatusEntity.getYearId();
        Integer projectId = solutionStatusEntity.getProjectId();
        Integer file_type_id = solutionStatusEntity.getFileTypeId();
        if (yearId == null)
            throw new BaseRuntimeException("年份id不能为空");
        if (projectId == null)
            throw new BaseRuntimeException("项目id不能为空");
        if (file_type_id == null)
            throw new BaseRuntimeException("文件类型id不能为空");
        solutionStatusEntity.setType((short) 1);
        solutionStatusService.add(solutionStatusEntity);
        return ResponseDataUtil.ok("修改售前技术支持状态成功");
    }

    @GetMapping("/{id}")
    public Map<String, Object> findById(@PathVariable Integer id) {
        SolutionStatusEntity solutionStatusEntity = solutionStatusService.findById(id);
        return ResponseDataUtil.ok("查询售前技术支持状态成功", solutionStatusEntity);
    }

    @GetMapping
    public Map<String, Object> findAll(@RequestParam("page_number") Integer pageNumber,
                                       @RequestParam("page_size") Integer pageSize,
                                       @RequestParam(value = "projectName", required = false) String projectName,
                                       @RequestParam(value = "sortby", required = false) String sortby,
                                       @RequestParam(value = "order", required = false) String order) {
        JSONObject jo = new JSONObject();
        String orderBy = "ss.id DESC";
        if (sortby != null && !"".equals(sortby) && order != null && !"".equals(order))
            orderBy = sortby + " " + order;
        PageHelper.startPage(pageNumber, pageSize, orderBy);
        List<SolutionStatusEntity> solutionStatusEntities = solutionStatusService.findByProjectNameAndType(projectName, (short) 1);
        PageInfo<SolutionStatusEntity> pageInfo = new PageInfo<>(solutionStatusEntities);
        return ResponseDataUtil.ok("查询售前技术支持状态列表成功", pageInfo);
    }


}
