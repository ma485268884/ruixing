package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.DistrictEntity;

import java.util.List;

/**
 * @author:mlf
 * @date:2020/7/28 13:42
 * 区域
 */
public interface DistrictService {
    /**
     * @param id 区域id
     * @return 区域信息
     */
    DistrictEntity findById(Integer id);

    /**
     * @param parentId 区域父节点id
     * @return 区域信息集
     */
    List<DistrictEntity> findByParentId(Integer parentId);
}
