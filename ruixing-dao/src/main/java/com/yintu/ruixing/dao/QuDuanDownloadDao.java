package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.QuDuanDownloadEntity;

import java.util.Date;
import java.util.List;

public interface QuDuanDownloadDao {
    int deleteByPrimaryKey(Integer id);

    int insert(QuDuanDownloadEntity record);

    int insertSelective(QuDuanDownloadEntity record);

    QuDuanDownloadEntity selectByPrimaryKey(Integer id);

    List<QuDuanDownloadEntity> selectByDateTime(Date startDateTime, Date endDateTime);

    int updateByPrimaryKeySelective(QuDuanDownloadEntity record);

    int updateByPrimaryKey(QuDuanDownloadEntity record);

    QuDuanDownloadEntity selectByCidAndDataType(Integer cid, Short dataType);
}