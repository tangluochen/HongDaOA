package com.icss.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * T_MYNOTE
 * @author 
 */
public class TMynote implements Serializable {
    private Long tMynoteId;

    private String tMynoteTitle;

    private String tMynoteContent;

    private Date tMynoteCreatetime;

    private String tMynoteCreateuser;

    private static final long serialVersionUID = 1L;

    public Long gettMynoteId() {
        return tMynoteId;
    }

    public void settMynoteId(Long tMynoteId) {
        this.tMynoteId = tMynoteId;
    }

    public String gettMynoteTitle() {
        return tMynoteTitle;
    }

    public void settMynoteTitle(String tMynoteTitle) {
        this.tMynoteTitle = tMynoteTitle;
    }

    public String gettMynoteContent() {
        return tMynoteContent;
    }

    public void settMynoteContent(String tMynoteContent) {
        this.tMynoteContent = tMynoteContent;
    }

    public Date gettMynoteCreatetime() {
        return tMynoteCreatetime;
    }

    public void settMynoteCreatetime(Date tMynoteCreatetime) {
        this.tMynoteCreatetime = tMynoteCreatetime;
    }

    public String gettMynoteCreateuser() {
        return tMynoteCreateuser;
    }

    public void settMynoteCreateuser(String tMynoteCreateuser) {
        this.tMynoteCreateuser = tMynoteCreateuser;
    }
}