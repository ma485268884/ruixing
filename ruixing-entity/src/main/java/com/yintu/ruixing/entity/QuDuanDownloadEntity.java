package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuDuanDownloadEntity implements Serializable {
    private static final long serialVersionUID = 2346042164264973184L;
    private Integer id;

    private Integer tid;

    private Integer did;

    private Integer xid;

    private Integer cid;

    private Integer sid;

    private Date startTime;

    private Date endTime;

    private Short status;

    private Short type;

    private String data;

    private CheZhanEntity cheZhanEntity;
}