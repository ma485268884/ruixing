package com.yintu.ruixing.xitongguanli.impl;

import com.yintu.ruixing.common.exception.BaseRuntimeException;
import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.danganguanli.*;
import com.yintu.ruixing.danganguanli.CustomerDutyService;
import com.yintu.ruixing.danganguanli.CustomerUnitsService;
import com.yintu.ruixing.danganguanli.DepartmentCustomerDutyService;
import com.yintu.ruixing.xitongguanli.DepartmentDao;
import com.yintu.ruixing.xitongguanli.DepartmentEntity;
import com.yintu.ruixing.xitongguanli.DepartmentEntityExample;
import com.yintu.ruixing.xitongguanli.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author:mlf
 * @date:2020/5/27 12:02
 */
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private CustomerUnitsService customerUnitsService;

    @Autowired
    private DepartmentCustomerDutyService departmentCustomerDutyService;

    @Autowired
    private CustomerDutyService customerDutyService;

    @Override
    public void add(DepartmentEntity departmentEntity) {
        DepartmentEntityExample departmentEntityExample = new DepartmentEntityExample();
        DepartmentEntityExample.Criteria criteria = departmentEntityExample.createCriteria();
        criteria.andNameEqualTo(departmentEntity.getName());
        List<DepartmentEntity> departmentEntitis = this.findByExample(departmentEntityExample);
        if (departmentEntitis.size() > 0) {
            throw new BaseRuntimeException("添加失败，部门名重复");
        }
        departmentEntity.setCreateTime(new Date());
        departmentEntity.setModifiedTime(new Date());
        departmentDao.insertSelective(departmentEntity);
    }

    @Override
    public void edit(DepartmentEntity departmentEntity) {
        DepartmentEntityExample departmentEntityExample = new DepartmentEntityExample();
        DepartmentEntityExample.Criteria criteria = departmentEntityExample.createCriteria();
        criteria.andNameEqualTo(departmentEntity.getName());
        List<DepartmentEntity> departmentEntitis = this.findByExample(departmentEntityExample);
        if (departmentEntitis.size() > 0 && !departmentEntitis.get(0).getId().equals(departmentEntity.getId())) {
            throw new BaseRuntimeException("修改失败，部门名重复");
        }
        departmentEntity.setModifiedTime(new Date());
        departmentDao.updateByPrimaryKeySelective(departmentEntity);
    }

    @Override
    public void remove(Long id) {
        departmentDao.deleteByPrimaryKey(id);
    }

    @Override
    public void removeByExample(DepartmentEntityExample departmentEntityExample) {
        departmentDao.deleteByExample(departmentEntityExample);
    }

    @Override
    public DepartmentEntity findById(Long id) {
        DepartmentEntity departmentEntity = departmentDao.selectByPrimaryKey(id);
        if (departmentEntity != null) {
            Long customerUnitsId = departmentEntity.getCustomerUnitsId();
            if (customerUnitsId != null) {
                CustomerUnitsEntity customerUnitsEntity = customerUnitsService.findById(customerUnitsId);
                departmentEntity.setCustomerUnitsEntity(customerUnitsEntity);
            }
        }
        return departmentEntity;
    }

    @Override
    public List<DepartmentEntity> findByIds(List<Long> ids) {
        DepartmentEntityExample departmentEntityExample = new DepartmentEntityExample();
        DepartmentEntityExample.Criteria criteria = departmentEntityExample.createCriteria();
        criteria.andIdIn(ids);
        return ids.isEmpty() ? new ArrayList<>() : this.findByExample(departmentEntityExample);
    }

    @Override
    public List<DepartmentEntity> findByExample(DepartmentEntityExample departmentEntityExample) {
        return departmentDao.selectByExample(departmentEntityExample);
    }

    @Override
    public List<TreeNodeUtil> findDepartmentTree(Long parentId, Long customerUnitsId) {
        DepartmentEntityExample departmentEntityExample = new DepartmentEntityExample();
        DepartmentEntityExample.Criteria criteria = departmentEntityExample.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        if (customerUnitsId != null) {
            criteria.andCustomerUnitsIdEqualTo(customerUnitsId);
        }
        List<DepartmentEntity> departmentEntities = departmentDao.selectByExample(departmentEntityExample);

        List<TreeNodeUtil> treeNodeUtils = new ArrayList<>();
        for (DepartmentEntity departmentEntity : departmentEntities) {
            TreeNodeUtil treeNodeUtil = new TreeNodeUtil();
            treeNodeUtil.setId(departmentEntity.getId());
            treeNodeUtil.setLabel(departmentEntity.getName());
            treeNodeUtil.setValue(departmentEntity.getId().toString());
            Map<String, Object> map = new HashMap<>();
            map.put("parentId", departmentEntity.getParentId());
            map.put("createBy", departmentEntity.getCreateBy());
            map.put("createTime", departmentEntity.getCreateTime());
            map.put("modifiedBy", departmentEntity.getModifiedBy());
            map.put("modifiedTime", departmentEntity.getModifiedTime());
            map.put("customerUnitsId", departmentEntity.getCustomerUnitsId());
            treeNodeUtil.setA_attr(map);
            treeNodeUtil.setChildren(customerUnitsId != null ? this.findDepartmentTree(departmentEntity.getId(), customerUnitsId) :
                    this.findDepartmentTree(departmentEntity.getId(), null));
            treeNodeUtils.add(treeNodeUtil);
        }
        return treeNodeUtils;
    }

    @Override
    public void removeByIdAndIsFirst(Long id, Boolean isFirst) {
        if (isFirst) {
            DepartmentEntity departmentEntity = this.findById(id);
            if (departmentEntity != null) {
                this.remove(id);
            }
        }
        DepartmentEntityExample departmentEntityExample = new DepartmentEntityExample();
        DepartmentEntityExample.Criteria criteria = departmentEntityExample.createCriteria();
        criteria.andParentIdEqualTo(id);
        List<DepartmentEntity> departmentEntities = this.findByExample(departmentEntityExample);
        if (departmentEntities.size() > 0) {
            for (DepartmentEntity departmentEntity : departmentEntities) {
                this.remove(departmentEntity.getId());
                this.removeByIdAndIsFirst(departmentEntity.getId(), false);
            }
        }
    }

    @Override
    public List<CustomerDutyEntity> findCustomerDutiesByIds(Long[] ids) {
        DepartmentCustomerDutyEntityExample departmentCustomerDutyEntityExample = new DepartmentCustomerDutyEntityExample();
        DepartmentCustomerDutyEntityExample.Criteria criteria = departmentCustomerDutyEntityExample.createCriteria();
        criteria.andDepartmentIdIn(Arrays.asList(ids));
        List<DepartmentCustomerDutyEntity> departmentCustomerDutyEntities = departmentCustomerDutyService.findByExample(departmentCustomerDutyEntityExample);
        if (departmentCustomerDutyEntities.isEmpty())
            return new ArrayList<>();
        List<Long> dutyIds = departmentCustomerDutyEntities.stream()
                .map(DepartmentCustomerDutyEntity::getDutyId)
                .distinct().collect(Collectors.toList());
        CustomerDutyEntityExample customerDutyEntityExample = new CustomerDutyEntityExample();
        CustomerDutyEntityExample.Criteria criteria1 = customerDutyEntityExample.createCriteria();
        criteria1.andIdIn(dutyIds);
        return customerDutyService.findByExample(customerDutyEntityExample);
    }

}
