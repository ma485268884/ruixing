package com.yintu.ruixing.controller;

import com.alibaba.fastjson.JSONObject;
import com.yintu.ruixing.entity.CheZhanEntity;
import com.yintu.ruixing.entity.DianWuDuanEntity;
import com.yintu.ruixing.entity.TieLuJuEntity;
import com.yintu.ruixing.entity.XianDuanEntity;
import com.yintu.ruixing.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO
 *
 * @description:
 * @author: Qiao
 * @time: 2020/5/21 17:17
 */
@RestController
public class ListController {
    @Autowired
    private ListService ls;

    @GetMapping("findall")
    public List<TieLuJuEntity> findall(){
        List<TieLuJuEntity> list1 = ls.findall();
        return list1;
    }

    @GetMapping("findallBytljid")
    public String findallBytljid(Long tlj_id){

        List<DianWuDuanEntity> List2= ls.findallBytljid(tlj_id);
        String str = JSONObject.toJSONString(List2);
        return str;
    }

    @GetMapping("findallBydwdid")
    public String findallBydwdid(Long dwd_id){
        List<XianDuanEntity> List3= ls.findallBydwdid(dwd_id);
        String str1 = JSONObject.toJSONString(List3);
        return str1;
    }

    @GetMapping("findallByxdid")
    public String findallByxdid(Long xd_id){
        List<CheZhanEntity> List4= ls.findallByxdid(xd_id);
        String str2 = JSONObject.toJSONString(List4);
        return str2;
    }
}
