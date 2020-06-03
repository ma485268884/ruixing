package com.yintu.ruixing.entity;

public class QuDuanInfoEntity {
    private Integer id;

    private Integer xid;//线段id

    private Integer qid;//区段id

    private Integer cid;//车站id

    private Integer typeid;//类型id

    private String qdName;

    private String designCarrier;

    private String direction;

    private String gjcollection;

    private Integer vInAll;

    private Integer mvInZhu;

    private Integer mvInBing;

    private Integer mvInDiaoZhu;

    private Integer mvInDiaoBing;

    private Integer hzInLowZhu;

    private Integer hzInLowBing;

    private String gjDriveZhu;

    private String gjDriveBing;

    private String gjRearCollectionZhu;

    private String gjRearCollectionBing;

    private String baojingZhu;

    private String baojingBing;

    private Integer vOutZhu;

    private Integer vOutBei;

    private Integer maOutZhu;

    private Integer maOutBei;

    private Integer hzUpZhu;

    private Integer hzUpBei;

    private Integer hzDownZhu;

    private Integer hzDownBei;

    private Integer hzLowZhu;

    private Integer hzLowBei;

    private String fbjDriveZhu;

    private String fbjDriveBei;

    private String fbjCollectionZhu;

    private String fbjCollectionBei;

    private Integer vSongduanCable;

    private Integer maSongduanCable;

    private Integer vShouduanCableHost;

    private Integer vShouduanCableSpare;

    private Integer maShouduanCable;

    private Integer maCableJbp;

    private Integer aLonginJbp;

    private Integer aLongoutJbp;

    private Integer aShortinJbp;

    private Integer aShortoutJbp;

    private Integer tJbp;

    private Integer maCableFbp;

    private Integer aLonginFbp;

    private Integer aLongoutFbp;

    private Integer aShortinFbp;

    private Integer aShortoutFbp;

    private Integer tFbp;

    private Integer aLonginFbaZhu;

    private Integer aLonginFbaDiao;

    private Integer aLongoutFbaZhu;

    private Integer aLongoutFbaDiao;

    private Integer aShortinFbaZhu;

    private Integer aShortinFbaDiao;

    private Integer aShortoutFbaZhu;

    private Integer aShortoutFbaDiao;

    private Integer aLonginJbaZhu;

    private Integer aLonginJbaDiao;

    private Integer aLongoutJbaZhu;

    private Integer aLongoutJbaDiao;

    private Integer aShortinJbaZhu;

    private Integer aShortinJbaDiao;

    private Integer aShortoutJbaZhu;

    private Integer aShortoutJbaDiao;

    private String yuliu;

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

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getQdName() {
        return qdName;
    }

    public void setQdName(String qdName) {
        this.qdName = qdName == null ? null : qdName.trim();
    }

    public String getDesignCarrier() {
        return designCarrier;
    }

    public void setDesignCarrier(String designCarrier) {
        this.designCarrier = designCarrier == null ? null : designCarrier.trim();
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
    }

    public String getGjcollection() {
        return gjcollection;
    }

    public void setGjcollection(String gjcollection) {
        this.gjcollection = gjcollection == null ? null : gjcollection.trim();
    }

    public Integer getvInAll() {
        return vInAll;
    }

    public void setvInAll(Integer vInAll) {
        this.vInAll = vInAll;
    }

    public Integer getMvInZhu() {
        return mvInZhu;
    }

    public void setMvInZhu(Integer mvInZhu) {
        this.mvInZhu = mvInZhu;
    }

    public Integer getMvInBing() {
        return mvInBing;
    }

    public void setMvInBing(Integer mvInBing) {
        this.mvInBing = mvInBing;
    }

    public Integer getMvInDiaoZhu() {
        return mvInDiaoZhu;
    }

    public void setMvInDiaoZhu(Integer mvInDiaoZhu) {
        this.mvInDiaoZhu = mvInDiaoZhu;
    }

    public Integer getMvInDiaoBing() {
        return mvInDiaoBing;
    }

    public void setMvInDiaoBing(Integer mvInDiaoBing) {
        this.mvInDiaoBing = mvInDiaoBing;
    }

