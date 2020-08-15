package com.yintu.ruixing.weixiudaxiu;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.util.BaseController;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.common.SessionController;
import com.yintu.ruixing.guzhangzhenduan.CheZhanEntity;
import com.yintu.ruixing.guzhangzhenduan.DianWuDuanEntity;
import com.yintu.ruixing.guzhangzhenduan.TieLuJuEntity;
import com.yintu.ruixing.guzhangzhenduan.XianDuanEntity;
import com.yintu.ruixing.guzhangzhenduan.DataStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 现场故障调查管理
 *
 * @author:mlf
 * @date:2020/7/30 19:30
 */
@RestController
@RequestMapping("/field/faultInvestigation/managements")
public class FieldFaultInvestigationManagementController extends SessionController implements BaseController<FieldFaultInvestigationManagementEntity, Integer> {

    @Autowired
    private FieldFaultInvestigationManagementService fieldFaultInvestigationManagementService;
    @Autowired
    private DataStatsService dataStatsService;

    @PostMapping
    public Map<String, Object> add(@Validated FieldFaultInvestigationManagementEntity entity) {
        fieldFaultInvestigationManagementService.add(entity);
        return ResponseDataUtil.ok("添加现场故障调查管理信息成功");
    }

    @Override
    public Map<String, Object> remove(Integer id) {
        return null;
    }

    @DeleteMapping("/{ids}")
    public Map<String, Object> remove(@PathVariable Integer[] ids) {
        fieldFaultInvestigationManagementService.remove(ids);
        return ResponseDataUtil.ok("删除现场故障调查管理信息成功");
    }

    @PutMapping("/{id}")
    public Map<String, Object> edit(@PathVariable Integer id, @Validated FieldFaultInvestigationManagementEntity entity) {
        fieldFaultInvestigationManagementService.edit(entity);
        return ResponseDataUtil.ok("修改现场故障调查管理信息成功");
    }

    @GetMapping("/{id}")
    public Map<String, Object> findById(@PathVariable Integer id) {
        FieldFaultInvestigationManagementEntity fieldFaultInvestigationManagementEntity = fieldFaultInvestigationManagementService.findById(id);
        return ResponseDataUtil.ok("查询现场故障调查管理信息成功", fieldFaultInvestigationManagementEntity);
    }

    @GetMapping
    public Map<String, Object> findByStartDateAndEndDate(@RequestParam("page_number") Integer pageNumber,
                                                         @RequestParam("page_size") Integer pageSize,
                                                         @RequestParam(value = "order_by", required = false, defaultValue = "ffim.id DESC") String orderBy,
                                                         @RequestParam(value = "start_date", required = false) Date startDate,
                                                         @RequestParam(value = "end_date", required = false) Date endDate) {
        PageHelper.startPage(pageNumber, pageSize, orderBy);
        List<FieldFaultInvestigationManagementEntity> fieldFaultInvestigationManagementEntities = fieldFaultInvestigationManagementService.findByStartDateAndEndDate(startDate, endDate);
        PageInfo<FieldFaultInvestigationManagementEntity> pageInfo = new PageInfo<>(fieldFaultInvestigationManagementEntities);
        return ResponseDataUtil.ok("查询现场故障调查管理信息列表成功", pageInfo);
    }


    /**
     * 查询铁路局全部信息
     *
     * @return 返回信息
     */
    @GetMapping("/tielujus")
    public Map<String, Object> findTielujuAll() {
        List<TieLuJuEntity> tieLuJuEntities = dataStatsService.findAllTieLuJu();
        return ResponseDataUtil.ok("查询铁路局信息列表成功", tieLuJuEntities);
    }

    /**
     * 通过铁路局id查询电务段全部信息
     *
     * @param tid 铁路局id
     * @return 返回信息
     */
    @GetMapping("/dianwuduans")
    public Map<String, Object> findDianwuduanByTid(@RequestParam("tid") Integer tid) {
        List<DianWuDuanEntity> dianWuDuanEntities = dataStatsService.findDianWuDuanByTid(tid);
        return ResponseDataUtil.ok("查询电务段信息列表成功", dianWuDuanEntities);
    }

    /**
     * 通过电务段id查询线段全部信息
     *
     * @param did 电务段id
     * @return 返回信息
     */
    @GetMapping("/xianduans")
    public Map<String, Object> findXianduanByDid(@RequestParam("did") Integer did) {
        List<XianDuanEntity> xianDuanEntities = dataStatsService.findXianDuanByDid(did);
        return ResponseDataUtil.ok("查询线段信息列表成功", xianDuanEntities);
    }

    /**
     * 通过线段id查询车站全部信息
     *
     * @param xid 线段id
     * @return 返回信息
     */
    @GetMapping("/chezhans")
    public Map<String, Object> findChezhanByXid(@RequestParam("xid") Integer xid) {
        List<CheZhanEntity> cheZhanEntities = dataStatsService.findCheZhanByXid(xid);
        return ResponseDataUtil.ok("查询车站信息列表成功", cheZhanEntities);
    }

}
