package com.icss.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * T_MANUALSIGN
 * @author 
 */
public class TManualsign implements Serializable {
    private Long tManualsignId;

    private TUserinfo tUserinfo;

    private Date tManualsignTime;

    private String tManualsignDesc;

    private Long tManualsignTag;

    private static final long serialVersionUID = 1L;

    public Long gettManualsignId() {
        return tManualsignId;
    }

    public void settManualsignId(Long tManualsignId) {
        this.tManualsignId = tManualsignId;
    }

    public TUserinfo gettUserinfo() {
        return tUserinfo;
    }

    public void settUserinfo(TUserinfo tUserinfo) {
        this.tUserinfo = tUserinfo;
    }

    public Date gettManualsignTime() {
        return tManualsignTime;
    }

    public void settManualsignTime(Date tManualsignTime) {
        this.tManualsignTime = tManualsignTime;
    }

    public String gettManualsignDesc() {
        return tManualsignDesc;
    }

    public void settManualsignDesc(String tManualsignDesc) {
        this.tManualsignDesc = tManualsignDesc;
    }

    public Long gettManualsignTag() {
        return tManualsignTag;
    }

    public void settManualsignTag(Long tManualsignTag) {
        this.tManualsignTag = tManualsignTag;
    }
}