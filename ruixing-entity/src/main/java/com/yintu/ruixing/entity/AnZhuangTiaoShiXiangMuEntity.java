package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnZhuangTiaoShiXiangMuEntity {

    private Integer id;

    private Date xianduantime;//线段创建的时间

    private String tljName;//铁路局名

    private String dwdName;//电务段名

    private String xdName;//线段名

    private String xdType;//项目类型

    private Integer xdFenlei;//线段状态 1：正在进行 ，2：已完成，3：长期停滞

    private String guanlianxiangmu;//关联项目名和编号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getXianduantime() {
        return xianduantime;
    }

    public void setXianduantime(Date xianduantime) {
        this.xianduantime = xianduantime;
    }

    public String getTljName() {
        return tljName;
    }

    public void setTljName(String tljName) {
        this.tljName = tljName == null ? null : tljName.trim();
    }

    public String getDwdName() {
        return dwdName;
    }

    public void setDwdName(String dwdName) {
        this.dwdName = dwdName == null ? null : dwdName.trim();
    }

    public String getXdName() {
        return xdName;
    }

    public void setXdName(String xdName) {
        this.xdName = xdName == null ? null : xdName.trim();
    }

    public String getXdType() {
        return xdType;
    }

    public void setXdType(String xdType) {
        this.xdType = xdType == null ? null : xdType.trim();
    }

    public Integer getXdFenlei() {
        return xdFenlei;
    }

    public void setXdFenlei(Integer xdFenlei) {
        this.xdFenlei = xdFenlei;
    }

    public String getGuanlianxiangmu() {
        return guanlianxiangmu;
    }

    public void setGuanlianxiangmu(String guanlianxiangmu) {
        this.guanlianxiangmu = guanlianxiangmu == null ? null : guanlianxiangmu.trim();
    }
}