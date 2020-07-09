package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaintenancePlanInfoEntity implements Serializable {
    private static final long serialVersionUID = 4786248300945836138L;
    private Integer id;

    private String work;

    private String period;

    private String result;

    private Integer maintenancePlanId;

    private Date createdData;


}