package com.huizhi.oa.entity;

import java.util.Date;

public class Houseapplyinfo {
    private Integer haId;

    private Integer userid;

    private Date haStarttime;

    private String haReason;

    private Integer haUserid;

    private Integer haMhId;

    private Integer haState;

    private String haCheckad;

    private Integer haMId;

    public Integer getHaId() {
        return haId;
    }

    public void setHaId(Integer haId) {
        this.haId = haId;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getHaStarttime() {
        return haStarttime;
    }

    public void setHaStarttime(Date haStarttime) {
        this.haStarttime = haStarttime;
    }

    public String getHaReason() {
        return haReason;
    }

    public void setHaReason(String haReason) {
        this.haReason = haReason == null ? null : haReason.trim();
    }

    public Integer getHaUserid() {
        return haUserid;
    }

    public void setHaUserid(Integer haUserid) {
        this.haUserid = haUserid;
    }

    public Integer getHaMhId() {
        return haMhId;
    }

    public void setHaMhId(Integer haMhId) {
        this.haMhId = haMhId;
    }

    public Integer getHaState() {
        return haState;
    }

    public void setHaState(Integer haState) {
        this.haState = haState;
    }

    public String getHaCheckad() {
        return haCheckad;
    }

    public void setHaCheckad(String haCheckad) {
        this.haCheckad = haCheckad == null ? null : haCheckad.trim();
    }

    public Integer getHaMId() {
        return haMId;
    }

    public void setHaMId(Integer haMId) {
        this.haMId = haMId;
    }
}