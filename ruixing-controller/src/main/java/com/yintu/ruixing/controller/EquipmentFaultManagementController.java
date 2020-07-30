package com.yintu.ruixing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.exception.BaseRuntimeException;
import com.yintu.ruixing.common.util.BaseController;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.entity.*;
import com.yintu.ruixing.service.DataStatsService;
import com.yintu.ruixing.service.EquipmentFaultManagementService;
import com.yintu.ruixing.service.EquipmentNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 故障器材特征管理
 *
 * @author:mlf
 * @date:2020/7/29 17:41
 */
@RestController
@RequestMapping("/equipment/fault/managements")
public class EquipmentFaultManagementController extends SessionController implements BaseController<EquipmentFaultManagementEntity, Integer> {
    @Autowired
    private EquipmentFaultManagementService equipmentFaultManagementService;
    @Autowired
    private EquipmentNumberService equipmentNumberService;

    @Autowired
    private DataStatsService dataStatsService;

    @PostMapping
    public Map<String, Object> add(@Validated EquipmentFaultManagementEntity entity) {
        if (entity.getStartDate().after(entity.getEndDate()))
            throw new BaseRuntimeException("开始日期不能小于结束日期");
        equipmentFaultManagementService.add(entity);
        return ResponseDataUtil.ok("添加故障器材特征管理信息成功");
    }

    @Override
    public Map<String, Object> remove(Integer id) {
        return null;
    }

    @DeleteMapping("/{ids}")
    public Map<String, Object> remove(@PathVariable Integer[] ids) {
        equipmentFaultManagementService.remove(ids);
        return ResponseDataUtil.ok("删除故障器材特征管理信息成功");
    }


    @PutMapping("/{id}")
    public Map<String, Object> edit(@PathVariable Integer id, @Validated EquipmentFaultManagementEntity entity) {
        if (entity.getStartDate().after(entity.getEndDate()))
            throw new BaseRuntimeException("开始日期不能小于结束日期");
        equipmentFaultManagementService.edit(entity);
        return ResponseDataUtil.ok("修改故障器材特征管理信息成功");
    }

    @GetMapping("/{id}")
    public Map<String, Object> findById(@PathVariable Integer id) {
        EquipmentFaultManagementEntity equipmentFaultManagementEntity = equipmentFaultManagementService.findById(id);
        return ResponseDataUtil.ok("查询故障器材特征管理信息成功", equipmentFaultManagementEntity);
    }

    @GetMapping
    public Map<String, Object> findByStartDateAndEndDate(@RequestParam("page_number") Integer pageNumber,
                                                         @RequestParam("page_size") Integer pageSize,
                                                         @RequestParam(value = "order_by", required = false, defaultValue = "efm.id DESC") String orderBy,
                                                         @RequestParam(value = "start_date", required = false) Date startDate,
                                                         @RequestParam(value = "end_date", required = false) Date endDate) {
        PageHelper.startPage(pageNumber, pageSize, orderBy);
        List<EquipmentFaultManagementEntity> equipmentFaultManagementEntities = equipmentFaultManagementService.findByStartDateAndEndDate(startDate, endDate);
        PageInfo<EquipmentFaultManagementEntity> pageInfo = new PageInfo<>(equipmentFaultManagementEntities);
        return ResponseDataUtil.ok("查询故障器材特征管理信息列表成功", pageInfo);
    }


    /**
     * 查询器材编号全部信息
     *
     * @return 返回信息
     */
    @GetMapping("/equipment/numbers")
    @ResponseBody
    public Map<String, Object> findEquipmentNumberAll() {
        List<EquipmentNumberEntity> equipmentNumberEntities = equipmentNumberService.findByCondition(null, null);
        return ResponseDataUtil.ok("查询器材编号信息列表成功", equipmentNumberEntities);
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
