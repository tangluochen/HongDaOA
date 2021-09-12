package com.icss.pojo;

import java.io.Serializable;

/**
 * T_MANAGE_POWER
 * @author 
 */
public class TManagePower implements Serializable {
    private Long tManagePowerId;

    private TManage tManage;

    private TPower tPower;

    private static final long serialVersionUID = 1L;

    public Long gettManagePowerId() {
        return tManagePowerId;
    }

    public void settManagePowerId(Long tManagePowerId) {
        this.tManagePowerId = tManagePowerId;
    }

    public TManage gettManage() {
        return tManage;
    }

    public void settManage(TManage tManage) {
        this.tManage = tManage;
    }

    public TPower gettPower() {
        return tPower;
    }

    public void settPower(TPower tPower) {
        this.tPower = tPower;
    }
}