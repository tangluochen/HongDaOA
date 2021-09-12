package com.icss.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * T_MESSAGE
 * @author 
 */
public class TMessage implements Serializable {
    private Long tMessageId;

    private String tMessageTitle;

    private String tMessageContent;

    private TMessagetype tMessagetype;

    private Date tMessageBegintime;

    private Date tMessageEndtime;

    private TUserinfo tUserinfo;

    private String tMessageIfpublish;

    private Date tMessageRecordtime;

    private static final long serialVersionUID = 1L;

    public Long gettMessageId() {
        return tMessageId;
    }

    public void settMessageId(Long tMessageId) {
        this.tMessageId = tMessageId;
    }

    public String gettMessageTitle() {
        return tMessageTitle;
    }

    public void settMessageTitle(String tMessageTitle) {
        this.tMessageTitle = tMessageTitle;
    }

    public String gettMessageContent() {
        return tMessageContent;
    }

    public void settMessageContent(String tMessageContent) {
        this.tMessageContent = tMessageContent;
    }

    public TMessagetype gettMessagetype() {
        return tMessagetype;
    }

    public void settMessagetype(TMessagetype tMessagetype) {
        this.tMessagetype = tMessagetype;
    }

    public TUserinfo gettUserinfo() {
        return tUserinfo;
    }

    public void settUserinfo(TUserinfo tUserinfo) {
        this.tUserinfo = tUserinfo;
    }

    public Date gettMessageBegintime() {
        return tMessageBegintime;
    }

    public void settMessageBegintime(Date tMessageBegintime) {
        this.tMessageBegintime = tMessageBegintime;
    }

    public Date gettMessageEndtime() {
        return tMessageEndtime;
    }

    public void settMessageEndtime(Date tMessageEndtime) {
        this.tMessageEndtime = tMessageEndtime;
    }


    public String gettMessageIfpublish() {
        return tMessageIfpublish;
    }

    public void settMessageIfpublish(String tMessageIfpublish) {
        this.tMessageIfpublish = tMessageIfpublish;
    }

    public Date gettMessageRecordtime() {
        return tMessageRecordtime;
    }

    public void settMessageRecordtime(Date tMessageRecordtime) {
        this.tMessageRecordtime = tMessageRecordtime;
    }
}