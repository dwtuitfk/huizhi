package com.huizhi.oa.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class AllApply {
    //申请人
    private Integer userId;
    //开始时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date startTime;
    //结束时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date overTime;
    //申请原因
    private String reason;
    //审核人
    private Integer checkId;
    //审批状态
    private Integer state;
    //审批建议
    private String checkAd;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getOverTime() {
        return overTime;
    }

    public void setOverTime(Date overTime) {
        this.overTime = overTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCheckAd() {
        return checkAd;
    }

    public void setCheckAd(String checkAd) {
        this.checkAd = checkAd;
    }
}
