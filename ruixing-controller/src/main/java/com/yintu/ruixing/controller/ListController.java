package com.yintu.ruixing.controller;

import com.alibaba.fastjson.JSONObject;
import com.yintu.ruixing.entity.*;
import com.yintu.ruixing.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
/*
    @GetMapping("getLieBiao")
    public List<LieBiaoEntity> getLieBiao(){
        List<TieLuJuEntity> list1 = ls.findall();
        for (TieLuJuEntity tieLuJuEntity : list1) {
            List<DianWuDuanEntity> list2 = ls.findallBytljid(tieLuJuEntity.getId());

            for (DianWuDuanEntity dianWuDuanEntity : list2) {
                List<XianDuanEntity> list3 = ls.findallBydwdid(dianWuDuanEntity.getId());

                for (XianDuanEntity xianDuanEntity : list3) {
                    List<CheZhanEntity> list4 = ls.findallByxdid(xianDuanEntity.getId());
                    System.out.println(list4.toString()+"++++++4++++++++++");
                        return (List<LieBiaoEntity>) JSONObject.toJSON(list4);
                }
                System.out.println(list3.toString()+"++++++3++++++++++");
                return (List<LieBiaoEntity>) JSONObject.toJSON(list3);
            }
            System.out.println(list2.toString()+"++++++2++++++++++");
            return (List<LieBiaoEntity>) JSONObject.toJSON(list2);
        }
        System.out.println(list1.toString()+"+++++++1+++++++++");
        return (List<LieBiaoEntity>) JSONObject.toJSON(list1);
    }

    public List<LieBiaoEntity> getlie(){
        List<TieLuJuEntity> list5 = ls.findall();
        fo
    }*/
}
