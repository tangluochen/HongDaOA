package com.icss.pojo;

import java.io.Serializable;

/**
 * T_USERSTATE
 * @author 
 */
public class TUserstate implements Serializable {
    private Long tUserstateId;

    private String tUserstateName;

    private static final long serialVersionUID = 1L;

    public Long gettUserstateId() {
        return tUserstateId;
    }

    public void settUserstateId(Long tUserstateId) {
        this.tUserstateId = tUserstateId;
    }

    public String gettUserstateName() {
        return tUserstateName;
    }

    public void settUserstateName(String tUserstateName) {
        this.tUserstateName = tUserstateName;
    }
}