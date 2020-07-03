package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


/**
 * 投招标技术支持 项目实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BiddingEntity implements Serializable {
    private static final long serialVersionUID = 5743348273904345051L;
    private Integer id;

    private String projectName;

    private Short projectStatus;

    private Date projectDate;

    private Short taskStatus;

    private Date taskFinishDate;

    private String bidder;

    private Integer railwayAdministrationId;

    private Integer preSaleId;


}