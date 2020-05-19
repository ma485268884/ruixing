package com.yintu.ruixing.service.rbac.impl;

import com.yintu.ruixing.dao.rbac.RoleDao;
import com.yintu.ruixing.entity.rbac.RoleEntity;
import com.yintu.ruixing.entity.rbac.RoleEntityExample;
import com.yintu.ruixing.service.rbac.RoleService;
import com.yintu.ruixing.service.rbac.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/5/19 9:45
 */

public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    /**
     * 按照多个id查询多个角色信息
     * @param ids
     * @return
     */
    @Override
    public List<RoleEntity> findByIds(List<Long> ids) {
        RoleEntityExample roleEntityExample = new RoleEntityExample();
        RoleEntityExample.Criteria criteria = roleEntityExample.createCriteria();
        criteria.andIdIn(ids);
        return roleDao.selectByExample(roleEntityExample);
    }
}
