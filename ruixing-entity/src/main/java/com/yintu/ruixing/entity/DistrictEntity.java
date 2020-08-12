package com.yintu.ruixing.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @JSONField(serialize = false)
    private Integer parentId;
    @JsonIgnore
    @JSONField(serialize = false)
    private String abbreviationName;
    @JsonIgnore
    @JSONField(serialize = false)
    private Short level;
    @JsonIgnore
    @JSONField(serialize = false)
    private String code;
    @JsonIgnore
    @JSONField(serialize = false)
    private String postalServiceCode;
    @JsonIgnore
    @JSONField(serialize = false)
    private String combinationName;
    @JsonIgnore
    @JSONField(serialize = false)
    private Float longitude;
    @JsonIgnore
    @JSONField(serialize = false)
    private Float latitude;
    @JsonIgnore
    @JSONField(serialize = false)
    private String pinyin;


}