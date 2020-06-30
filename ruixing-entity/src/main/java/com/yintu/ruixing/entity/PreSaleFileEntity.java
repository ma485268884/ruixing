package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreSaleFileEntity implements Serializable {

    private static final long serialVersionUID = 4390673348528177851L;
    
    private Integer id;

    private String name;

    private String path;

    private Date uploadDatetime;

    private Short type;

    private Integer auditorId;

    private Integer preSaleId;

}