package com.yintu.ruixing.weixiudaxiu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentEntity implements Serializable {

    private static final long serialVersionUID = -1641369816196966654L;

    private Integer id;

    private String name;

    private Date createdTime;

}