    public Integer getHzInLowZhu() {
        return hzInLowZhu;
    }

    public void setHzInLowZhu(Integer hzInLowZhu) {
        this.hzInLowZhu = hzInLowZhu;
    }

    public Integer getHzInLowBing() {
        return hzInLowBing;
    }

    public void setHzInLowBing(Integer hzInLowBing) {
        this.hzInLowBing = hzInLowBing;
    }

    public String getGjDriveZhu() {
        return gjDriveZhu;
    }

    public void setGjDriveZhu(String gjDriveZhu) {
        this.gjDriveZhu = gjDriveZhu == null ? null : gjDriveZhu.trim();
    }

    public String getGjDriveBing() {
        return gjDriveBing;
    }

    public void setGjDriveBing(String gjDriveBing) {
        this.gjDriveBing = gjDriveBing == null ? null : gjDriveBing.trim();
    }

    public String getGjRearCollectionZhu() {
        return gjRearCollectionZhu;
    }

    public void setGjRearCollectionZhu(String gjRearCollectionZhu) {
        this.gjRearCollectionZhu = gjRearCollectionZhu == null ? null : gjRearCollectionZhu.trim();
    }

    public String getGjRearCollectionBing() {
        return gjRearCollectionBing;
    }

    public void setGjRearCollectionBing(String gjRearCollectionBing) {
        this.gjRearCollectionBing = gjRearCollectionBing == null ? null : gjRearCollectionBing.trim();
    }

    public String getBaojingZhu() {
        return baojingZhu;
    }

    public void setBaojingZhu(String baojingZhu) {
        this.baojingZhu = baojingZhu == null ? null : baojingZhu.trim();
    }

    public String getBaojingBing() {
        return baojingBing;
    }

    public void setBaojingBing(String baojingBing) {
        this.baojingBing = baojingBing == null ? null : baojingBing.trim();
    }

    public Integer getvOutZhu() {
        return vOutZhu;
    }

    public void setvOutZhu(Integer vOutZhu) {
        this.vOutZhu = vOutZhu;
    }

    public Integer getvOutBei() {
        return vOutBei;
    }

    public void setvOutBei(Integer vOutBei) {
        this.vOutBei = vOutBei;
    }

    public Integer getMaOutZhu() {
        return maOutZhu;
    }

    public void setMaOutZhu(Integer maOutZhu) {
        this.maOutZhu = maOutZhu;
    }

    public Integer getMaOutBei() {
        return maOutBei;
    }

    public void setMaOutBei(Integer maOutBei) {
        this.maOutBei = maOutBei;
    }

    public Integer getHzUpZhu() {
        return hzUpZhu;
    }

    public void setHzUpZhu(Integer hzUpZhu) {
        this.hzUpZhu = hzUpZhu;
    }

    public Integer getHzUpBei() {
        return hzUpBei;
    }

    public void setHzUpBei(Integer hzUpBei) {
        this.hzUpBei = hzUpBei;
    }

    public Integer getHzDownZhu() {
        return hzDownZhu;
    }

    public void setHzDownZhu(Integer hzDownZhu) {
        this.hzDownZhu = hzDownZhu;
    }

    public Integer getHzDownBei() {
        return hzDownBei;
    }

    public void setHzDownBei(Integer hzDownBei) {
        this.hzDownBei = hzDownBei;
    }

    public Integer getHzLowZhu() {
        return hzLowZhu;
    }

    public void setHzLowZhu(Integer hzLowZhu) {
        this.hzLowZhu = hzLowZhu;
    }

    public Integer getHzLowBei() {
        return hzLowBei;
    }

    public void setHzLowBei(Integer hzLowBei) {
        this.hzLowBei = hzLowBei;
    }

    public String getFbjDriveZhu() {
        return fbjDriveZhu;
    }

    public void setFbjDriveZhu(String fbjDriveZhu) {
        this.fbjDriveZhu = fbjDriveZhu == null ? null : fbjDriveZhu.trim();
    }

    public String getFbjDriveBei() {
        return fbjDriveBei;
    }

