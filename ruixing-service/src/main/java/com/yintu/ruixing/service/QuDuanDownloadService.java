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

    QuDuanDownloadEntity findByCidAndDataType(Integer cid, Short dataType);

    Integer add(Integer czId, Short type, Date startDateTime, Date endDateTime);

    Map<String, Object> findPlayBackDataById(Integer id);

    List<QuDuanDownloadEntity> findByDateTime(Date startDateTime, Date endDateTime);

}
