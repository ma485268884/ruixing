package com.yintu.ruixing.anzhuangtiaoshi;

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

    private Date wanchengpeixianPlanStartTime;

    private Date wanchengpeixianPlanEndTime;

    private Date wanchengpeixianActualStartTime;

    private Date wanchengpeixianActualEndTime;

    private Integer wanchengpeixianIsNo;

    private Date shangdiantiaojianPlanStartTime;

    private Date shangdiantiaojianPlanEndTime;

    private Date shangdiantiaojianActualStartTime;

    private Date shangdiantiaojianActualEndTime;

    private Integer shangdiantiaojianIsNo;

    private Date jingtaiyanshouPlanStartTime;

    private Date jingtaiyanshouPlanEndTime;

    private Date jingtaiyanshouActualStartTime;

    private Date jingtaiyanshouActualEndTime;

    private Integer jingtaiyanshouIsNo;

    private Date dongtaiyanshouPlanStartTime;

    private Date dongtaiyanshouPlanEndTime;

    private Date dongtaiyanshouActualStartTime;

    private Date dongtaiyanshouActualEndTime;

    private Integer dongtaiyanshouIsNo;

    private Date liantiaolianshiPlanStartTime;

    private Date liantiaolianshiPlanEndTime;

    private Date liantiaolianshiActualStartTime;

    private Date liantiaolianshiActualEndTime;

    private Integer liantiaolianshiIsNo;

    private Date shiyunxingPlanStartTime;

    private Date shiyunxingPlanEndTime;

    private Date shiyunxingActualStartTime;

    private Date shiyunxingActualEndTime;

    private Integer shiyunxingIsNo;

    private Date kaitongPlanStartTime;

    private Date kaitongPlanEndTime;

    private Date kaitongActualStartTime;

    private Date kaitongActualEndTime;

    private Integer kaitongIsNo;

    private Integer wanchengpeixianPlanToalTime;
    private Integer wanchengpeixianPlanOneTime;

    private Integer shangdiantiaojianPlanToalTime;
    private Integer shangdiantiaojianPlanOneTime;

    private Integer jingtaiyanshouPlanToalTime;
    private Integer jingtaiyanshouPlanOneTime;

    private Integer dongtaiyanshouPlanToalTime;
    private Integer dongtaiyanshouPlanOneTime;

    private Integer liantiaolianshiPlanToalTime;
    private Integer liantiaolianshiPlanOneTime;

    private Integer shiyunxingPlanToalTime;
    private Integer shiyunxingPlanOneTime;

    private Integer kaitongPlanToalTime;
    private Integer kaitongPlanOneTime;








