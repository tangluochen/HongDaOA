package com.icss.pojo;

import java.io.Serializable;

/**
 * T_PRECONTRACT
 * @author 
 */
public class TPrecontract implements Serializable {
    private Long tPrecontractId;

    private TSchedule tSchedule ;

    private TUserinfo tUserinfo;

    private static final long serialVersionUID = 1L;

    public Long gettPrecontractId() {
        return tPrecontractId;
    }

    public void settPrecontractId(Long tPrecontractId) {
        this.tPrecontractId = tPrecontractId;
    }

    public TSchedule gettSchedule() {
        return tSchedule;
    }

    public void settSchedule(TSchedule tSchedule) {
        this.tSchedule = tSchedule;
    }

    public TUserinfo gettUserinfo() {
        return tUserinfo;
    }

    public void settUserinfo(TUserinfo tUserinfo) {
        this.tUserinfo = tUserinfo;
    }
}