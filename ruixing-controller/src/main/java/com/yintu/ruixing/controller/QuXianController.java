package com.yintu.ruixing.controller;

import com.alibaba.fastjson.JSONObject;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.QuDuanBaseEntity;
import com.yintu.ruixing.entity.QuDuanInfoEntity;
import com.yintu.ruixing.entity.QuDuanShuXingEntity;
import com.yintu.ruixing.entity.SheBeiEntity;
import com.yintu.ruixing.service.QuXianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
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
    /*@GetMapping("/findQuDuanById/{id}")
    public Map<String, Object> findQuDuanById(@PathVariable Integer id) {
        List<QuDuanBaseEntity> quDuanBaseEntities = quXianService.findQuDuanById(id);
        return ResponseDataUtil.ok("查询区段信息成功", quDuanBaseEntities);
    }*/


    //根据所选日期  获取对应的数据
    @GetMapping("/findQuDuanDataByTime")
    public Map<String, Object> findQuDuanDataByTime(@RequestParam("time") Date time) {
        List<QuDuanInfoEntity> quDuanInfoEntities = quXianService.findQuDuanDataByTime(time);
        System.out.println("riqi" + quDuanInfoEntities);
        return ResponseDataUtil.ok("查询数据成功", quDuanInfoEntities);
    }

    //日报表
    //根据所选日期  获得对应的24个时间点  然后根据时间点和传来的的字段名字 来获取对应的数据
    @GetMapping("/findQuDuanDataByTime1")
    public Map<String, Object> findQuDuanDataByTime1(@RequestParam("time") Date time, @RequestParam("name") String name) {
        Map<String, Object> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<QuDuanBaseEntity> quDuanBaseEntities = quXianService.findQuDuanDataByTime1(time); //根据传来的时间 获取查询出来的区段信息
        for (QuDuanBaseEntity quDuanBaseEntity : quDuanBaseEntities) {//遍历区段
            Date time1 = quDuanBaseEntity.getTime();//得到查询的时间
            // System.out.println(time1);
            String hh = new SimpleDateFormat("HH").format(time1);//把时间变成小时
            list.add(hh);//把时间变成小时  存到list里面
            Collections.sort(list);//排序时间  从小到大
            String format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(time1);//把时间转换格式
            Integer date = quXianService.findQuDuanDataByTime2(format, name);//根据时间查询区段的所有数据信息
            list1.add(date);
        }
        map.put("hours", list);
        map.put("shuzi", list1);
        return ResponseDataUtil.ok("查询数据成功", map);
    }

    //根据车站id   获取车站下 的所有区段
    @GetMapping("/findQuDuanById/{id}")
    public Map<String, Object> findQuDuanById(@PathVariable Integer id) {
        List<String> quDuanBaseEntities = quXianService.findQuDuanById(id);
        return ResponseDataUtil.ok("查询区段成功", quDuanBaseEntities);
    }

    //获取区段的属性名
    @RequestMapping("/shuXingMing")
    public Map<String, Object> shuXingMing() {
        List<QuDuanShuXingEntity> quDuanShuXingEntities = quXianService.shuXingMing();
        return ResponseDataUtil.ok("查询区段名成功", quDuanShuXingEntities);
    }


    //根据传进来的区段id 和本区段所选择的属性id  包括传进来的日期获取对应的数据
    @GetMapping("/findQuDuanData")
    public Map<String, Object> findQuDuanData(@RequestParam("startTime") Date startTime,
                                              @RequestParam("endTime") Date endTime,
                                              @RequestParam("shuxingId") Integer[] shuxingId,
                                              @RequestParam("quduanName") String[] quduanName) throws Exception {
        List<String> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        JSONObject js=new JSONObject();
        long time = endTime.getTime() - startTime.getTime();//得到这两个时间差 单位是秒
        Integer j = 0;
        for (long i = 0; i < time / 1000; i++) {
            j++;
            list.add(j.toString());
        }
        map.put("shijian", list);
        js.put("shijian", list);
        String starttime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(startTime);//把开始时间转换格式
        String endtime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(endTime);//把结束时间转换格式
        List<String> sqlname = quXianService.findShuXingName(shuxingId);
        System.out.println("11111" + sqlname);
        //String[] name=new String[sqlname.size()];
        Integer k = 0;
        for (int i = 0; i < sqlname.size(); i++) {
            k++;
            System.out.println("222222" + sqlname.get(i));//获得每一个属性名
            String shuxingname = sqlname.get(i);
            //name[i]=sqlname.get(i);
            System.out.println("123=" + quduanName[i]);//获得每一个区段名
            String quduanname = quduanName[i];
            List<Integer> date = quXianService.findQuDuanData(starttime, endtime, shuxingname, quduanname);
            map.put("shuju" + k.toString(), date);
            js.put("shuju" + k.toString(), date);
        }
        return ResponseDataUtil.ok("查询数据成功", js);
    }


}
