package com.yintu.ruixing.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.ColumnTitleMap;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.GuZhangStudyEntity;
import com.yintu.ruixing.service.GuZhangStudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author:lcy
 * @date:2020-06-04 16
 * 故障学习
 */
@RestController
@RequestMapping("/guzhangstudy")
public class GuZhangStudyController {
    @Autowired
    private GuZhangStudyService guZhangStudyService;

    //查询所有的数据并分页
    @GetMapping("/findGuZhangList")
    public Map<String, Object> findGuZhangList(@RequestParam Integer page, @RequestParam Integer size) {
        JSONObject js = new JSONObject();
        List<GuZhangStudyEntity> guZhangStudyEntity = guZhangStudyService.findGuZhangList(page, size);
        js.put("guZhangStudyEntity", guZhangStudyEntity);
        PageHelper.startPage(page, size);
        List<GuZhangStudyEntity> guZhangList = guZhangStudyService.findGuZhangList(page, size);
        PageInfo<GuZhangStudyEntity> pageInfo = new PageInfo<GuZhangStudyEntity>(guZhangList);
        js.put("pageInfo", pageInfo);
        return ResponseDataUtil.ok("查询所有信息成功", js);
    }

    //根据id查询对应的数据
    @GetMapping("/findGuZhangById/{id}")
    public Map<String, Object> findGuZhangById(@PathVariable Long id) {
        GuZhangStudyEntity guZhangStudyEntity = guZhangStudyService.findGuZhangById(id);
        return ResponseDataUtil.ok("查询本条信息成功", guZhangStudyEntity);
    }

    //添加数据
    @PostMapping("/addGuZhang")
    public Map<String, Object> addGuZhang(GuZhangStudyEntity guZhangStudyEntity) {
        guZhangStudyService.addGuZhang(guZhangStudyEntity);
        return ResponseDataUtil.ok("耶，添加成功");
    }

    //根据id修改数据
    @PutMapping("/editGuZhang/{id}")
    public Map<String, Object> editGuZhang(@PathVariable Long id) {
        guZhangStudyService.editGuZhang(id);
        return ResponseDataUtil.ok("修改数据成功");
    }

    //根据id删除对应的数据
    @DeleteMapping("/deletGuZhang/{id}")
    public Map<String, Object> deletGuZhang(@PathVariable Long id) {
        guZhangStudyService.deletGuZhang(id);
        return ResponseDataUtil.ok("删除数据成功");
    }

    //根据id数组 批量删除数据
    @DeleteMapping("/deletGuZhangList/{ids}")
    public Map<String,Object>deletGuZhangList(@PathVariable int[] ids){
        guZhangStudyService.deletGuZhangList(ids);
        return ResponseDataUtil.ok("批量删除数据成功");
    }


    /*@GetMapping(value = "/excel")
    public void getUserInfoEx(
            HttpServletResponse response,
            @RequestParam String date_start,
            @RequestParam String date_end
    ) {
        try {
            List<Map<String,Object>> userList = userInfoService.queryUserInfoResultListMap();
            ArrayList<String> titleKeyList= new ColumnTitleMap("userinfo").getTitleKeyList();
            Map<String, String> titleMap = new ColumnTitleMap("userinfo").getColumnTitleMap();
            exportDataService.exportDataToEx(response, titleKeyList, titleMap, userList);
        } catch (Exception e) {
            //
            System.out.println(e.toString());
        }
    }
*/

}
