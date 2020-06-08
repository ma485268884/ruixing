package com.yintu.ruixing.service;

import com.yintu.ruixing.entity.QuDuanDownloadEntity;

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

    void add(Integer xid, Integer cid, Date date, Integer minute);

}
