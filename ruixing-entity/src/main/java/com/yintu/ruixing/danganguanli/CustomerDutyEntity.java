package com.yintu.ruixing.danganguanli;

import com.yintu.ruixing.xitongguanli.DepartmentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDutyEntity implements Serializable {
    private static final long serialVersionUID = 913100906419871766L;
    private Long id;

    private String createBy;

    private Date createTime;

    private String modifiedBy;

    private Date modifiedTime;
    @NotBlank
    @Length(min = 1, max = 50)
    private String name;
    @NotNull
    private Long customerUnitsId;

    private CustomerUnitsEntity customerUnitsEntity;

    private List<DepartmentEntity> departmentEntities;


}