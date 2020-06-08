package com.yintu.ruixing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.QuDuanDownloadEntity;
import com.yintu.ruixing.service.QuDuanDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/6/8 15:36
 */
@RestController
@RequestMapping("/downloads")
public class QuDuanDownloadController extends BaseController {
    @Autowired
    private QuDuanDownloadService quDuanDownloadService;

    @PostMapping
    public Map<String, Object> add(@RequestParam("xid") Integer xid,
                                   @RequestParam("cid") Integer cid,
                                   @RequestParam("date") Date date,
                                   @RequestParam("minute") Integer minute) {
        quDuanDownloadService.add(xid, cid, date, minute);
        return ResponseDataUtil.ok("添加下载记录成功");
    }


    @DeleteMapping("/{id}")
    public Map<String, Object> remove(@PathVariable Integer id) {
        quDuanDownloadService.remove(id);
        return ResponseDataUtil.ok("删除下载记录成功");

    }

    @GetMapping
    public Map<String, Object> findAll(@RequestParam("pageNumber") Integer pageNumber,
                                       @RequestParam("pageSize") Integer pageSize,
                                       @RequestParam(value = "sortby", required = false) String sortby,
                                       @RequestParam(value = "order", required = false) String order,
                                       @RequestParam("startDateTime") Date startDateTime,
                                       @RequestParam("endDateTime") Date endDateTime) {
        String orderBy = "id DESC";
        if (sortby != null && !"".equals(sortby) && order != null && !"".equals(order))
            orderBy = sortby + " " + order;
        PageHelper.startPage(pageNumber, pageSize, orderBy);
        List<QuDuanDownloadEntity> quDuanDownloadEntities = quDuanDownloadService.findByDateTime(startDateTime, endDateTime);
        PageInfo<QuDuanDownloadEntity> pageInfo = new PageInfo<>(quDuanDownloadEntities);
        return ResponseDataUtil.ok("查询下载记录成功", pageInfo);
    }


}
