package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.entity.UserRoleEntity;
import com.yintu.ruixing.entity.UserRoleEntityExample;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/5/19 9:33
 */
public interface UserRoleService extends BaseService<UserRoleEntity, Long> {

    /**
     * 多条件查询用户角色信息
     *
     * @param userRoleEntityExample 用户角色条件
     * @return 用户角色信息集
     */
    List<UserRoleEntity> findByExample(UserRoleEntityExample userRoleEntityExample);

    /**
     * 按照条件删除用户角色
     *
     * @param userRoleEntityExample 用户角色条件
     */
    void removeByExample(UserRoleEntityExample userRoleEntityExample);


}
