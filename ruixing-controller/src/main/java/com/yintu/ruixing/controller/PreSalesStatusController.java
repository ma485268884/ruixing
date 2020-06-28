package com.yintu.ruixing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.exception.BaseRuntimeException;
import com.yintu.ruixing.common.util.FileUploadUtil;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.SolutionStatusEntity;
import com.yintu.ruixing.service.SolutionStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/6/23 9:56
 */
@Controller
@RequestMapping("/presales/status")
public class PreSalesStatusController extends BaseController {
    @Autowired
    private SolutionStatusService solutionStatusService;
    private final Short FLAG = new Short("1");

    @PostMapping
    @ResponseBody
    public Map<String, Object> add(@RequestParam("file") MultipartFile multipartFile, SolutionStatusEntity solutionStatusEntity) throws IOException {
        Integer yearId = solutionStatusEntity.getYearId();
        Integer projectId = solutionStatusEntity.getProjectId();
        Integer fileTypeId = solutionStatusEntity.getFileTypeId();
        if (yearId == null)
            throw new BaseRuntimeException("年份id不能为空");
        if (projectId == null)
            throw new BaseRuntimeException("项目id不能为空");
        if (fileTypeId == null)
            throw new BaseRuntimeException("文件类型id不能为空");
        String fileName = multipartFile.getOriginalFilename();
        List<SolutionStatusEntity> solutionStatusEntities = solutionStatusService.findByFileNameAndType(fileName, FLAG);
        if (solutionStatusEntities.size() > 0)
            throw new BaseRuntimeException("文件名重复");
        String filePathName = FileUploadUtil.save(multipartFile.getInputStream(), fileName);
        solutionStatusEntity.setFileName(fileName);
        solutionStatusEntity.setFilePath(filePathName);
        solutionStatusEntity.setType(FLAG);
        solutionStatusService.add(solutionStatusEntity);
        return ResponseDataUtil.ok("添加售前技术支持状态成功");
    }


    @DeleteMapping("/{ids}")
    @ResponseBody
    public Map<String, Object> remove(@PathVariable Integer[] ids) {
        solutionStatusService.removeMuch(ids);
        return ResponseDataUtil.ok("删除售前技术支持状态成功");
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Map<String, Object> edit(@RequestParam("file") MultipartFile multipartFile, @PathVariable Integer id, SolutionStatusEntity solutionStatusEntity) throws IOException {
        Integer yearId = solutionStatusEntity.getYearId();
        Integer projectId = solutionStatusEntity.getProjectId();
        Integer file_type_id = solutionStatusEntity.getFileTypeId();
        if (yearId == null)
            throw new BaseRuntimeException("年份id不能为空");
        if (projectId == null)
            throw new BaseRuntimeException("项目id不能为空");
        if (file_type_id == null)
            throw new BaseRuntimeException("文件类型id不能为空");
        String fileName = multipartFile.getOriginalFilename();
        List<SolutionStatusEntity> solutionStatusEntities = solutionStatusService.findByFileNameAndType(fileName, FLAG);
        if (solutionStatusEntities.size() > 0 && !solutionStatusEntities.get(0).getId().equals(id))
            throw new BaseRuntimeException("文件名重复");
        SolutionStatusEntity s = solutionStatusService.findById(id);
        if (s != null)
            FileUploadUtil.delete(s.getFilePath() + "\\" + s.getFileName());
        String filePathName = FileUploadUtil.save(multipartFile.getInputStream(), fileName);
        solutionStatusEntity.setFileName(fileName);
        solutionStatusEntity.setFilePath(filePathName);
        solutionStatusEntity.setType(FLAG);
        solutionStatusService.edit(solutionStatusEntity);
        return ResponseDataUtil.ok("修改售前技术支持状态成功");
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Map<String, Object> findById(@PathVariable Integer id) {
        SolutionStatusEntity solutionStatusEntity = solutionStatusService.findById(id);
        return ResponseDataUtil.ok("查询售前技术支持状态成功", solutionStatusEntity);
    }


    @GetMapping
    @ResponseBody
    public Map<String, Object> findAll(@RequestParam("page_number") Integer pageNumber,
                                       @RequestParam("page_size") Integer pageSize,
                                       @RequestParam(value = "projectName", required = false) String projectName,
                                       @RequestParam(value = "sortby", required = false) String sortby,
                                       @RequestParam(value = "order", required = false) String order) {
        String orderBy = "ss.id DESC";
        if (sortby != null && !"".equals(sortby) && order != null && !"".equals(order))
            orderBy = sortby + " " + order;
        PageHelper.startPage(pageNumber, pageSize, orderBy);
        List<SolutionStatusEntity> solutionStatusEntities = solutionStatusService.findByProjectNameAndType(projectName, FLAG);
        PageInfo<SolutionStatusEntity> pageInfo = new PageInfo<>(solutionStatusEntities);
        return ResponseDataUtil.ok("查询售前技术支持状态列表成功", pageInfo);
    }

    @GetMapping("/downloads/{id}")
    public void downloadFile(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        SolutionStatusEntity solutionStatusEntity = solutionStatusService.findById(id);
        if (solutionStatusEntity != null) {
            String filePath = solutionStatusEntity.getFilePath();
            String fileName = solutionStatusEntity.getFileName();
            if (filePath != null && !"".equals(filePath) && fileName != null && !"".equals(fileName)) {
                response.setContentType("application/octet-stream;charset=ISO8859-1");
                response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1"));
                response.addHeader("Pargam", "no-cache");
                response.addHeader("Cache-Control", "no-cache");
                FileUploadUtil.get(response.getOutputStream(), filePath + "\\" + fileName);
            }
        }
    }

    @GetMapping("/export/{ids}")
    public void exportFile(@PathVariable Integer[] ids, HttpServletResponse response) throws IOException {
        solutionStatusService.exportFile(response, ids, FLAG);
    }
}
