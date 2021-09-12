package com.icss.pojo;

import java.io.Serializable;

/**
 * T_MESSAGETYPE
 * @author 
 */
public class TMessagetype implements Serializable {
    private Long tMessagetypeId;

    private String tMessagetypeName;

    private String tMessagetypeDesc;

    private static final long serialVersionUID = 1L;

    public Long gettMessagetypeId() {
        return tMessagetypeId;
    }

    public void settMessagetypeId(Long tMessagetypeId) {
        this.tMessagetypeId = tMessagetypeId;
    }

    public String gettMessagetypeName() {
        return tMessagetypeName;
    }

    public void settMessagetypeName(String tMessagetypeName) {
        this.tMessagetypeName = tMessagetypeName;
    }

    public String gettMessagetypeDesc() {
        return tMessagetypeDesc;
    }

    public void settMessagetypeDesc(String tMessagetypeDesc) {
        this.tMessagetypeDesc = tMessagetypeDesc;
    }
}