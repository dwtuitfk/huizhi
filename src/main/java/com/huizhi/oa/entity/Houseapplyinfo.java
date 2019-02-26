package com.huizhi.oa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Houseapplyinfo {
    private Integer haId;

    private Integer userid;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date haStarttime;

    private String haReason;

    private Integer haUserid;

    private Integer haMhId;

    private Integer haState;

    private String haCheckad;

    private Integer haMId;
    /**
     * 会议室名称
     */
    private String mhAddress;
    /**
     * 会议室状态名称
     */
    private String state;
    /**
     * 审核人员
     */
    private String roleNamemc;
    /**
     * 申请人姓名
     */
    private String tureName;

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

    public String getMhAddress() {
        return mhAddress;
    }

    public void setMhAddress(String mhAddress) {
        this.mhAddress = mhAddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRoleNamemc() {
        return roleNamemc;
    }

    public void setRoleNamemc(String roleNamemc) {
        this.roleNamemc = roleNamemc;
    }

    public String getTureName() {
        return tureName;
    }

    public void setTureName(String tureName) {
        this.tureName = tureName;
    }
}