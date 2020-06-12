package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.QuDuanBaseEntity;
import com.yintu.ruixing.entity.QuDuanInfoEntity;
import com.yintu.ruixing.entity.SheBeiEntity;
import com.yintu.ruixing.service.QuXianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author:lcy
 * @date:2020-06-11 17
 * 曲线相关
 */
@RestController
@RequestMapping("/quXianAll")
public class QuXianController {
    @Autowired
    private QuXianService quXianService;

    //根据车站cid查询 对应的设备
    @GetMapping("/findSheBeiByCid/{id}")
    public Map<String, Object> findSheBeiByCid(@PathVariable Integer id) {
        List<SheBeiEntity> sheBeiEntities = quXianService.findSheBeiByCid(id);
        return ResponseDataUtil.ok("查询设备成功", sheBeiEntities);
    }

    //根据sid查询对应的区段
    @GetMapping("/findQuDuanById/{id}")
    public Map<String, Object> findQuDuanById(@PathVariable Integer id) {
        List<QuDuanBaseEntity> quDuanBaseEntities = quXianService.findQuDuanById(id);
        return ResponseDataUtil.ok("查询区段信息成功", quDuanBaseEntities);
    }


    //根据所选日期  获取对应的数据
    @GetMapping("/findQuDuanDataByTime")
    public Map<String, Object> findQuDuanDataByTime(@RequestParam("time") Date time) {
        List<QuDuanInfoEntity> quDuanInfoEntities = quXianService.findQuDuanDataByTime(time);
        System.out.println("riqi" + quDuanInfoEntities);
        return ResponseDataUtil.ok("查询数据成功", quDuanInfoEntities);
    }

    //根据所选日期  获得对应的24个时间点
    @GetMapping("/findQuDuanDataByTime1")
    public Map<String, Object> findQuDuanDataByTime1(@RequestParam("time") Date time, @RequestParam("name") String name) {
        Map<String, Object> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        Date time1=null;
        String hh=null;

        List<QuDuanBaseEntity> quDuanBaseEntities = quXianService.findQuDuanDataByTime1(time); //根据传来的时间 获取查询出来的区段信息
        for (QuDuanBaseEntity quDuanBaseEntity : quDuanBaseEntities) {//遍历区段
             time1 = quDuanBaseEntity.getTime();//得到查询的时间
             hh = new SimpleDateFormat("HH").format(time1);//把时间变成小时
            list.add(hh);//把时间变成小时  存到list里面
            Collections.sort(list);//排序时间  从小到大
            String format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(time1);//把时间转换格式
            System.out.println("55555+"+format);
            List<QuDuanInfoEntity> quDuanInfoEntities = quXianService.findQuDuanDataByTime2(format);//根据时间查询区段的所有数据信息
            System.out.println(quDuanInfoEntities);
        }


            /*for (QuDuanInfoEntity quDuanInfoEntity : quDuanInfoEntities) {//遍历区段的数据
                Field[] declaredFields = quDuanInfoEntity.getClass().getDeclaredFields();
                for (int i = 0; i < declaredFields.length; i++) {
                    String name1 = declaredFields[i].getName();
                    if (name1.equals(name)) {
                        System.out.println("11112121212121212121");
                    }
                    System.out.println("name111=" + name1);
                }
                list1.add(quDuanInfoEntity.getId());
            }*/

        map.put("hours", list);
        map.put("shuzi", list1);
        System.out.println(map);
        return ResponseDataUtil.ok("查询数据成功", map);
    }
}
