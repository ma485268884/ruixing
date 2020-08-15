package com.yintu.ruixing.xitongguanli;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.xitongguanli.DepartmentUserEntity;
import com.yintu.ruixing.xitongguanli.DepartmentUserEntityExample;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/8/10 17:13
 */
public interface DepartmentUserService extends BaseService<DepartmentUserEntity, Long> {

    /**
     * 多条件查询部门用户信息
     *
     * @param departmentUserEntityExample 部门用户条件
     * @return 用户角色信息集
     */
    List<DepartmentUserEntity> findByExample(DepartmentUserEntityExample departmentUserEntityExample);

    /**
     * 按照条件删除部门用户
     *
     * @param departmentUserEntityExample 部门用户条件
     */
    void removeByExample(DepartmentUserEntityExample departmentUserEntityExample);

}
