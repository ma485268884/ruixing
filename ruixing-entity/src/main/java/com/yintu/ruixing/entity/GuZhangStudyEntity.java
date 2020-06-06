package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * * @author:lcy
 *  * @date:2020-05-29 20
 *  故障学习实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuZhangStudyEntity {
    private Integer id;

    private Date guzhangjiluTime;

    private String guzhangjiluName;

    private String guzhangType;

    private String guzhangmiaoshu;

    private Integer cid;

    private String guzhangChezhan;

    private Integer xid;

    private String guzhangXianduan;

    private Integer qid;

    private String guzhangQuduan;

    private Date guzhangStartTime;

    private Date zhengchangTime;

    private String shenjingwangluoCode;

    private Integer shiwaiData;

    private Integer qianfangquduanData;

    private Integer houfangquduanData;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getGuzhangjiluTime() {
        return guzhangjiluTime;
    }

    public void setGuzhangjiluTime(Date guzhangjiluTime) {
        this.guzhangjiluTime = guzhangjiluTime;
    }

    public String getGuzhangjiluName() {
        return guzhangjiluName;
    }

    public void setGuzhangjiluName(String guzhangjiluName) {
        this.guzhangjiluName = guzhangjiluName == null ? null : guzhangjiluName.trim();
    }

    public String getGuzhangType() {
        return guzhangType;
    }

    public void setGuzhangType(String guzhangType) {
        this.guzhangType = guzhangType == null ? null : guzhangType.trim();
    }

    public String getGuzhangmiaoshu() {
        return guzhangmiaoshu;
    }

    public void setGuzhangmiaoshu(String guzhangmiaoshu) {
        this.guzhangmiaoshu = guzhangmiaoshu == null ? null : guzhangmiaoshu.trim();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getGuzhangChezhan() {
        return guzhangChezhan;
    }

    public void setGuzhangChezhan(String guzhangChezhan) {
        this.guzhangChezhan = guzhangChezhan == null ? null : guzhangChezhan.trim();
    }

    public Integer getXid() {
        return xid;
    }

    public void setXid(Integer xid) {
        this.xid = xid;
    }

    public String getGuzhangXianduan() {
        return guzhangXianduan;
    }

    public void setGuzhangXianduan(String guzhangXianduan) {
        this.guzhangXianduan = guzhangXianduan == null ? null : guzhangXianduan.trim();
    }

    public Date getGuzhangStartTime() {
        return guzhangStartTime;
    }

    public void setGuzhangStartTime(Date guzhangStartTime) {
        this.guzhangStartTime = guzhangStartTime;
    }

    public Date getZhengchangTime() {
        return zhengchangTime;
    }

    public void setZhengchangTime(Date zhengchangTime) {
        this.zhengchangTime = zhengchangTime;
    }

    public String getShenjingwangluoCode() {
        return shenjingwangluoCode;
    }

    public void setShenjingwangluoCode(String shenjingwangluoCode) {
        this.shenjingwangluoCode = shenjingwangluoCode == null ? null : shenjingwangluoCode.trim();
    }

    public Integer getShiwaiData() {
        return shiwaiData;
    }

    public void setShiwaiData(Integer shiwaiData) {
        this.shiwaiData = shiwaiData;
    }

    public Integer getQianfangquduanData() {
        return qianfangquduanData;
    }

    public void setQianfangquduanData(Integer qianfangquduanData) {
        this.qianfangquduanData = qianfangquduanData;
    }

    public Integer getHoufangquduanData() {
        return houfangquduanData;
    }

    public void setHoufangquduanData(Integer houfangquduanData) {
        this.houfangquduanData = houfangquduanData;
    }
}