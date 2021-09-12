package com.icss.pojo;

import java.io.Serializable;

/**
 * T_BRANCHINFO
 * @author 
 */
public class TBranchinfo implements Serializable {
    private Long tBranchinfoId;

    /**
     * 机构名字
     */
    private String tBranchinfoName;

    /**
     * 机构短名
     */
    private String tBranchinfoShortname;

    private static final long serialVersionUID = 1L;

    public Long gettBranchinfoId() {
        return tBranchinfoId;
    }

    public void settBranchinfoId(Long tBranchinfoId) {
        this.tBranchinfoId = tBranchinfoId;
    }

    public String gettBranchinfoName() {
        return tBranchinfoName;
    }

    public void settBranchinfoName(String tBranchinfoName) {
        this.tBranchinfoName = tBranchinfoName;
    }

    public String gettBranchinfoShortname() {
        return tBranchinfoShortname;
    }

    public void settBranchinfoShortname(String tBranchinfoShortname) {
        this.tBranchinfoShortname = tBranchinfoShortname;
    }
}