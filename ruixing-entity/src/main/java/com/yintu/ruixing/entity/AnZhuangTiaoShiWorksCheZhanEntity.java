package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnZhuangTiaoShiWorksCheZhanEntity {
    private Integer id;

    private Integer xid;

    private Date createtime;

    private String tljName;

    private String dwdName;

    private String xdName;

    private String czName;

    private String czType;

    private Integer czXiangmuVersion;

    private String yuliu1;

    private String yuliu2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getXid() {
        return xid;
    }

    public void setXid(Integer xid) {
        this.xid = xid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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

    public String getCzName() {
        return czName;
    }

    public void setCzName(String czName) {
        this.czName = czName == null ? null : czName.trim();
    }

    public String getCzType() {
        return czType;
    }

    public void setCzType(String czType) {
        this.czType = czType == null ? null : czType.trim();
    }

    public Integer getCzXiangmuVersion() {
        return czXiangmuVersion;
    }

    public void setCzXiangmuVersion(Integer czXiangmuVersion) {
        this.czXiangmuVersion = czXiangmuVersion;
    }

    public String getYuliu1() {
        return yuliu1;
    }

    public void setYuliu1(String yuliu1) {
        this.yuliu1 = yuliu1 == null ? null : yuliu1.trim();
    }

    public String getYuliu2() {
        return yuliu2;
    }

    public void setYuliu2(String yuliu2) {
        this.yuliu2 = yuliu2 == null ? null : yuliu2.trim();
    }
}