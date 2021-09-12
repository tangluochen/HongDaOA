package com.icss.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * T_FILEINFO
 * @author 
 */
public class TFileinfo implements Serializable {
    private Long tFileinfoId;

    private String tFileinfoName;

    private TFiletypeinfo tFiletypeinfo;

    private String tFileinfoRemark;

    private String tFileinfoOwner;

    private Date tFileinfoCreatedate;

    private Long tFileinfoParentid;

    private String tFileinfoFilepath;

    private Long tFileinfoIfdelete;

    private static final long serialVersionUID = 1L;

    public Long gettFileinfoId() {
        return tFileinfoId;
    }

    public void settFileinfoId(Long tFileinfoId) {
        this.tFileinfoId = tFileinfoId;
    }

    public String gettFileinfoName() {
        return tFileinfoName;
    }

    public void settFileinfoName(String tFileinfoName) {
        this.tFileinfoName = tFileinfoName;
    }

    public TFiletypeinfo gettFiletypeinfo() {
        return tFiletypeinfo;
    }

    public void settFiletypeinfo(TFiletypeinfo tFiletypeinfo) {
        this.tFiletypeinfo = tFiletypeinfo;
    }

    public String gettFileinfoRemark() {
        return tFileinfoRemark;
    }

    public void settFileinfoRemark(String tFileinfoRemark) {
        this.tFileinfoRemark = tFileinfoRemark;
    }

    public String gettFileinfoOwner() {
        return tFileinfoOwner;
    }

    public void settFileinfoOwner(String tFileinfoOwner) {
        this.tFileinfoOwner = tFileinfoOwner;
    }

    public Date gettFileinfoCreatedate() {
        return tFileinfoCreatedate;
    }

    public void settFileinfoCreatedate(Date tFileinfoCreatedate) {
        this.tFileinfoCreatedate = tFileinfoCreatedate;
    }

    public Long gettFileinfoParentid() {
        return tFileinfoParentid;
    }

    public void settFileinfoParentid(Long tFileinfoParentid) {
        this.tFileinfoParentid = tFileinfoParentid;
    }

    public String gettFileinfoFilepath() {
        return tFileinfoFilepath;
    }

    public void settFileinfoFilepath(String tFileinfoFilepath) {
        this.tFileinfoFilepath = tFileinfoFilepath;
    }

    public Long gettFileinfoIfdelete() {
        return tFileinfoIfdelete;
    }

    public void settFileinfoIfdelete(Long tFileinfoIfdelete) {
        this.tFileinfoIfdelete = tFileinfoIfdelete;
    }
}