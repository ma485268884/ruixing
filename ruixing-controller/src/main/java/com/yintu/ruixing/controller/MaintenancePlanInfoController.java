package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.util.BaseController;
import com.yintu.ruixing.entity.MaintenancePlanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author:mlf
 * @date:2020/7/9 17:17
 */
@Controller
@RequestMapping("/maintenance/plan/infos")
public class MaintenancePlanInfoController extends SessionController implements BaseController<MaintenancePlanEntity, Integer> {

    @Override
    public Map<String, Object> add(MaintenancePlanEntity entity) {
        return null;
    }

    @Override
    public Map<String, Object> remove(Integer id) {
        return null;
    }

    @Override
    public Map<String, Object> edit(Integer id, MaintenancePlanEntity entity) {
        return null;
    }

    @Override
    public Map<String, Object> findById(Integer id) {
        return null;
    }
}
