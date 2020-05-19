package com.yintu.ruixing.service.rbac.impl;

import com.yintu.ruixing.dao.rbac.UserRoleDao;
import com.yintu.ruixing.entity.rbac.RoleEntity;
import com.yintu.ruixing.entity.rbac.UserRoleEntity;
import com.yintu.ruixing.entity.rbac.UserRoleEntityExample;
import com.yintu.ruixing.service.rbac.RoleService;
import com.yintu.ruixing.service.rbac.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:mlf
 * @date:2020/5/19 9:32
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private RoleService roleService;


    /**
     * 按照用户id查询出全部角色信息
     *
     * @param userId 用户id
     * @return 角色全部信息
     */
    @Override
    public List<RoleEntity> findRolesByUserId(Long userId) {
        UserRoleEntityExample userRoleEntityExample = new UserRoleEntityExample();
        UserRoleEntityExample.Criteria criteria = userRoleEntityExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<UserRoleEntity> userRoleEntities = userRoleDao.selectByExample(userRoleEntityExample);
        List<Long> roleIds = new ArrayList<>();
        for (UserRoleEntity userRoleEntity : userRoleEntities) {
            roleIds.add(userRoleEntity.getUserId());
        }
        return roleService.findByIds(roleIds);
    }
}
