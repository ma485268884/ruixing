package com.yintu.ruixing.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnZhuangTiaoShiWenTiFileEntity {
    private Integer id;

    private Integer wid;

    private Integer fenlei;

    private String fileName;

    private String filePath;

    private Integer fileState;

    private String yuliu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Integer getFenlei() {
        return fenlei;
    }

    public void setFenlei(Integer fenlei) {
        this.fenlei = fenlei;
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

    public Integer getFileState() {
        return fileState;
    }

    public void setFileState(Integer fileState) {
        this.fileState = fileState;
    }

    public String getYuliu() {
        return yuliu;
    }

    public void setYuliu(String yuliu) {
        this.yuliu = yuliu == null ? null : yuliu.trim();
    }
}