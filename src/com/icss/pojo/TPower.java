package com.icss.pojo;

import java.io.Serializable;

/**
 * T_POWER
 * @author 
 */
public class TPower implements Serializable {
    private Long tPowerId;

    private String tPowerName;

    private String tPowerUri;

    private static final long serialVersionUID = 1L;

    public Long gettPowerId() {
        return tPowerId;
    }

    public void settPowerId(Long tPowerId) {
        this.tPowerId = tPowerId;
    }

    public String gettPowerName() {
        return tPowerName;
    }

    public void settPowerName(String tPowerName) {
        this.tPowerName = tPowerName;
    }

    public String gettPowerUri() {
        return tPowerUri;
    }

    public void settPowerUri(String tPowerUri) {
        this.tPowerUri = tPowerUri;
    }
}