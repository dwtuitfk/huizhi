package com.huizhi.oa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Carapplyinfo {
    private String caId;

    private Integer userid;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date caStarttime;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date caOvertime;

    private String caCId;

    private String caReason;

    private Integer caUserid;

    private Integer caState;

    private String caCheckad;

    private String depName;

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getTureName() {
        return tureName;
    }

    public void setTureName(String tureName) {
        this.tureName = tureName;
    }

    private String tureName;

    public String getCaId() {
        return caId;
    }

    public void setCaId(String caId) {
        this.caId = caId == null ? null : caId.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getCaStarttime() {
        return caStarttime;
    }

    public void setCaStarttime(Date caStarttime) {
        this.caStarttime = caStarttime;
    }

    public Date getCaOvertime() {
        return caOvertime;
    }

    public void setCaOvertime(Date caOvertime) {
        this.caOvertime = caOvertime;
    }

    public String getCaCId() {
        return caCId;
    }

    public void setCaCId(String caCId) {
        this.caCId = caCId == null ? null : caCId.trim();
    }

    public String getCaReason() {
        return caReason;
    }

    public void setCaReason(String caReason) {
        this.caReason = caReason == null ? null : caReason.trim();
    }

    public Integer getCaUserid() {
        return caUserid;
    }

    public void setCaUserid(Integer caUserid) {
        this.caUserid = caUserid;
    }

    public Integer getCaState() {
        return caState;
    }

    public void setCaState(Integer caState) {
        this.caState = caState;
    }

    public String getCaCheckad() {
        return caCheckad;
    }

    public void setCaCheckad(String caCheckad) {
        this.caCheckad = caCheckad == null ? null : caCheckad.trim();
    }
}