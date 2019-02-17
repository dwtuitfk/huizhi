package com.huizhi.oa.entity;

import java.util.Date;

public class Emailinfo {
    private String eId;

    private String eTitle;

    private Date eTime;

    private Integer eSendid;

    private Integer eAcceptid;

    private String eCopyid;

    private String eContent;

    private Integer eState;

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId == null ? null : eId.trim();
    }

    public String geteTitle() {
        return eTitle;
    }

    public void seteTitle(String eTitle) {
        this.eTitle = eTitle == null ? null : eTitle.trim();
    }

    public Date geteTime() {
        return eTime;
    }

    public void seteTime(Date eTime) {
        this.eTime = eTime;
    }

    public Integer geteSendid() {
        return eSendid;
    }

    public void seteSendid(Integer eSendid) {
        this.eSendid = eSendid;
    }

    public Integer geteAcceptid() {
        return eAcceptid;
    }

    public void seteAcceptid(Integer eAcceptid) {
        this.eAcceptid = eAcceptid;
    }

    public String geteCopyid() {
        return eCopyid;
    }

    public void seteCopyid(String eCopyid) {
        this.eCopyid = eCopyid == null ? null : eCopyid.trim();
    }

    public String geteContent() {
        return eContent;
    }

    public void seteContent(String eContent) {
        this.eContent = eContent == null ? null : eContent.trim();
    }

    public Integer geteState() {
        return eState;
    }

    public void seteState(Integer eState) {
        this.eState = eState;
    }
}