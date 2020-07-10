package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaintenancePlanInfoEntity implements Serializable {
    private static final long serialVersionUID = 4786248300945836138L;
    private Integer id;
    @NotEmpty
    private String work;
    @NotEmpty
    private String period;
    @NotEmpty
    private String result;
    @NotNull
    private Integer maintenancePlanId;

    private Date createdDate;

    private MaintenancePlanEntity maintenancePlanEntity;


}