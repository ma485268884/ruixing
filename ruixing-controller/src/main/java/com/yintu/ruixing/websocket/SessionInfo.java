package com.yintu.ruixing.websocket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.websocket.Session;
import java.io.Serializable;
import java.util.Date;

/**
 * @author:mlf
 * @date:2020/6/21 11:32
 */
public class SessionInfo implements Serializable {
    private static final long serialVersionUID = 6835109452509281566L;

    private Integer tid;

    private Integer did;

    private Integer xid;

    private Integer cid;

    private Integer sid;

    private Session session;


    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getXid() {
        return xid;
    }

    public void setXid(Integer xid) {
        this.xid = xid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