    public void setFbjDriveBei(String fbjDriveBei) {
        this.fbjDriveBei = fbjDriveBei == null ? null : fbjDriveBei.trim();
    }

    public String getFbjCollectionZhu() {
        return fbjCollectionZhu;
    }

    public void setFbjCollectionZhu(String fbjCollectionZhu) {
        this.fbjCollectionZhu = fbjCollectionZhu == null ? null : fbjCollectionZhu.trim();
    }

    public String getFbjCollectionBei() {
        return fbjCollectionBei;
    }

    public void setFbjCollectionBei(String fbjCollectionBei) {
        this.fbjCollectionBei = fbjCollectionBei == null ? null : fbjCollectionBei.trim();
    }

    public Integer getvSongduanCable() {
        return vSongduanCable;
    }

    public void setvSongduanCable(Integer vSongduanCable) {
        this.vSongduanCable = vSongduanCable;
    }

    public Integer getMaSongduanCable() {
        return maSongduanCable;
    }

    public void setMaSongduanCable(Integer maSongduanCable) {
        this.maSongduanCable = maSongduanCable;
    }

    public Integer getvShouduanCableHost() {
        return vShouduanCableHost;
    }

    public void setvShouduanCableHost(Integer vShouduanCableHost) {
        this.vShouduanCableHost = vShouduanCableHost;
    }

    public Integer getvShouduanCableSpare() {
        return vShouduanCableSpare;
    }

    public void setvShouduanCableSpare(Integer vShouduanCableSpare) {
        this.vShouduanCableSpare = vShouduanCableSpare;
    }

    public Integer getMaShouduanCable() {
        return maShouduanCable;
    }

    public void setMaShouduanCable(Integer maShouduanCable) {
        this.maShouduanCable = maShouduanCable;
    }

    public Integer getMaCableJbp() {
        return maCableJbp;
    }

    public void setMaCableJbp(Integer maCableJbp) {
        this.maCableJbp = maCableJbp;
    }

    public Integer getaLonginJbp() {
        return aLonginJbp;
    }

    public void setaLonginJbp(Integer aLonginJbp) {
        this.aLonginJbp = aLonginJbp;
    }

    public Integer getaLongoutJbp() {
        return aLongoutJbp;
    }

    public void setaLongoutJbp(Integer aLongoutJbp) {
        this.aLongoutJbp = aLongoutJbp;
    }

    public Integer getaShortinJbp() {
        return aShortinJbp;
    }

    public void setaShortinJbp(Integer aShortinJbp) {
        this.aShortinJbp = aShortinJbp;
    }

    public Integer getaShortoutJbp() {
        return aShortoutJbp;
    }

    public void setaShortoutJbp(Integer aShortoutJbp) {
        this.aShortoutJbp = aShortoutJbp;
    }

    public Integer gettJbp() {
        return tJbp;
    }

    public void settJbp(Integer tJbp) {
        this.tJbp = tJbp;
    }

    public Integer getMaCableFbp() {
        return maCableFbp;
    }

    public void setMaCableFbp(Integer maCableFbp) {
        this.maCableFbp = maCableFbp;
    }

    public Integer getaLonginFbp() {
        return aLonginFbp;
    }

    public void setaLonginFbp(Integer aLonginFbp) {
        this.aLonginFbp = aLonginFbp;
    }

    public Integer getaLongoutFbp() {
        return aLongoutFbp;
    }

    public void setaLongoutFbp(Integer aLongoutFbp) {
        this.aLongoutFbp = aLongoutFbp;
    }

    public Integer getaShortinFbp() {
        return aShortinFbp;
    }

    public void setaShortinFbp(Integer aShortinFbp) {
        this.aShortinFbp = aShortinFbp;
    }

    public Integer getaShortoutFbp() {
        return aShortoutFbp;
    }

    public void setaShortoutFbp(Integer aShortoutFbp) {
        this.aShortoutFbp = aShortoutFbp;
    }

    public Integer gettFbp() {
        return tFbp;
    }

    public void settFbp(Integer tFbp) {
        this.tFbp = tFbp;
    }

    public Integer getaLonginFbaZhu() {
        return aLonginFbaZhu;
    }

