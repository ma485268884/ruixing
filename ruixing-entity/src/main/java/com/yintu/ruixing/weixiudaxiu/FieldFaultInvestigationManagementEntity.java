package com.yintu.ruixing.weixiudaxiu;

import com.yintu.ruixing.guzhangzhenduan.CheZhanEntity;
import com.yintu.ruixing.guzhangzhenduan.DianWuDuanEntity;
import com.yintu.ruixing.guzhangzhenduan.TieLuJuEntity;
import com.yintu.ruixing.guzhangzhenduan.XianDuanEntity;
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
public class FieldFaultInvestigationManagementEntity implements Serializable {
    private static final long serialVersionUID = 4011258509695261324L;

    private Integer id;
    @NotNull
    private Integer tielujuId;
    @NotNull
    private Integer dianwuduanId;
    @NotNull
    private Integer xianduanId;
    @NotNull
    private Integer chezhanId;
    @NotBlank
    private String documentationPath;
    @NotBlank
    private String documentationName;
    @NotBlank
    private String engineeringReportPath;
    @NotBlank
    private String engineeringReportName;
    @NotNull
    private Date startDate;
    @NotNull
    private Date endDate;

    private TieLuJuEntity tieLuJuEntity;

    private DianWuDuanEntity dianWuDuanEntity;

    private XianDuanEntity xianDuanEntity;

    private CheZhanEntity cheZhanEntity;


}