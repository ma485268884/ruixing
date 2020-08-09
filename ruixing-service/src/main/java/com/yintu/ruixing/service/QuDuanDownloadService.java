package com.yintu.ruixing.service;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.entity.QuDuanBaseEntity;
import com.yintu.ruixing.entity.QuDuanDownloadEntity;
import com.yintu.ruixing.entity.QuDuanInfoEntity;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/6/8 15:29
 */
public interface QuDuanDownloadService extends BaseService<QuDuanDownloadEntity, Integer> {


    Integer add(Integer czId, Short type, Date startDateTime, Date endDateTime);

    Map<String, Object> findPlayBackDataById(Integer id);

    List<QuDuanDownloadEntity> findByDateTime(Integer czId, Date startDateTime, Date endDateTime);

    /**
     * @param czId       车站id
     * @param dataStatus 数据接收状态
     */
    Integer changeDataStatus(Integer czId, Integer userId, Short dataStatus);

    Integer changeSwitchStatus(Integer czId, Integer userId, Short switchStatus);

    Short changeUpdateTime(Integer czId, Integer userId);
}
