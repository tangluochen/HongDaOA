package com.icss.pojo;

import java.io.Serializable;

/**
 * T_MESSAGETOUSER
 * @author 
 */
public class TMessagetouser implements Serializable {
    private Long tMessagetouserId;

    private TMessage tMessage;

    private TUserinfo tUserinfo;

    private Long tIdRead;

    private static final long serialVersionUID = 1L;

    public Long gettMessagetouserId() {
        return tMessagetouserId;
    }

    public void settMessagetouserId(Long tMessagetouserId) {
        this.tMessagetouserId = tMessagetouserId;
    }

    public TMessage gettMessage() {
        return tMessage;
    }

    public void settMessage(TMessage tMessage) {
        this.tMessage = tMessage;
    }

    public TUserinfo gettUserinfo() {
        return tUserinfo;
    }

    public void settUserinfo(TUserinfo tUserinfo) {
        this.tUserinfo = tUserinfo;
    }

    public Long gettIdRead() {
        return tIdRead;
    }

    public void settIdRead(Long tIdRead) {
        this.tIdRead = tIdRead;
    }
}