/*
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

    public Date getWanchengpeixianPlanStartTime() {
        return wanchengpeixianPlanStartTime;
    }

    public void setWanchengpeixianPlanStartTime(Date wanchengpeixianPlanStartTime) {
        this.wanchengpeixianPlanStartTime = wanchengpeixianPlanStartTime;
    }

    public Date getWanchengpeixianPlanEndTime() {
        return wanchengpeixianPlanEndTime;
    }

    public void setWanchengpeixianPlanEndTime(Date wanchengpeixianPlanEndTime) {
        this.wanchengpeixianPlanEndTime = wanchengpeixianPlanEndTime;
    }

    public Date getWanchengpeixianActualStartTime() {
        return wanchengpeixianActualStartTime;
    }

    public void setWanchengpeixianActualStartTime(Date wanchengpeixianActualStartTime) {
        this.wanchengpeixianActualStartTime = wanchengpeixianActualStartTime;
    }

    public Date getWanchengpeixianActualEndTime() {
        return wanchengpeixianActualEndTime;
    }

    public void setWanchengpeixianActualEndTime(Date wanchengpeixianActualEndTime) {
        this.wanchengpeixianActualEndTime = wanchengpeixianActualEndTime;
    }

    public Integer getWanchengpeixianIsNo() {
        return wanchengpeixianIsNo;
    }

    public void setWanchengpeixianIsNo(Integer wanchengpeixianIsNo) {
        this.wanchengpeixianIsNo = wanchengpeixianIsNo;
    }

    public Date getShangdiantiaojianPlanStartTime() {
        return shangdiantiaojianPlanStartTime;
    }

    public void setShangdiantiaojianPlanStartTime(Date shangdiantiaojianPlanStartTime) {
        this.shangdiantiaojianPlanStartTime = shangdiantiaojianPlanStartTime;
    }

    public Date getShangdiantiaojianPlanEndTime() {
        return shangdiantiaojianPlanEndTime;
    }

    public void setShangdiantiaojianPlanEndTime(Date shangdiantiaojianPlanEndTime) {
        this.shangdiantiaojianPlanEndTime = shangdiantiaojianPlanEndTime;
    }

    public Date getShangdiantiaojianActualStartTime() {
        return shangdiantiaojianActualStartTime;
    }

    public void setShangdiantiaojianActualStartTime(Date shangdiantiaojianActualStartTime) {
        this.shangdiantiaojianActualStartTime = shangdiantiaojianActualStartTime;
    }

    public Date getShangdiantiaojianActualEndTime() {
        return shangdiantiaojianActualEndTime;
    }

    public void setShangdiantiaojianActualEndTime(Date shangdiantiaojianActualEndTime) {
        this.shangdiantiaojianActualEndTime = shangdiantiaojianActualEndTime;
    }

    public Integer getShangdiantiaojianIsNo() {
        return shangdiantiaojianIsNo;
    }

    public void setShangdiantiaojianIsNo(Integer shangdiantiaojianIsNo) {
        this.shangdiantiaojianIsNo = shangdiantiaojianIsNo;
    }

    public Date getJingtaiyanshouPlanStartTime() {
        return jingtaiyanshouPlanStartTime;
    }

    public void setJingtaiyanshouPlanStartTime(Date jingtaiyanshouPlanStartTime) {
        this.jingtaiyanshouPlanStartTime = jingtaiyanshouPlanStartTime;
    }

    public Date getJingtaiyanshouPlanEndTime() {
        return jingtaiyanshouPlanEndTime;
    }

    public void setJingtaiyanshouPlanEndTime(Date jingtaiyanshouPlanEndTime) {
        this.jingtaiyanshouPlanEndTime = jingtaiyanshouPlanEndTime;
    }

    public Date getJingtaiyanshouActualStartTime() {
        return jingtaiyanshouActualStartTime;
    }

    public void setJingtaiyanshouActualStartTime(Date jingtaiyanshouActualStartTime) {
        this.jingtaiyanshouActualStartTime = jingtaiyanshouActualStartTime;
    }

    public Date getJingtaiyanshouActualEndTime() {
        return jingtaiyanshouActualEndTime;
    }

    public void setJingtaiyanshouActualEndTime(Date jingtaiyanshouActualEndTime) {
        this.jingtaiyanshouActualEndTime = jingtaiyanshouActualEndTime;
    }

    public Integer getJingtaiyanshouIsNo() {
        return jingtaiyanshouIsNo;
    }

    public void setJingtaiyanshouIsNo(Integer jingtaiyanshouIsNo) {
        this.jingtaiyanshouIsNo = jingtaiyanshouIsNo;
    }

    public Date getDongtaiyanshouPlanStartTime() {
        return dongtaiyanshouPlanStartTime;
    }

    public void setDongtaiyanshouPlanStartTime(Date dongtaiyanshouPlanStartTime) {
        this.dongtaiyanshouPlanStartTime = dongtaiyanshouPlanStartTime;
    }

    public Date getDongtaiyanshouPlanEndTime() {
        return dongtaiyanshouPlanEndTime;
    }

    public void setDongtaiyanshouPlanEndTime(Date dongtaiyanshouPlanEndTime) {
        this.dongtaiyanshouPlanEndTime = dongtaiyanshouPlanEndTime;
    }

    public Date getDongtaiyanshouActualStartTime() {
        return dongtaiyanshouActualStartTime;
    }

    public void setDongtaiyanshouActualStartTime(Date dongtaiyanshouActualStartTime) {
        this.dongtaiyanshouActualStartTime = dongtaiyanshouActualStartTime;
    }

    public Date getDongtaiyanshouActualEndTime() {
        return dongtaiyanshouActualEndTime;
    }

    public void setDongtaiyanshouActualEndTime(Date dongtaiyanshouActualEndTime) {
        this.dongtaiyanshouActualEndTime = dongtaiyanshouActualEndTime;
    }

    public Integer getDongtaiyanshouIsNo() {
        return dongtaiyanshouIsNo;
    }

    public void setDongtaiyanshouIsNo(Integer dongtaiyanshouIsNo) {
        this.dongtaiyanshouIsNo = dongtaiyanshouIsNo;
    }

    public Date getLiantiaolianshiPlanStartTime() {
        return liantiaolianshiPlanStartTime;
    }

    public void setLiantiaolianshiPlanStartTime(Date liantiaolianshiPlanStartTime) {
        this.liantiaolianshiPlanStartTime = liantiaolianshiPlanStartTime;
    }

    public Date getLiantiaolianshiPlanEndTime() {
        return liantiaolianshiPlanEndTime;
    }

    public void setLiantiaolianshiPlanEndTime(Date liantiaolianshiPlanEndTime) {
        this.liantiaolianshiPlanEndTime = liantiaolianshiPlanEndTime;
    }

    public Date getLiantiaolianshiActualStartTime() {
        return liantiaolianshiActualStartTime;
    }

    public void setLiantiaolianshiActualStartTime(Date liantiaolianshiActualStartTime) {
        this.liantiaolianshiActualStartTime = liantiaolianshiActualStartTime;
    }

    public Date getLiantiaolianshiActualEndTime() {
        return liantiaolianshiActualEndTime;
    }

    public void setLiantiaolianshiActualEndTime(Date liantiaolianshiActualEndTime) {
        this.liantiaolianshiActualEndTime = liantiaolianshiActualEndTime;
    }

    public Integer getLiantiaolianshiIsNo() {
        return liantiaolianshiIsNo;
    }

    public void setLiantiaolianshiIsNo(Integer liantiaolianshiIsNo) {
        this.liantiaolianshiIsNo = liantiaolianshiIsNo;
    }

    public Date getShiyunxingPlanStartTime() {
        return shiyunxingPlanStartTime;
    }

    public void setShiyunxingPlanStartTime(Date shiyunxingPlanStartTime) {
        this.shiyunxingPlanStartTime = shiyunxingPlanStartTime;
    }

    public Date getShiyunxingPlanEndTime() {
        return shiyunxingPlanEndTime;
    }

    public void setShiyunxingPlanEndTime(Date shiyunxingPlanEndTime) {
        this.shiyunxingPlanEndTime = shiyunxingPlanEndTime;
    }

    public Date getShiyunxingActualStartTime() {
        return shiyunxingActualStartTime;
    }

    public void setShiyunxingActualStartTime(Date shiyunxingActualStartTime) {
        this.shiyunxingActualStartTime = shiyunxingActualStartTime;
    }

    public Date getShiyunxingActualEndTime() {
        return shiyunxingActualEndTime;
    }

    public void setShiyunxingActualEndTime(Date shiyunxingActualEndTime) {
        this.shiyunxingActualEndTime = shiyunxingActualEndTime;
    }

    public Integer getShiyunxingIsNo() {
        return shiyunxingIsNo;
    }

    public void setShiyunxingIsNo(Integer shiyunxingIsNo) {
        this.shiyunxingIsNo = shiyunxingIsNo;
    }

    public Date getKaitongPlanStartTime() {
        return kaitongPlanStartTime;
    }

    public void setKaitongPlanStartTime(Date kaitongPlanStartTime) {
        this.kaitongPlanStartTime = kaitongPlanStartTime;
    }

    public Date getKaitongPlanEndTime() {
        return kaitongPlanEndTime;
    }

    public void setKaitongPlanEndTime(Date kaitongPlanEndTime) {
        this.kaitongPlanEndTime = kaitongPlanEndTime;
    }

    public Date getKaitongActualStartTime() {
        return kaitongActualStartTime;
    }

    public void setKaitongActualStartTime(Date kaitongActualStartTime) {
        this.kaitongActualStartTime = kaitongActualStartTime;
    }

    public Date getKaitongActualEndTime() {
        return kaitongActualEndTime;
    }

    public void setKaitongActualEndTime(Date kaitongActualEndTime) {
        this.kaitongActualEndTime = kaitongActualEndTime;
    }

    public Integer getKaitongIsNo() {
        return kaitongIsNo;
    }

    public void setKaitongIsNo(Integer kaitongIsNo) {
        this.kaitongIsNo = kaitongIsNo;
    }*/
}