package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.Date;

/**
 * 售前技术支持 项目实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreSaleEntity implements Serializable {

    private static final long serialVersionUID = -2897918675790939966L;

    private Integer id;
    @NotEmpty
    private String projectName;
    @NotNull
    private Short projectStatus;
    @NotNull
    private Date projectDate;
    @NotNull
    private Short taskStatus;

    private Date taskFinishDate;


}