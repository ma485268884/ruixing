package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerUnitsEntity implements Serializable {
    private static final long serialVersionUID = 4122923342722134486L;
    private Integer id;
    @NotNull
    private Short category;
    @NotBlank
    private String name;

    private Date createTime;


}