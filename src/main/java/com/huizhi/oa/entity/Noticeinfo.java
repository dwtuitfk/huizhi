package com.huizhi.oa.entity;

import java.util.Date;

public class Noticeinfo {
    private Integer nId;

    private Integer userid;

    private String nTitle;

    private Date nTime;

    private String nContent;

    public Integer getnId() {
        return nId;
    }

    public void setnId(Integer nId) {
        this.nId = nId;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getnTitle() {
        return nTitle;
    }

    public void setnTitle(String nTitle) {
        this.nTitle = nTitle == null ? null : nTitle.trim();
    }

    public Date getnTime() {
        return nTime;
    }

    public void setnTime(Date nTime) {
        this.nTime = nTime;
    }

    public String getnContent() {
        return nContent;
    }

    public void setnContent(String nContent) {
        this.nContent = nContent == null ? null : nContent.trim();
    }
}