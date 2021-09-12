package com.icss.pojo;

import java.io.Serializable;

/**
 * T_MEETINGINFO
 * @author 
 */
public class TMeetinginfo implements Serializable {
    private Long tMeetinginfoId;

    private String tMeetinginfoName;

    private static final long serialVersionUID = 1L;

    public Long gettMeetinginfoId() {
        return tMeetinginfoId;
    }

    public void settMeetinginfoId(Long tMeetinginfoId) {
        this.tMeetinginfoId = tMeetinginfoId;
    }

    public String gettMeetinginfoName() {
        return tMeetinginfoName;
    }

    public void settMeetinginfoName(String tMeetinginfoName) {
        this.tMeetinginfoName = tMeetinginfoName;
    }
}