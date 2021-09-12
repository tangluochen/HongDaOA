package com.icss.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * T_OPERATIONLOG
 * @author 
 */
public class TOperationlog implements Serializable {
    private Long tOperationlogId;

    private String tOperationlogName;

    private String tOperationlogUsername;

    private Date tOperationlogTime;

    private String tOperationlogContent;

    private static final long serialVersionUID = 1L;

    public Long gettOperationlogId() {
        return tOperationlogId;
    }

    public void settOperationlogId(Long tOperationlogId) {
        this.tOperationlogId = tOperationlogId;
    }

    public String gettOperationlogName() {
        return tOperationlogName;
    }

    public void settOperationlogName(String tOperationlogName) {
        this.tOperationlogName = tOperationlogName;
    }

    public String gettOperationlogUsername() {
        return tOperationlogUsername;
    }

    public void settOperationlogUsername(String tOperationlogUsername) {
        this.tOperationlogUsername = tOperationlogUsername;
    }

    public Date gettOperationlogTime() {
        return tOperationlogTime;
    }

    public void settOperationlogTime(Date tOperationlogTime) {
        this.tOperationlogTime = tOperationlogTime;
    }

    public String gettOperationlogContent() {
        return tOperationlogContent;
    }

    public void settOperationlogContent(String tOperationlogContent) {
        this.tOperationlogContent = tOperationlogContent;
    }
}