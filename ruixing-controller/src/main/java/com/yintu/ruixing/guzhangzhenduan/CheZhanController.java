package com.yintu.ruixing.guzhangzhenduan;

import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.guzhangzhenduan.CheZhanEntity;
import com.yintu.ruixing.guzhangzhenduan.QuDuanBaseEntity;
import com.yintu.ruixing.guzhangzhenduan.CheZhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @description:
 * @author: Qiao
 * @time: 2020/5/25 17:20
 */
@RestController
@RequestMapping("/chezhanAll")
public class CheZhanController {

    @Autowired
    private CheZhanService cheZhanService;

    @PostMapping("/addCheZhan")
    public Map<String,Object> addCheZhan(CheZhanEntity cheZhanEntity){
        cheZhanService.add(cheZhanEntity);
        return ResponseDataUtil.ok("添加车站成功");
    }
    @PutMapping("/updateCheZhan/{cid}")
    public Map<String,Object> updateCheZhan(@PathVariable Long cid ,CheZhanEntity cheZhanEntity){
        cheZhanService.update(cheZhanEntity);
        return  ResponseDataUtil.ok("修改车站信息成功");
    }

    @GetMapping("/findByCheZhanId/{cid}")
    public  Map<String,Object> findByCheZhanId(@PathVariable Long cid){
        CheZhanEntity cheZhanEntity = cheZhanService.findByCheZhanId(cid);
        return ResponseDataUtil.ok("查询车站信息成功",cheZhanEntity);
    }
    //删除车站
    @DeleteMapping("/delCheZhan/{cid}")
    public Map<String,Object>delCheZhan(@PathVariable Long cid){
        List<QuDuanBaseEntity>quDuanBaseEntityList=cheZhanService.findQuDuanByCid(cid);
        if (quDuanBaseEntityList.size()==0){
            cheZhanService.delCheZhan(cid);
            return ResponseDataUtil.ok("删除车站成功");
        }else {
            return ResponseDataUtil.error("此车站不能删除");
        }
    }

    //根据线段id 查询对应的相邻1车站
    @GetMapping("/findXiangLinOneCheZhanByXdid/{xdid}")
    public Map<String,Object>findXiangLinOneCheZhanByXdid(@PathVariable Integer xdid){
        List<CheZhanEntity> cheZhanEntityList=cheZhanService.findXiangLinOneCheZhanByXdid(xdid);
        return ResponseDataUtil.ok("查询相邻车站1成功",cheZhanEntityList);
    }

    //根据线段id 查询对应的相邻2车站
    @GetMapping("/findXiangLinTwoCheZhanByXdid/{xdid}")
    public Map<String,Object>findXiangLinTwoCheZhanByXdid(@PathVariable Integer xdid){
        List<CheZhanEntity> cheZhanEntityList=cheZhanService.findXiangLinTwoCheZhanByXdid(xdid);
        return ResponseDataUtil.ok("查询相邻车站1成功",cheZhanEntityList);
    }

    //根据线段id 查询对应的相邻3车站
    @GetMapping("/findXiangLinThreeCheZhanByXdid/{xdid}")
    public Map<String,Object>findXiangLinThreeCheZhanByXdid(@PathVariable Integer xdid){
        List<CheZhanEntity> cheZhanEntityList=cheZhanService.findXiangLinThreeCheZhanByXdid(xdid);
        return ResponseDataUtil.ok("查询相邻车站1成功",cheZhanEntityList);
    }
    //根据线段id 查询对应的相邻4车站
    @GetMapping("/findXiangLinFourCheZhanByXdid/{xdid}")
    public Map<String,Object>findXiangLinFourCheZhanByXdid(@PathVariable Integer xdid){
        List<CheZhanEntity> cheZhanEntityList=cheZhanService.findXiangLinFourCheZhanByXdid(xdid);
        return ResponseDataUtil.ok("查询相邻车站1成功",cheZhanEntityList);
    }

    //根据线段id 查询对应的相邻5车站
    @GetMapping("/findXiangLinFiveCheZhanByXdid/{xdid}")
    public Map<String,Object>findXiangLinFiveCheZhanByXdid(@PathVariable Integer xdid){
        List<CheZhanEntity> cheZhanEntityList=cheZhanService.findXiangLinFiveCheZhanByXdid(xdid);
        return ResponseDataUtil.ok("查询相邻车站1成功",cheZhanEntityList);
    }

    //根据线段id 查询对应的相邻6车站
    @GetMapping("/findXiangLinSixCheZhanByXdid/{xdid}")
    public Map<String,Object>findXiangLinSixCheZhanByXdid(@PathVariable Integer xdid){
        List<CheZhanEntity> cheZhanEntityList=cheZhanService.findXiangLinSixCheZhanByXdid(xdid);
        return ResponseDataUtil.ok("查询相邻车站1成功",cheZhanEntityList);
    }
}
