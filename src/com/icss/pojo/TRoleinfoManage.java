package com.icss.pojo;

import java.io.Serializable;

/**
 * T_ROLEINFO_MANAGE
 * @author 
 */
public class TRoleinfoManage implements Serializable {
    private Long tRoleinfoManageId;

    private TRoleinfo tRoleinfo;

    private TMessage tMessage;

    private static final long serialVersionUID = 1L;

    public Long gettRoleinfoManageId() {
        return tRoleinfoManageId;
    }

    public void settRoleinfoManageId(Long tRoleinfoManageId) {
        this.tRoleinfoManageId = tRoleinfoManageId;
    }

    public TRoleinfo gettRoleinfo() {
        return tRoleinfo;
    }

    public void settRoleinfo(TRoleinfo tRoleinfo) {
        this.tRoleinfo = tRoleinfo;
    }

    public TMessage gettMessage() {
        return tMessage;
    }

    public void settMessage(TMessage tMessage) {
        this.tMessage = tMessage;
    }
}