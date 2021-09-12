package com.icss.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * T_OPERATELOG
 * @author 
 */
public class TOperatelog implements Serializable {
    private Long tOperatelogId;

    private TUserinfo tUserinfo;

    private String tOperatelogName;

    private String tOperatelogObjectid;

    private String tOperatelogDesc;

    private Date tOperatelogTime;

    private static final long serialVersionUID = 1L;

    public Long gettOperatelogId() {
        return tOperatelogId;
    }

    public void settOperatelogId(Long tOperatelogId) {
        this.tOperatelogId = tOperatelogId;
    }

    public TUserinfo gettUserinfo() {
        return tUserinfo;
    }

    public void settUserinfo(TUserinfo tUserinfo) {
        this.tUserinfo = tUserinfo;
    }

    public String gettOperatelogName() {
        return tOperatelogName;
    }

    public void settOperatelogName(String tOperatelogName) {
        this.tOperatelogName = tOperatelogName;
    }

    public String gettOperatelogObjectid() {
        return tOperatelogObjectid;
    }

    public void settOperatelogObjectid(String tOperatelogObjectid) {
        this.tOperatelogObjectid = tOperatelogObjectid;
    }

    public String gettOperatelogDesc() {
        return tOperatelogDesc;
    }

    public void settOperatelogDesc(String tOperatelogDesc) {
        this.tOperatelogDesc = tOperatelogDesc;
    }

    public Date gettOperatelogTime() {
        return tOperatelogTime;
    }

    public void settOperatelogTime(Date tOperatelogTime) {
        this.tOperatelogTime = tOperatelogTime;
    }
}