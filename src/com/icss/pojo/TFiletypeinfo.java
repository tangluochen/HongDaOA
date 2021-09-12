package com.icss.pojo;

import java.io.Serializable;

/**
 * T_FILETYPEINFO
 * @author 
 */
public class TFiletypeinfo implements Serializable {
    private Long tFiletypeinfoId;

    private String tFiletypeinfoName;

    private String tFiletypeinfoImage;

    private String tFiletypeinfoSuffix;

    private static final long serialVersionUID = 1L;

    public Long gettFiletypeinfoId() {
        return tFiletypeinfoId;
    }

    public void settFiletypeinfoId(Long tFiletypeinfoId) {
        this.tFiletypeinfoId = tFiletypeinfoId;
    }

    public String gettFiletypeinfoName() {
        return tFiletypeinfoName;
    }

    public void settFiletypeinfoName(String tFiletypeinfoName) {
        this.tFiletypeinfoName = tFiletypeinfoName;
    }

    public String gettFiletypeinfoImage() {
        return tFiletypeinfoImage;
    }

    public void settFiletypeinfoImage(String tFiletypeinfoImage) {
        this.tFiletypeinfoImage = tFiletypeinfoImage;
    }

    public String gettFiletypeinfoSuffix() {
        return tFiletypeinfoSuffix;
    }

    public void settFiletypeinfoSuffix(String tFiletypeinfoSuffix) {
        this.tFiletypeinfoSuffix = tFiletypeinfoSuffix;
    }
}