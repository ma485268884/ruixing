package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnZhuangTiaoShiWenTiEntity {
    private Integer id;

    private String xdName;

    private String wentiMiaoshu;

    private String fankuiMode;

    private String shoulidanwei;

    private String shejifanwei;

    private Date askovertime;

    private String cuoshifangan;

    private String customerMessage;

    private String shishiplan;

    private Date actualovertime;

    private Integer wentiisover;

    private Integer wentistate;

    private String yuliu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getXdName() {
        return xdName;
    }

    public void setXdName(String xdName) {
        this.xdName = xdName == null ? null : xdName.trim();
    }

    public String getWentiMiaoshu() {
        return wentiMiaoshu;
    }

    public void setWentiMiaoshu(String wentiMiaoshu) {
        this.wentiMiaoshu = wentiMiaoshu == null ? null : wentiMiaoshu.trim();
    }

    public String getFankuiMode() {
        return fankuiMode;
    }

    public void setFankuiMode(String fankuiMode) {
        this.fankuiMode = fankuiMode == null ? null : fankuiMode.trim();
    }

    public String getShoulidanwei() {
        return shoulidanwei;
    }

    public void setShoulidanwei(String shoulidanwei) {
        this.shoulidanwei = shoulidanwei == null ? null : shoulidanwei.trim();
    }

    public String getShejifanwei() {
        return shejifanwei;
    }

    public void setShejifanwei(String shejifanwei) {
        this.shejifanwei = shejifanwei == null ? null : shejifanwei.trim();
    }

    public Date getAskovertime() {
        return askovertime;
    }

    public void setAskovertime(Date askovertime) {
        this.askovertime = askovertime;
    }

    public String getCuoshifangan() {
        return cuoshifangan;
    }

    public void setCuoshifangan(String cuoshifangan) {
        this.cuoshifangan = cuoshifangan == null ? null : cuoshifangan.trim();
    }

    public String getCustomerMessage() {
        return customerMessage;
    }

    public void setCustomerMessage(String customerMessage) {
        this.customerMessage = customerMessage == null ? null : customerMessage.trim();
    }

    public String getShishiplan() {
        return shishiplan;
    }

    public void setShishiplan(String shishiplan) {
        this.shishiplan = shishiplan == null ? null : shishiplan.trim();
    }

    public Date getActualovertime() {
        return actualovertime;
    }

    public void setActualovertime(Date actualovertime) {
        this.actualovertime = actualovertime;
    }

    public Integer getWentiisover() {
        return wentiisover;
    }

    public void setWentiisover(Integer wentiisover) {
        this.wentiisover = wentiisover;
    }

    public Integer getWentistate() {
        return wentistate;
    }

    public void setWentistate(Integer wentistate) {
        this.wentistate = wentistate;
    }

    public String getYuliu() {
        return yuliu;
    }

    public void setYuliu(String yuliu) {
        this.yuliu = yuliu == null ? null : yuliu.trim();
    }
}