package com.icss.pojo;

import java.io.Serializable;

/**
 * T_DEPARTINFO
 * @author 
 */
public class TDepartinfo implements Serializable {
    private Long tDepartinfoId;

    private String tDepartinfoName;

    private TUserinfo tUserinfo;

    private String tDepartinfoTel;

    private String tDepartinfoMobiletel;

    private String tDepartinfoFaxes;

    private TBranchinfo tBranchinfo;

    private static final long serialVersionUID = 1L;

    public Long gettDepartinfoId() {
        return tDepartinfoId;
    }

    public void settDepartinfoId(Long tDepartinfoId) {
        this.tDepartinfoId = tDepartinfoId;
    }

    public String gettDepartinfoName() {
        return tDepartinfoName;
    }

    public void settDepartinfoName(String tDepartinfoName) {
        this.tDepartinfoName = tDepartinfoName;
    }


    public String gettDepartinfoTel() {
        return tDepartinfoTel;
    }

    public void settDepartinfoTel(String tDepartinfoTel) {
        this.tDepartinfoTel = tDepartinfoTel;
    }

    public String gettDepartinfoMobiletel() {
        return tDepartinfoMobiletel;
    }

    public void settDepartinfoMobiletel(String tDepartinfoMobiletel) {
        this.tDepartinfoMobiletel = tDepartinfoMobiletel;
    }

    public String gettDepartinfoFaxes() {
        return tDepartinfoFaxes;
    }

    public void settDepartinfoFaxes(String tDepartinfoFaxes) {
        this.tDepartinfoFaxes = tDepartinfoFaxes;
    }

    public TUserinfo gettUserinfo() {
        return tUserinfo;
    }

    public void settUserinfo(TUserinfo tUserinfo) {
        this.tUserinfo = tUserinfo;
    }

    public TBranchinfo gettBranchinfo() {
        return tBranchinfo;
    }

    public void settBranchinfo(TBranchinfo tBranchinfo) {
        this.tBranchinfo = tBranchinfo;
    }
}