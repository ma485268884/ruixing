package com.yintu.ruixing.guzhangzhenduan;

import com.yintu.ruixing.common.util.BaseService;
import com.yintu.ruixing.guzhangzhenduan.QuDuanDownloadEntity;

import java.util.Date;
import java.util.List;

/**
 * @author:mlf
 * @date:2020/6/8 15:29
 */
public interface QuDuanDownloadService extends BaseService<QuDuanDownloadEntity, Integer> {


    Integer add(Integer czId, Short type, Date startDateTime, Date endDateTime);


    List<QuDuanDownloadEntity> findByDateTime(Integer czId, Date startDateTime, Date endDateTime);

    /**
     * @param czId       车站id
     * @param dataStatus 数据接收状态
     */
    Integer changeDataStatus(Integer czId, Integer userId, Short dataStatus);

    Integer changeSwitchStatus(Integer czId, Integer userId, Short switchStatus);

    Short changeUpdateTime(Integer czId, Integer userId);
}
