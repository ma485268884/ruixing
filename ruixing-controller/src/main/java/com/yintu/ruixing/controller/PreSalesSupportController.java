package com.yintu.ruixing.controller;

import com.yintu.ruixing.common.exception.BaseRuntimeException;
import com.yintu.ruixing.common.util.ResponseDataUtil;
import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.entity.SolutionEntity;
import com.yintu.ruixing.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/6/22 17:39
 */

@RestController
@RequestMapping("/presavless")
public class PreSalesSupportController extends BaseController {
    @Autowired
    private SolutionService solutionService;

    @PostMapping
    public Map<String, Object> add(SolutionEntity solutionEntity) {
        Integer parentId = solutionEntity.getParentId();
        String name = solutionEntity.getName();
        if (parentId == null)
            throw new BaseRuntimeException("父级ID不能为空");
        if (name == null || name.isEmpty())
            throw new BaseRuntimeException("目录名不能为空");
        solutionEntity.setType((short) 1);
        solutionService.add(solutionEntity);
        return ResponseDataUtil.ok("添加售前技术支持类别成功");
    }


    @DeleteMapping("/{id}")
    public Map<String, Object> remove(@PathVariable Integer id) {
        solutionService.remove(id);//删除此类别id
        solutionService.removeTreeByIdAndType(id, (short) 1);//删除此类别下的子节点
        return ResponseDataUtil.ok("删除售前技术支持类别成功");
    }

    @PutMapping("/{id}")
    public Map<String, Object> edit(SolutionEntity solutionEntity) {
        Integer parentId = solutionEntity.getParentId();
        String name = solutionEntity.getName();
        if (parentId == null)
            throw new BaseRuntimeException("父级ID不能为空");
        if (name == null || name.isEmpty())
            throw new BaseRuntimeException("目录名不能为空");
        solutionEntity.setType((short) 1);
        solutionService.edit(solutionEntity);
        return ResponseDataUtil.ok("修改售前技术支持类别成功");
    }

    @GetMapping("/{id}")
    public Map<String, Object> findById(@PathVariable Integer id) {
        SolutionEntity solutionEntity = solutionService.findById(id);
        return ResponseDataUtil.ok("查询售前技术支持类别成功", solutionEntity);
    }

    @GetMapping
    public Map<String, Object> findAll() {
        List<TreeNodeUtil> treeNodeUtils = solutionService.findTreeByParentIdAndType(-1, (short) 1);
        return ResponseDataUtil.ok("查询售前技术支持类别树成功", treeNodeUtils);
    }

}
