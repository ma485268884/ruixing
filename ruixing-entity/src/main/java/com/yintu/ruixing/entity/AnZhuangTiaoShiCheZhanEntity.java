package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnZhuangTiaoShiCheZhanEntity {
    private Integer id;

    private Integer xid;

    private Date czTime;

    private String tljName;

    private String dwdName;

    private String xdName;

    private String czName;

    private String guanlianxiangmu;

    private String czType;

    private Integer jigui;

    private Integer indoorkaban;

    private Integer outdoorshebei;

    private Date wanchengpeixianPlanTime;

    private Date wanchengpeixianActualTime;

    private Integer wanchengpeixianIsNo;

    private Date shangdiantiaojianPlanTime;

    private Date shangdiantiaojianActualTime;

    private Integer shangdiantiaojianIsNo;

    private Date jingtaiyanshouPlanTime;

    private Date jingtaiyanshouActualTime;

    private Integer jingtaiyanshouIsNo;

    private Date dongtaiyanshouPlanTime;

    private Date dongtaiyanshouActualTime;

    private Integer dongtaiyanshouIsNo;

    private Date liantiaolianshiPlanTime;

    private Date liantiaolianshiActualTime;

    private Integer liantiaolianshiIsNo;

    private Date shiyunxingPlanTime;

    private Date shiyunxingActualTime;

    private Integer shiyunxingIsNo;

    private Date kaitongPlanTime;

    private Date kaitongActualTime;

    private Integer kaitongIsNo;

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

    public Date getCzTime() {
        return czTime;
    }

    public void setCzTime(Date czTime) {
        this.czTime = czTime;
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

    public String getGuanlianxiangmu() {
        return guanlianxiangmu;
    }

    public void setGuanlianxiangmu(String guanlianxiangmu) {
        this.guanlianxiangmu = guanlianxiangmu == null ? null : guanlianxiangmu.trim();
    }

    public String getCzType() {
        return czType;
    }

    public void setCzType(String czType) {
        this.czType = czType == null ? null : czType.trim();
    }

    public Integer getJigui() {
        return jigui;
    }

    public void setJigui(Integer jigui) {
        this.jigui = jigui;
    }

    public Integer getIndoorkaban() {
        return indoorkaban;
    }

    public void setIndoorkaban(Integer indoorkaban) {
        this.indoorkaban = indoorkaban;
    }

    public Integer getOutdoorshebei() {
        return outdoorshebei;
    }

    public void setOutdoorshebei(Integer outdoorshebei) {
        this.outdoorshebei = outdoorshebei;
    }

    public Date getWanchengpeixianPlanTime() {
        return wanchengpeixianPlanTime;
    }

    public void setWanchengpeixianPlanTime(Date wanchengpeixianPlanTime) {
        this.wanchengpeixianPlanTime = wanchengpeixianPlanTime;
    }

    public Date getWanchengpeixianActualTime() {
        return wanchengpeixianActualTime;
    }

    public void setWanchengpeixianActualTime(Date wanchengpeixianActualTime) {
        this.wanchengpeixianActualTime = wanchengpeixianActualTime;
    }

    public Integer getWanchengpeixianIsNo() {
        return wanchengpeixianIsNo;
    }

    public void setWanchengpeixianIsNo(Integer wanchengpeixianIsNo) {
        this.wanchengpeixianIsNo = wanchengpeixianIsNo;
    }

    public Date getShangdiantiaojianPlanTime() {
        return shangdiantiaojianPlanTime;
    }

    public void setShangdiantiaojianPlanTime(Date shangdiantiaojianPlanTime) {
        this.shangdiantiaojianPlanTime = shangdiantiaojianPlanTime;
    }

    public Date getShangdiantiaojianActualTime() {
        return shangdiantiaojianActualTime;
    }

    public void setShangdiantiaojianActualTime(Date shangdiantiaojianActualTime) {
        this.shangdiantiaojianActualTime = shangdiantiaojianActualTime;
    }

    public Integer getShangdiantiaojianIsNo() {
        return shangdiantiaojianIsNo;
    }

    public void setShangdiantiaojianIsNo(Integer shangdiantiaojianIsNo) {
        this.shangdiantiaojianIsNo = shangdiantiaojianIsNo;
    }

    public Date getJingtaiyanshouPlanTime() {
        return jingtaiyanshouPlanTime;
    }

    public void setJingtaiyanshouPlanTime(Date jingtaiyanshouPlanTime) {
        this.jingtaiyanshouPlanTime = jingtaiyanshouPlanTime;
    }

    public Date getJingtaiyanshouActualTime() {
        return jingtaiyanshouActualTime;
    }

    public void setJingtaiyanshouActualTime(Date jingtaiyanshouActualTime) {
        this.jingtaiyanshouActualTime = jingtaiyanshouActualTime;
    }

    public Integer getJingtaiyanshouIsNo() {
        return jingtaiyanshouIsNo;
    }

    public void setJingtaiyanshouIsNo(Integer jingtaiyanshouIsNo) {
        this.jingtaiyanshouIsNo = jingtaiyanshouIsNo;
    }

    public Date getDongtaiyanshouPlanTime() {
        return dongtaiyanshouPlanTime;
    }

    public void setDongtaiyanshouPlanTime(Date dongtaiyanshouPlanTime) {
        this.dongtaiyanshouPlanTime = dongtaiyanshouPlanTime;
    }

    public Date getDongtaiyanshouActualTime() {
        return dongtaiyanshouActualTime;
    }

    public void setDongtaiyanshouActualTime(Date dongtaiyanshouActualTime) {
        this.dongtaiyanshouActualTime = dongtaiyanshouActualTime;
    }

    public Integer getDongtaiyanshouIsNo() {
        return dongtaiyanshouIsNo;
    }

    public void setDongtaiyanshouIsNo(Integer dongtaiyanshouIsNo) {
        this.dongtaiyanshouIsNo = dongtaiyanshouIsNo;
    }

    public Date getLiantiaolianshiPlanTime() {
        return liantiaolianshiPlanTime;
    }

    public void setLiantiaolianshiPlanTime(Date liantiaolianshiPlanTime) {
        this.liantiaolianshiPlanTime = liantiaolianshiPlanTime;
    }

    public Date getLiantiaolianshiActualTime() {
        return liantiaolianshiActualTime;
    }

    public void setLiantiaolianshiActualTime(Date liantiaolianshiActualTime) {
        this.liantiaolianshiActualTime = liantiaolianshiActualTime;
    }

    public Integer getLiantiaolianshiIsNo() {
        return liantiaolianshiIsNo;
    }

    public void setLiantiaolianshiIsNo(Integer liantiaolianshiIsNo) {
        this.liantiaolianshiIsNo = liantiaolianshiIsNo;
    }

    public Date getShiyunxingPlanTime() {
        return shiyunxingPlanTime;
    }

    public void setShiyunxingPlanTime(Date shiyunxingPlanTime) {
        this.shiyunxingPlanTime = shiyunxingPlanTime;
    }

    public Date getShiyunxingActualTime() {
        return shiyunxingActualTime;
    }

    public void setShiyunxingActualTime(Date shiyunxingActualTime) {
        this.shiyunxingActualTime = shiyunxingActualTime;
    }

    public Integer getShiyunxingIsNo() {
        return shiyunxingIsNo;
    }

    public void setShiyunxingIsNo(Integer shiyunxingIsNo) {
        this.shiyunxingIsNo = shiyunxingIsNo;
    }

    public Date getKaitongPlanTime() {
        return kaitongPlanTime;
    }

    public void setKaitongPlanTime(Date kaitongPlanTime) {
        this.kaitongPlanTime = kaitongPlanTime;
    }

    public Date getKaitongActualTime() {
        return kaitongActualTime;
    }

    public void setKaitongActualTime(Date kaitongActualTime) {
        this.kaitongActualTime = kaitongActualTime;
    }

    public Integer getKaitongIsNo() {
        return kaitongIsNo;
    }

    public void setKaitongIsNo(Integer kaitongIsNo) {
        this.kaitongIsNo = kaitongIsNo;
    }
}