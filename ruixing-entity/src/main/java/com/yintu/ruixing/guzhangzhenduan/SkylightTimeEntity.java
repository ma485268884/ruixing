package com.yintu.ruixing.guzhangzhenduan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkylightTimeEntity implements Serializable {
    private static final long serialVersionUID = -3359494799798925690L;
    private Integer id;

    private String createBy;

    private Date createTime;

    private String modifiedBy;

    private Date modifiedTime;
    @NotNull
    private Date startTime;
    @NotNull
    private Date endTime;
    @NotNull
    private Integer czId;

    private Integer qdId;

    private CheZhanEntity cheZhanEntity;

    private QuDuanBaseEntity quDuanBaseEntity;


}