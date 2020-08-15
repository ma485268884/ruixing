package com.yintu.ruixing.anzhuangtiaoshi;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.anzhuangtiaoshi.AnZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity;
import com.yintu.ruixing.anzhuangtiaoshi.AnZhuangTiaoShiWorkNameTotalEntity;
import com.yintu.ruixing.anzhuangtiaoshi.AnZhuangTiaoShiWorkNameTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author Mr.liu
 * @Date 2020/7/17 11:11
 * @Version 1.0
 * 需求:现场作业的作业项配置版本
 */
@RestController
@RequestMapping("/AnZhuangTiaoShiWorkNameTotalAll")
public class AnZhuangTiaoShiWorkNameTotalController {
    @Autowired
    private AnZhuangTiaoShiWorkNameTotalService anZhuangTiaoShiWorkNameTotalService;

    //新增作业项配置版本
    @PostMapping("/addWorkNameTotal")
    public Map<String, Object> addWorkNameTotal(AnZhuangTiaoShiWorkNameTotalEntity anZhuangTiaoShiWorkNameTotalEntity) {
        anZhuangTiaoShiWorkNameTotalService.addWorkNameTotal(anZhuangTiaoShiWorkNameTotalEntity);
        return ResponseDataUtil.ok("新增作业项配置版本成功");
    }

    //查询所有的作业项配置版本 或者 根据名字进行模糊查询
    @GetMapping("/findWorkNameTotal")
    public Map<String, Object> findWorkNameTotal(Integer page, Integer size, String workname) {
        PageHelper.startPage(page, size);
        List<AnZhuangTiaoShiWorkNameTotalEntity> workNameTotalEntities = anZhuangTiaoShiWorkNameTotalService.findWorkNameTotal(page, size, workname);
        PageInfo<AnZhuangTiaoShiWorkNameTotalEntity> workNameTotalEntityPageInfo = new PageInfo<>(workNameTotalEntities);
        return ResponseDataUtil.ok("查询作业项配置版本成功", workNameTotalEntityPageInfo);
    }

    //根据作业项配置版本id  编辑对应的配置版本
    @PutMapping("/editWorkNameTotalById/{id}")
    public Map<String, Object> editWorkNameTotalById(@PathVariable Integer id, AnZhuangTiaoShiWorkNameTotalEntity anZhuangTiaoShiWorkNameTotalEntity) {
        anZhuangTiaoShiWorkNameTotalService.editWorkNameTotalById(anZhuangTiaoShiWorkNameTotalEntity);
        return ResponseDataUtil.ok("修改作业项配置版本成功");
    }

    //根据作业项配置版本id  单个 或者 批量删除对应的数据
    @DeleteMapping("/deleteWorkNameTotalByIds/{ids}")
    public Map<String, Object> deleteWorkNameTotalByIds(@PathVariable Integer[] ids) {
        anZhuangTiaoShiWorkNameTotalService.deleteWorkNameTotalByIds(ids);
        return ResponseDataUtil.ok("删除成功");
    }
//////////////////////////////作业项配置版本/////////////////////////////////////

    // 在对应的作业项配置版本下  添加作业项
    @PostMapping("/addWorkNameEdition")
    public Map<String,Object>addWorkNameEdition(AnZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity anZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity,Integer[] wnlids){
        anZhuangTiaoShiWorkNameTotalService.addWorkNameEdition(anZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity,wnlids);
        return ResponseDataUtil.ok("添加成功");
    }

    //根据作业项配置版本id 查看对应的作业项
    @GetMapping("/findWorkNameById/{id}")
    public Map<String,Object>findWorkNameById(@PathVariable Integer id ,Integer page,Integer size){
        PageHelper.startPage(page,size);
        List<AnZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity> workNameTotalEntities=anZhuangTiaoShiWorkNameTotalService.findWorkNameById(id,page,size);
        PageInfo<AnZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity> workNameTotalEntityPageInfo=new PageInfo<>(workNameTotalEntities);
        return ResponseDataUtil.ok("查询版本下的作业项成功",workNameTotalEntityPageInfo);
    }

    //根据id  编辑对应的作业项
    @PutMapping("/editWorkNameById/{id}")
    public Map<String,Object>editWorkNameById(@PathVariable Integer id,AnZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity anZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity){
        anZhuangTiaoShiWorkNameTotalService.editWorkNameById(anZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity);
        return ResponseDataUtil.ok("编辑成功");
    }

    //根据id  批量或者单个删除作业项数据
    @DeleteMapping("/deleteWorkNameByIds/{ids}")
    public Map<String,Object>deleteWorkNameByIds(@PathVariable Integer[] ids ){
        anZhuangTiaoShiWorkNameTotalService.deleteWorkNameByIds(ids);
        return ResponseDataUtil.ok("删除成功");
    }

    //根据作业项的名称  进行模糊查询
    @GetMapping("/findWorkNameByWorkname")
    public Map<String,Object>findWorkNameByWorkname(String workname,Integer page,Integer size){
        PageHelper.startPage(page,size);
        List<AnZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity> workNameTotalEntities=anZhuangTiaoShiWorkNameTotalService.findWorkNameByWorkname(workname,page,size);
        PageInfo<AnZhuangTiaoShiWorkNameLibraryShiWorkNameTotalEntity> workNameTotalEntityPageInfo=new PageInfo<>(workNameTotalEntities);
        return ResponseDataUtil.ok("查询对应的作业项成功",workNameTotalEntityPageInfo);
    }
}
