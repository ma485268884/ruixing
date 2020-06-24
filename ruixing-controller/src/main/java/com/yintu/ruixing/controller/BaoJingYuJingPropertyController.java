package com.yintu.ruixing.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.entity.BaoJingYuJingEntity;
import com.yintu.ruixing.entity.QuDuanBaseEntity;
import com.yintu.ruixing.service.BaoJingYuJingPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author:lcy
 * @date:2020-06-17 10
 */
@RestController
@RequestMapping("/BaoJingYuJing")
public class BaoJingYuJingPropertyController {
    @Autowired
    private BaoJingYuJingPropertyService baoJingYuJingPropertyService;

    //查询报警预警树形结构
    @RequestMapping
    public Map<String,Object>findBaoJingYuJingTree(){
        List<TreeNodeUtil> treeNodeUtils=baoJingYuJingPropertyService.findBaoJingYuJingTree(-1);
        return ResponseDataUtil.ok("查询报警预警树结构成功",treeNodeUtils);
    }

    //查询所有的预警报警信息
    @GetMapping("/findAllYuJingBaoJing")
    public Map<String,Object>findAllYuJingBaoJing(@RequestParam(value = "page", required = false) Integer page,
                                                  @RequestParam(value = "size", required = false) Integer size){
        JSONObject js=new JSONObject();
        PageHelper.startPage(page,size);
        List<BaoJingYuJingEntity> baoJingYuJingEntities=baoJingYuJingPropertyService.findAllYuJingBaoJing(page,size);
        js.put("baoJingYuJingEntities",baoJingYuJingEntities);
        PageInfo<BaoJingYuJingEntity> pageInfo=new PageInfo<>(baoJingYuJingEntities);
        js.put("pageInfo",pageInfo);
        return ResponseDataUtil.ok("查询所有数据成功",js);
    }

    //查询所有的区段
    @GetMapping("/findAllQuDuan")
    public Map<String,Object>findAllQuDuan(){
        List<QuDuanBaseEntity> quduan =baoJingYuJingPropertyService.findAllQuDuan();
        /*List<QuDuanBaseEntity> list=null;
        for (QuDuanBaseEntity quDuanBaseEntity : quduan) {
            if (quDuanBaseEntity.getQuduanyunyingName()!=null){
                list.add(quDuanBaseEntity);
            }
        }*/
        return ResponseDataUtil.ok("查询区段成功",quduan);
    }
    //根据搜索  查询对应的预警报警信息
    @GetMapping("/findYuJingBaoJingBySouSuo")
    public Map<String,Object>findYuJingBaoJingBySouSuo(Integer[] ids, Integer sid, Integer qid,
                                                       Date startTime, Date huifuTime, Integer tianChuang,
                                                       Integer lvChuHuiFu, Integer lvChuKaiTong,
                                                       @RequestParam(value = "page", required = false) Integer page,
                                                       @RequestParam(value = "size", required = false) Integer size){
        try {
            JSONObject js=new JSONObject();
            PageHelper.startPage(page,size);
            List<BaoJingYuJingEntity> baoJingYuJingEntities= baoJingYuJingPropertyService.findYuJingBaoJingBySouSuo(ids,
                    sid,qid,startTime,huifuTime,tianChuang,lvChuHuiFu,lvChuKaiTong,page,size);
            js.put("baoJingYuJingEntities",baoJingYuJingEntities);
            PageInfo<BaoJingYuJingEntity> pageInfo=new PageInfo<>(baoJingYuJingEntities);
            js.put("pageInfo",pageInfo);
            return ResponseDataUtil.ok("搜索数据成功",js);
        }catch (Exception e){
            return ResponseDataUtil.error("请选择要查询的报警或者预警名称");
        }
    }
}
