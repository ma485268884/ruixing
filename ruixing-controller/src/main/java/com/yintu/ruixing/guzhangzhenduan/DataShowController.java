package com.yintu.ruixing.guzhangzhenduan;

import com.yintu.ruixing.guzhangzhenduan.DataShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author:lcy
 * @date:2020-05-30 16
 * 车站的数据展示
 */
@RestController
@RequestMapping("/dataShow")
public class DataShowController {
    @Autowired
    private DataShowService dataShowService;

    //根据传入的xid和cid和区段号  查询所有相关信息
    public Map<String,Object> allData(Long xid,Long cid,String quduan){

        return dataShowService.allData(xid, cid, quduan);
    }

}
