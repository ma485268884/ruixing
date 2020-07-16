package com.yintu.ruixing.entity;

public class AnZhuangTiaoShiWorkNameLibraryEntity {
    private Integer id;

    private String workname;

    private String yuliu1;

    private String yuliu2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkname() {
        return workname;
    }

    public void setWorkname(String workname) {
        this.workname = workname == null ? null : workname.trim();
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