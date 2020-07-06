package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
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
    @Past
    private Date projectDate;
    @NotNull
    private Short taskStatus;

    private Date taskFinishDate;


}