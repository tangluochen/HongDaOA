package com.icss.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * T_LOGINLOG
 * @author 
 */
public class TLoginlog implements Serializable {
    private Long tLoginlogId;

    private TUserinfo tUserinfo;

    private Date tLoginlogTime;

    private String tLoginlogIfsuccess;

    private String tLoginlogUserip;

    private String tLoginlogDesc;

    private static final long serialVersionUID = 1L;

    public Long gettLoginlogId() {
        return tLoginlogId;
    }

    public void settLoginlogId(Long tLoginlogId) {
        this.tLoginlogId = tLoginlogId;
    }

    public TUserinfo gettUserinfo() {
        return tUserinfo;
    }

    public void settUserinfo(TUserinfo tUserinfo) {
        this.tUserinfo = tUserinfo;
    }

    public Date gettLoginlogTime() {
        return tLoginlogTime;
    }

    public void settLoginlogTime(Date tLoginlogTime) {
        this.tLoginlogTime = tLoginlogTime;
    }

    public String gettLoginlogIfsuccess() {
        return tLoginlogIfsuccess;
    }

    public void settLoginlogIfsuccess(String tLoginlogIfsuccess) {
        this.tLoginlogIfsuccess = tLoginlogIfsuccess;
    }

    public String gettLoginlogUserip() {
        return tLoginlogUserip;
    }

    public void settLoginlogUserip(String tLoginlogUserip) {
        this.tLoginlogUserip = tLoginlogUserip;
    }

    public String gettLoginlogDesc() {
        return tLoginlogDesc;
    }

    public void settLoginlogDesc(String tLoginlogDesc) {
        this.tLoginlogDesc = tLoginlogDesc;
    }
}