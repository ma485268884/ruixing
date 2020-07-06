package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;

/**
 * 售前技术支持 项目文件实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreSaleFileEntity implements Serializable {

    private static final long serialVersionUID = 4390673348528177851L;

    private Integer id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String path;

    private Date uploadDatetime;
    @NotNull
    private Short type;

    private Short releaseStatus;

    private Integer auditorId;
    @NotNull
    private Integer preSaleId;

    private PreSaleEntity preSaleEntity;

}