package com.yintu.ruixing.controller;


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

    @GetMapping("getLieBiao")
    public List<LieBiaoEntity> getLieBiao(){
        List list=ls.findall();
return null;
    }


}
