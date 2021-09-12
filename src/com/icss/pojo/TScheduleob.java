package com.icss.pojo;

import java.io.Serializable;

/**
 * T_SCHEDULEOB
 * @author 
 */
public class TScheduleob implements Serializable {
    private Long tScheduleobId;

    private TDepartinfo tDepartinfo;

    private TSchedule tSchedule;

    private TUserinfo tUserinfo;

    private TBranchinfo tBranchinfo;

    private static final long serialVersionUID = 1L;

    public Long gettScheduleobId() {
        return tScheduleobId;
    }

    public void settScheduleobId(Long tScheduleobId) {
        this.tScheduleobId = tScheduleobId;
    }

    public TDepartinfo gettDepartinfo() {
        return tDepartinfo;
    }

    public void settDepartinfo(TDepartinfo tDepartinfo) {
        this.tDepartinfo = tDepartinfo;
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

    public TBranchinfo gettBranchinfo() {
        return tBranchinfo;
    }

    public void settBranchinfo(TBranchinfo tBranchinfo) {
        this.tBranchinfo = tBranchinfo;
    }
}