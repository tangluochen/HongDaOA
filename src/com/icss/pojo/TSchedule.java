package com.icss.pojo;

import java.io.Serializable;

/**
 * T_SCHEDULE
 * @author 
 */
public class TSchedule implements Serializable {
    private Long tScheduleId;

    private String tScheduleTitle;

    private String tScheduleAddress;

    private TMeetinginfo tMeetinginfo;

    private String tScheduleBegintime;

    private String tScheduleEndtime;

    private String tScheduleContent;

    private String tScheduleCreateuser;

    private static final long serialVersionUID = 1L;

    public Long gettScheduleId() {
        return tScheduleId;
    }

    public void settScheduleId(Long tScheduleId) {
        this.tScheduleId = tScheduleId;
    }

    public String gettScheduleTitle() {
        return tScheduleTitle;
    }

    public void settScheduleTitle(String tScheduleTitle) {
        this.tScheduleTitle = tScheduleTitle;
    }

    public String gettScheduleAddress() {
        return tScheduleAddress;
    }

    public void settScheduleAddress(String tScheduleAddress) {
        this.tScheduleAddress = tScheduleAddress;
    }

    public TMeetinginfo gettMeetinginfo() {
        return tMeetinginfo;
    }

    public void settMeetinginfo(TMeetinginfo tMeetinginfo) {
        this.tMeetinginfo = tMeetinginfo;
    }

    public String gettScheduleBegintime() {
        return tScheduleBegintime;
    }

    public void settScheduleBegintime(String tScheduleBegintime) {
        this.tScheduleBegintime = tScheduleBegintime;
    }

    public String gettScheduleEndtime() {
        return tScheduleEndtime;
    }

    public void settScheduleEndtime(String tScheduleEndtime) {
        this.tScheduleEndtime = tScheduleEndtime;
    }

    public String gettScheduleContent() {
        return tScheduleContent;
    }

    public void settScheduleContent(String tScheduleContent) {
        this.tScheduleContent = tScheduleContent;
    }

    public String gettScheduleCreateuser() {
        return tScheduleCreateuser;
    }

    public void settScheduleCreateuser(String tScheduleCreateuser) {
        this.tScheduleCreateuser = tScheduleCreateuser;
    }
}