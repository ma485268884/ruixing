package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


/**
 * 投招标技术支持 项目文件实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BiddingFileEntity implements Serializable {
    private static final long serialVersionUID = -2896894795077610716L;
    private Integer id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String path;

    private Date uploadDatetime;
    @NotNull
    private Short type;
    @NotNull
    private Short releaseStatus;

    private Integer auditorId;
    @NotNull
    private Integer biddingId;

    private BiddingEntity biddingEntity;


}