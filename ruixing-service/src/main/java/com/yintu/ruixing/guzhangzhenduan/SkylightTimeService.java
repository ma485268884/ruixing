package com.yintu.ruixing.guzhangzhenduan;

import com.yintu.ruixing.common.util.BaseService;

import java.util.Date;
import java.util.List;

/**
 * @author:mlf
 * @date:2020/8/18 17:54
 */
public interface SkylightTimeService extends BaseService<SkylightTimeEntity, Integer> {


    void add(SkylightTimeEntity entity, Integer[] qdIds);

    void remove(Integer[] ids);

    SkylightTimeEntity findByCzIdAndQdId(Integer czId, Integer qdId);

    List<SkylightTimeEntity> findByCondition(Integer id, Date startTime, Date endTime);
}