    public void setaLonginFbaZhu(Integer aLonginFbaZhu) {
        this.aLonginFbaZhu = aLonginFbaZhu;
    }

    public Integer getaLonginFbaDiao() {
        return aLonginFbaDiao;
    }

    public void setaLonginFbaDiao(Integer aLonginFbaDiao) {
        this.aLonginFbaDiao = aLonginFbaDiao;
    }

    public Integer getaLongoutFbaZhu() {
        return aLongoutFbaZhu;
    }

    public void setaLongoutFbaZhu(Integer aLongoutFbaZhu) {
        this.aLongoutFbaZhu = aLongoutFbaZhu;
    }

    public Integer getaLongoutFbaDiao() {
        return aLongoutFbaDiao;
    }

    public void setaLongoutFbaDiao(Integer aLongoutFbaDiao) {
        this.aLongoutFbaDiao = aLongoutFbaDiao;
    }

    public Integer getaShortinFbaZhu() {
        return aShortinFbaZhu;
    }

    public void setaShortinFbaZhu(Integer aShortinFbaZhu) {
        this.aShortinFbaZhu = aShortinFbaZhu;
    }

    public Integer getaShortinFbaDiao() {
        return aShortinFbaDiao;
    }

    public void setaShortinFbaDiao(Integer aShortinFbaDiao) {
        this.aShortinFbaDiao = aShortinFbaDiao;
    }

    public Integer getaShortoutFbaZhu() {
        return aShortoutFbaZhu;
    }

    public void setaShortoutFbaZhu(Integer aShortoutFbaZhu) {
        this.aShortoutFbaZhu = aShortoutFbaZhu;
    }

    public Integer getaShortoutFbaDiao() {
        return aShortoutFbaDiao;
    }

    public void setaShortoutFbaDiao(Integer aShortoutFbaDiao) {
        this.aShortoutFbaDiao = aShortoutFbaDiao;
    }

    public Integer getaLonginJbaZhu() {
        return aLonginJbaZhu;
    }

    public void setaLonginJbaZhu(Integer aLonginJbaZhu) {
        this.aLonginJbaZhu = aLonginJbaZhu;
    }

    public Integer getaLonginJbaDiao() {
        return aLonginJbaDiao;
    }

    public void setaLonginJbaDiao(Integer aLonginJbaDiao) {
        this.aLonginJbaDiao = aLonginJbaDiao;
    }

    public Integer getaLongoutJbaZhu() {
        return aLongoutJbaZhu;
    }

    public void setaLongoutJbaZhu(Integer aLongoutJbaZhu) {
        this.aLongoutJbaZhu = aLongoutJbaZhu;
    }

    public Integer getaLongoutJbaDiao() {
        return aLongoutJbaDiao;
    }

    public void setaLongoutJbaDiao(Integer aLongoutJbaDiao) {
        this.aLongoutJbaDiao = aLongoutJbaDiao;
    }

    public Integer getaShortinJbaZhu() {
        return aShortinJbaZhu;
    }

    public void setaShortinJbaZhu(Integer aShortinJbaZhu) {
        this.aShortinJbaZhu = aShortinJbaZhu;
    }

    public Integer getaShortinJbaDiao() {
        return aShortinJbaDiao;
    }

    public void setaShortinJbaDiao(Integer aShortinJbaDiao) {
        this.aShortinJbaDiao = aShortinJbaDiao;
    }

    public Integer getaShortoutJbaZhu() {
        return aShortoutJbaZhu;
    }

    public void setaShortoutJbaZhu(Integer aShortoutJbaZhu) {
        this.aShortoutJbaZhu = aShortoutJbaZhu;
    }

    public Integer getaShortoutJbaDiao() {
        return aShortoutJbaDiao;
    }

    public void setaShortoutJbaDiao(Integer aShortoutJbaDiao) {
        this.aShortoutJbaDiao = aShortoutJbaDiao;
    }

    public String getYuliu() {
        return yuliu;
    }

    public void setYuliu(String yuliu) {
        this.yuliu = yuliu == null ? null : yuliu.trim();
    }
}