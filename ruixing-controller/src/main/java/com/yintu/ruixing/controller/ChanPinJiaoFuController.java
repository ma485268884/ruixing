package com.yintu.ruixing.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.entity.ChanPinJiaoFuEntity;
import com.yintu.ruixing.entity.ChanPinJiaoFuPropertyEntity;
import com.yintu.ruixing.service.ChanPinJiaoFuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author Mr.liu
 * @Date 2020/6/23 16:16
 * @Version 1.0
 * 产品交付模块
 */
@RestController
@RequestMapping("/chanPinJiaoFuAll")
public class ChanPinJiaoFuController {
    @Autowired
    private ChanPinJiaoFuService chanPinJiaoFuService;

    //查询树形结构
    @GetMapping
    public Map<String, Object> findChanPinJiaoFuShuXing() {
        List<TreeNodeUtil> treeNodeUtils = chanPinJiaoFuService.findChanPinJiaoFuShuXing(-1);
        return ResponseDataUtil.ok("查询产品交付树结构成功", treeNodeUtils);
    }

    //当表中没有数据时  添加第一条数据
    @PostMapping("/addDataShu")
    public Map<String, Object> addDataShu(ChanPinJiaoFuPropertyEntity chanPinJiaoFuPropertyEntity) {
        Integer parendid = chanPinJiaoFuService.findAllDataShu();
        if (parendid == null) {
            chanPinJiaoFuService.addfristData(chanPinJiaoFuPropertyEntity);
            return ResponseDataUtil.ok("添加第一条数据成功");
        } else {
            chanPinJiaoFuService.addDataShu(chanPinJiaoFuPropertyEntity);
            return ResponseDataUtil.ok("添加数据成功");
        }
    }

    //根据选择id编辑树形结构数据
    @PutMapping("/editDataShuById/{id}")
    public Map<String, Object> editDataShuById(@PathVariable Integer id, ChanPinJiaoFuPropertyEntity chanPinJiaoFuPropertyEntity) {
        chanPinJiaoFuService.editDataShuById(chanPinJiaoFuPropertyEntity);
        return ResponseDataUtil.ok("修改数据成功");
    }

    //根据id删除树形结构数据
    @DeleteMapping("/deleteDataShuById/{id}")
    public Map<String, Object> deleteDataShuById(@PathVariable Integer id) {
        List<Integer> ids = chanPinJiaoFuService.findParedId(id);
        if (ids.size() == 0) {
            chanPinJiaoFuService.deleteDataShuById(id);
            return ResponseDataUtil.ok("删除数据成功");
        }
        return ResponseDataUtil.error("不能直接删除父级数据");
    }


    //查询所有的项目状态
    @GetMapping("/findAllXiangMuState")
    public Map<String, Object> findAllXiangMuState(Integer page, Integer size) {
        JSONObject js = new JSONObject();
        PageHelper.startPage(page, size);
        List<ChanPinJiaoFuEntity> chanPinJiaoFuEntities = chanPinJiaoFuService.findAllXiangMuState(page, size);
        js.put("chanPinJiaoFuEntities", chanPinJiaoFuEntities);
        PageInfo<ChanPinJiaoFuEntity> pinJiaoFuEntityPageInfo = new PageInfo<>(chanPinJiaoFuEntities);
        js.put("pinJiaoFuEntityPageInfo", pinJiaoFuEntityPageInfo);
        return ResponseDataUtil.ok("查询所有的项目成功", js);
    }


    //根据项目编号和项目名称查询数据
    @GetMapping("/findXiangMuData")
    public Map<String, Object> findXiangMuData(String bianhao, String name, Integer page, Integer size) {
        JSONObject js = new JSONObject();
        PageHelper.startPage(page, size);
        List<ChanPinJiaoFuEntity> chanPinJiaoFuEntities = chanPinJiaoFuService.findXiangMuData(bianhao, name, page, size);
        js.put("chanPinJiaoFuEntities", chanPinJiaoFuEntities);
        PageInfo<ChanPinJiaoFuEntity> pageInfo = new PageInfo<>(chanPinJiaoFuEntities);
        js.put("pageInfo", pageInfo);
        return ResponseDataUtil.ok("查询数据成功", js);
    }

   /* //根据树形结构的id  查询对应的数据
    @GetMapping("/findXiangMuDataById/{id}")
    public Map<String,Object>findXiangMuDataById(@PathVariable Integer id){
        List<ChanPinJiaoFuEntity> chanPinJiaoFuEntities = chanPinJiaoFuService.findXiangMuDataById(id);
        return ResponseDataUtil.ok("查询数据成功",chanPinJiaoFuEntities);
    }*/


    //根据树形结构的id  查询对应的所有数据
    @GetMapping("/findXiangMuDataById/{id}")
    public Map<String, Object> findXiangMuDataById(@PathVariable Integer id) {
        List<ChanPinJiaoFuEntity> chanPinJiaoFuEntitiesss = null;
        Map<String, Object> map = null;
        List<Integer> ids = chanPinJiaoFuService.findIdS(id);
        if (ids.size() > 0) {
            for (Integer idd : ids) {
                List<ChanPinJiaoFuEntity> chanPinJiaoFuEntities = chanPinJiaoFuService.findXiangMuDataById(idd);
                for (ChanPinJiaoFuEntity chanPinJiaoFuEntity : chanPinJiaoFuEntities) {
                    if (chanPinJiaoFuEntity.getShuId() != null) {
                        List<Integer> idds = chanPinJiaoFuService.findIdS(chanPinJiaoFuEntity.getId());
                        if (idds.size() > 0) {
                            for (Integer integer : idds) {
                                List<ChanPinJiaoFuEntity> chanPinJiaoFuEntitiess = chanPinJiaoFuService.findXiangMuDataById(integer);
                            }
                        }
                    } else {
                        List<ChanPinJiaoFuEntity> chanPinJiaoFuEntitiess = chanPinJiaoFuService.findXiangMuDataById(idd);
                        return ResponseDataUtil.ok("dadsd8888", chanPinJiaoFuEntitiess);
                    }
                }
            }
        } else {
            List<ChanPinJiaoFuEntity> chanPinJiaoFuEntitiess = chanPinJiaoFuService.findXiangMuDataById(id);
            return ResponseDataUtil.ok("dadsd9894", chanPinJiaoFuEntitiess);
        }
        return ResponseDataUtil.ok("dadsd", null);
    }
}
