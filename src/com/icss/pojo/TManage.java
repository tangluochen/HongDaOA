package com.icss.pojo;

import java.io.Serializable;

/**
 * T_MANAGE
 * @author 
 */
public class TManage implements Serializable {
    private Long tManageId;

    private String tManageName;

    private static final long serialVersionUID = 1L;

    public Long gettManageId() {
        return tManageId;
    }

    public void settManageId(Long tManageId) {
        this.tManageId = tManageId;
    }

    public String gettManageName() {
        return tManageName;
    }

    public void settManageName(String tManageName) {
        this.tManageName = tManageName;
    }
}