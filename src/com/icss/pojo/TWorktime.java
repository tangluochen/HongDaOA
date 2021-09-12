package com.icss.pojo;

import java.io.Serializable;

/**
 * T_WORKTIME
 * @author 
 */
public class TWorktime implements Serializable {
    private Long tWorktimeId;

    private String tWorktimeOndutytime;

    private String tWorktimeOffdutytime;

    private static final long serialVersionUID = 1L;

    public Long gettWorktimeId() {
        return tWorktimeId;
    }

    public void settWorktimeId(Long tWorktimeId) {
        this.tWorktimeId = tWorktimeId;
    }

    public String gettWorktimeOndutytime() {
        return tWorktimeOndutytime;
    }

    public void settWorktimeOndutytime(String tWorktimeOndutytime) {
        this.tWorktimeOndutytime = tWorktimeOndutytime;
    }

    public String gettWorktimeOffdutytime() {
        return tWorktimeOffdutytime;
    }

    public void settWorktimeOffdutytime(String tWorktimeOffdutytime) {
        this.tWorktimeOffdutytime = tWorktimeOffdutytime;
    }
}