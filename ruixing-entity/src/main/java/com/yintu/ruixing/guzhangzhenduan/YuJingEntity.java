package com.yintu.ruixing.guzhangzhenduan;

import java.util.Date;

public class YuJingEntity {
    private Integer id;

    private String bjQuduandaihao;

    private String bjGuzhangdengji;

    private Date bjTime;

    private Date bjHuifuTime;

    private String bjMessage;

    private Integer bjStatus;

    private Integer bjGzStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBjQuduandaihao() {
        return bjQuduandaihao;
    }

    public void setBjQuduandaihao(String bjQuduandaihao) {
        this.bjQuduandaihao = bjQuduandaihao == null ? null : bjQuduandaihao.trim();
    }

    public String getBjGuzhangdengji() {
        return bjGuzhangdengji;
    }

    public void setBjGuzhangdengji(String bjGuzhangdengji) {
        this.bjGuzhangdengji = bjGuzhangdengji == null ? null : bjGuzhangdengji.trim();
    }

    public Date getBjTime() {
        return bjTime;
    }

    public void setBjTime(Date bjTime) {
        this.bjTime = bjTime;
    }

    public Date getBjHuifuTime() {
        return bjHuifuTime;
    }

    public void setBjHuifuTime(Date bjHuifuTime) {
        this.bjHuifuTime = bjHuifuTime;
    }

    public String getBjMessage() {
        return bjMessage;
    }

    public void setBjMessage(String bjMessage) {
        this.bjMessage = bjMessage == null ? null : bjMessage.trim();
    }

    public Integer getBjStatus() {
        return bjStatus;
    }

    public void setBjStatus(Integer bjStatus) {
        this.bjStatus = bjStatus;
    }

    public Integer getBjGzStatus() {
        return bjGzStatus;
    }

    public void setBjGzStatus(Integer bjGzStatus) {
        this.bjGzStatus = bjGzStatus;
    }
}