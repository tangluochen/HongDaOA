package com.icss.pojo;

import java.io.Serializable;

/**
 * T_ROLERIGHT
 * @author 
 */
public class TRoleright implements Serializable {
    private Long tRolerightId;

    private TRoleinfo tRoleinfo;

    private String tRolerightUri;

    private static final long serialVersionUID = 1L;

    public Long gettRolerightId() {
        return tRolerightId;
    }

    public void settRolerightId(Long tRolerightId) {
        this.tRolerightId = tRolerightId;
    }

    public TRoleinfo gettRoleinfo() {
        return tRoleinfo;
    }

    public void settRoleinfo(TRoleinfo tRoleinfo) {
        this.tRoleinfo = tRoleinfo;
    }

    public String gettRolerightUri() {
        return tRolerightUri;
    }

    public void settRolerightUri(String tRolerightUri) {
        this.tRolerightUri = tRolerightUri;
    }
}