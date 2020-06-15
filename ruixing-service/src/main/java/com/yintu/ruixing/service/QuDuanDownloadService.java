package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.QuDuanBaseEntity;
import com.yintu.ruixing.entity.QuDuanDownloadEntity;
import com.yintu.ruixing.entity.QuDuanInfoEntity;

import java.util.Date;
import java.util.List;

/**
 * @author:mlf
 * @date:2020/6/8 15:29
 */
public interface QuDuanDownloadService {

    void add(QuDuanDownloadEntity quDuanDownloadEntity);

    void remove(Integer id);

    void edit(Integer id);

    QuDuanDownloadEntity findById(Integer id);

    List<QuDuanDownloadEntity> findAll();

    List<QuDuanDownloadEntity> findByDateTime(Date startDateTime, Date endDateTime);


    List<QuDuanBaseEntity> findDataById(Integer id);

    void add(Integer xid, Integer cid, Short type, Date startDateTime, Integer minute);

}
