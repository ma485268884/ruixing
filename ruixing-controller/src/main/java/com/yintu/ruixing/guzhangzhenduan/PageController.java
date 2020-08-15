package com.yintu.ruixing.guzhangzhenduan;

import com.yintu.ruixing.common.util.ResponseDataUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:lcy
 * @date:2020-06-02 20
 * 分页
 */
@RestController
@RequestMapping("/page")
public class PageController {
   /* @Autowired
    private PageService pageService;

    @GetMapping("/pageById")
    public Object geiById(){
        return ResponseDataUtil.ok("返回数据",pageService.page());
    }*/
}
