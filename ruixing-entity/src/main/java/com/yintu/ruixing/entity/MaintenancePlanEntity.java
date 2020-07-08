package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaintenancePlanEntity implements Serializable {
    private static final long serialVersionUID = -5292802390217821441L;
    private Integer id;
    @NotEmpty
    private String name;

    private Date createdDate;

}