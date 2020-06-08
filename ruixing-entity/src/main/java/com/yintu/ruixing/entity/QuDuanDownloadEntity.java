package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuDuanDownloadEntity {
    private Integer id;

    private Integer xid;

    private Integer cid;

    private Date startTime;

    private Date endTime;

    private Short status;

    private Short type;

    private String data;

    private CheZhanEntity cheZhanEntity;
}