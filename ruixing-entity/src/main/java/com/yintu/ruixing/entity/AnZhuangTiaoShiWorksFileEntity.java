package com.yintu.ruixing.entity;

import java.util.Date;

public class AnZhuangTiaoShiWorksFileEntity {
    private Integer id;

    private Integer xdid;

    private String xdName;

    private Date createtime;

    private Integer fileType;

    private String fileName;

    private String filePath;

    private Integer fabuType;

    private String yuliu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getXdid() {
        return xdid;
    }

    public void setXdid(Integer xdid) {
        this.xdid = xdid;
    }

    public String getXdName() {
        return xdName;
    }

    public void setXdName(String xdName) {
        this.xdName = xdName == null ? null : xdName.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public Integer getFabuType() {
        return fabuType;
    }

    public void setFabuType(Integer fabuType) {
        this.fabuType = fabuType;
    }

    public String getYuliu() {
        return yuliu;
    }

    public void setYuliu(String yuliu) {
        this.yuliu = yuliu == null ? null : yuliu.trim();
    }
}