package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnZhuangTiaoShiTrainEntity {
    private Integer id;

    private String xdName;

    private String customer;

    private String traintype;

    private String traincontent;

    private String trainmode;

    private String trainaddress;

    private Date trainstarttime;

    private Date trainendtime;

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

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer == null ? null : customer.trim();
    }

    public String getTraintype() {
        return traintype;
    }

    public void setTraintype(String traintype) {
        this.traintype = traintype == null ? null : traintype.trim();
    }

    public String getTraincontent() {
        return traincontent;
    }

    public void setTraincontent(String traincontent) {
        this.traincontent = traincontent == null ? null : traincontent.trim();
    }

    public String getTrainmode() {
        return trainmode;
    }

    public void setTrainmode(String trainmode) {
        this.trainmode = trainmode == null ? null : trainmode.trim();
    }

    public String getTrainaddress() {
        return trainaddress;
    }

    public void setTrainaddress(String trainaddress) {
        this.trainaddress = trainaddress == null ? null : trainaddress.trim();
    }

    public Date getTrainstarttime() {
        return trainstarttime;
    }

    public void setTrainstarttime(Date trainstarttime) {
        this.trainstarttime = trainstarttime;
    }

    public Date getTrainendtime() {
        return trainendtime;
    }

    public void setTrainendtime(Date trainendtime) {
        this.trainendtime = trainendtime;
    }

    public String getYuliu() {
        return yuliu;
    }

    public void setYuliu(String yuliu) {
        this.yuliu = yuliu == null ? null : yuliu.trim();
    }
}