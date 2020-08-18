package com.yintu.ruixing.guzhangzhenduan;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.SessionController;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/8/18 19:29
 */
@RestController
@RequestMapping("/skylight/times")
public class SkylightTimeController extends SessionController {
    @Autowired
    private SkylightTimeService skylightTimeService;
    @Autowired
    private CheZhanService cheZhanService;
    @Autowired
    private QuDuanBaseService quDuanBaseService;

    @PostMapping
    public Map<String, Object> add(@Validated SkylightTimeEntity entity, Integer[] qdIds) {
        entity.setCreateBy(this.getLoginUserName());
        entity.setCreateTime(new Date());
        entity.setModifiedBy(this.getLoginUserName());
        entity.setModifiedTime(new Date());
        skylightTimeService.add(entity, qdIds);
        return ResponseDataUtil.ok("添加天窗时间信息成功");
    }

    @DeleteMapping("/{ids}")
    public Map<String, Object> remove(@PathVariable Integer[] ids) {
        skylightTimeService.remove(ids);
        return ResponseDataUtil.ok("删除天窗时间信息成功");
    }

    @GetMapping
    public Map<String, Object> findAll(@RequestParam("page_number") Integer pageNumber,
                                       @RequestParam("page_size") Integer pageSize,
                                       @RequestParam(value = "order_by", required = false, defaultValue = "st.id DESC") String orderBy,
                                       @RequestParam(value = "start_time", required = false) Date startTime,
                                       @RequestParam(value = "end_time", required = false) Date endTime) {
        PageHelper.startPage(pageNumber, pageSize, orderBy);
        List<SkylightTimeEntity> skylightTimeEntities = skylightTimeService.findByCondition(null, startTime, endTime);
        PageInfo<SkylightTimeEntity> pageInfo = new PageInfo<>(skylightTimeEntities);
        return ResponseDataUtil.ok("查询天窗时间列表信息成功", pageInfo);
    }

    @GetMapping("/chezhans")
    public Map<String, Object> findChezhan() {
        List<CheZhanEntity> cheZhanEntities = cheZhanService.findAll();
        return ResponseDataUtil.ok("查询车站列表信息成功", cheZhanEntities);
    }

    @GetMapping("/quduans")
    public Map<String, Object> findQuduanByczId(@RequestParam Integer czId) {
        List<QuDuanBaseEntity> quDuanBaseEntities = quDuanBaseService.findByCzId(czId);
        return ResponseDataUtil.ok("查询区段列表信息成功", quDuanBaseEntities);
    }
}
