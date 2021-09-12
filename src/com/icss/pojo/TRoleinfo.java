package com.icss.pojo;

import java.io.Serializable;

/**
 * T_ROLEINFO
 * @author 
 */
public class TRoleinfo implements Serializable {
    private Long tRoleinfoId;

    private String tRoleinfoName;

    private String tRoleinfoDesc;

    private static final long serialVersionUID = 1L;

    public Long gettRoleinfoId() {
        return tRoleinfoId;
    }

    public void settRoleinfoId(Long tRoleinfoId) {
        this.tRoleinfoId = tRoleinfoId;
    }

    public String gettRoleinfoName() {
        return tRoleinfoName;
    }

    public void settRoleinfoName(String tRoleinfoName) {
        this.tRoleinfoName = tRoleinfoName;
    }

    public String gettRoleinfoDesc() {
        return tRoleinfoDesc;
    }

    public void settRoleinfoDesc(String tRoleinfoDesc) {
        this.tRoleinfoDesc = tRoleinfoDesc;
    }
}