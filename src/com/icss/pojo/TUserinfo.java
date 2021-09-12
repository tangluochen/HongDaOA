package com.icss.pojo;

import java.io.Serializable;

/**
 * T_USERINFO
 * 用户表
 * @author 
 */
public class TUserinfo implements Serializable {
    private Long tUserinfoId;

    private String tUserinfoName;

    private String tUserinfoPassword;

    private TDepartinfo tDepartinfo;

    private String tUserinfoGender;

    private TRoleinfo tRoleinfo;

    private TUserstate tUserstate;

    private static final long serialVersionUID = 1L;

    public Long gettUserinfoId() {
        return tUserinfoId;
    }

    public void settUserinfoId(Long tUserinfoId) {
        this.tUserinfoId = tUserinfoId;
    }

    public String gettUserinfoName() {
        return tUserinfoName;
    }

    public void settUserinfoName(String tUserinfoName) {
        this.tUserinfoName = tUserinfoName;
    }

    public String gettUserinfoPassword() {
        return tUserinfoPassword;
    }

    public void settUserinfoPassword(String tUserinfoPassword) {
        this.tUserinfoPassword = tUserinfoPassword;
    }


    public String gettUserinfoGender() {
        return tUserinfoGender;
    }

    public void settUserinfoGender(String tUserinfoGender) {
        this.tUserinfoGender = tUserinfoGender;
    }

    public TDepartinfo gettDepartinfo() {
        return tDepartinfo;
    }

    public void settDepartinfo(TDepartinfo tDepartinfo) {
        this.tDepartinfo = tDepartinfo;
    }

    public TRoleinfo gettRoleinfo() {
        return tRoleinfo;
    }

    public void settRoleinfo(TRoleinfo tRoleinfo) {
        this.tRoleinfo = tRoleinfo;
    }

    public TUserstate gettUserstate() {
        return tUserstate;
    }

    public void settUserstate(TUserstate tUserstate) {
        this.tUserstate = tUserstate;
    }
}