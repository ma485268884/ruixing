package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistrictEntity implements Serializable {
    private static final long serialVersionUID = -6073611496338887428L;

    private Integer id;

    private String name;

    private Integer parentId;

    private String abbreviationName;

    private Short level;

    private String code;

    private String postalServiceCode;

    private String combinationName;

    private Float longitude;

    private Float latitude;

    private String pinyin;


}