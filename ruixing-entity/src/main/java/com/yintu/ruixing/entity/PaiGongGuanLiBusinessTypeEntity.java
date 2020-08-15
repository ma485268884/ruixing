package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaiGongGuanLiBusinessTypeEntity {
    private Integer id;

    private String businesstype;

    private String chuchaitask;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusinesstype() {
        return businesstype;
    }

    public void setBusinesstype(String businesstype) {
        this.businesstype = businesstype == null ? null : businesstype.trim();
    }

    public String getChuchaitask() {
        return chuchaitask;
    }

    public void setChuchaitask(String chuchaitask) {
        this.chuchaitask = chuchaitask == null ? null : chuchaitask.trim();
    }
}