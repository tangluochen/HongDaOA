package com.icss.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * T_ACCESSORYFILE
 * 附件文件
 * @author 
 */
public class TAccessoryfile implements Serializable {
    private Long tAccessoryfileId;

    /**
     * 文件信息ID
     */
    private TFileinfo tFileinfo;

    /**
     * 文件名字
     */
    private String tAccessoryfileName;

    /**
     * 文件大小
     */
    private Long tAccessoryfileSize;

    /**
     * 文件类型ID
     */
    private TFiletypeinfo tFiletypeinfo;

    /**
     * 创建时间
     */
    private Date tAccessoryfileCreatedate;

    /**
     * 文件路径
     */
    private String tAccessoryfilePath;
    /**
     * 序列化ID值
     */
    private static final long serialVersionUID = 1L;

    public Long gettAccessoryfileId() {
        return tAccessoryfileId;
    }

    public void settAccessoryfileId(Long tAccessoryfileId) {
        this.tAccessoryfileId = tAccessoryfileId;
    }


    public String gettAccessoryfileName() {
        return tAccessoryfileName;
    }

    public void settAccessoryfileName(String tAccessoryfileName) {
        this.tAccessoryfileName = tAccessoryfileName;
    }

    public Long gettAccessoryfileSize() {
        return tAccessoryfileSize;
    }

    public void settAccessoryfileSize(Long tAccessoryfileSize) {
        this.tAccessoryfileSize = tAccessoryfileSize;
    }


    public Date gettAccessoryfileCreatedate() {
        return tAccessoryfileCreatedate;
    }

    public void settAccessoryfileCreatedate(Date tAccessoryfileCreatedate) {
        this.tAccessoryfileCreatedate = tAccessoryfileCreatedate;
    }

    public String gettAccessoryfilePath() {
        return tAccessoryfilePath;
    }

    public void settAccessoryfilePath(String tAccessoryfilePath) {
        this.tAccessoryfilePath = tAccessoryfilePath;
    }

    public TFileinfo gettFileinfo() {
        return tFileinfo;
    }

    public void settFileinfo(TFileinfo tFileinfo) {
        this.tFileinfo = tFileinfo;
    }

    public TFiletypeinfo gettFiletypeinfo() {
        return tFiletypeinfo;
    }

    public void settFiletypeinfo(TFiletypeinfo tFiletypeinfo) {
        this.tFiletypeinfo = tFiletypeinfo;
    }
}