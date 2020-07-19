package com.yintu.ruixing.websocket;

import javax.websocket.Session;
import java.io.Serializable;

/**
 * @author:mlf
 * @date:2020/6/21 11:32
 */
public class SessionInfo implements Serializable {
    private static final long serialVersionUID = 6835109452509281566L;
    
    private Integer[] cid;

    private Session session;

    public Integer[] getCid() {
        return cid;
    }

    public void setCid(Integer[] cid) {
        this.cid = cid;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
