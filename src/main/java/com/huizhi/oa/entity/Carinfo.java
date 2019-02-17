package com.huizhi.oa.entity;

import java.util.Date;

public class Carinfo {
    private String cId;

    private String cType;

    private Integer cState;

    private String cInsurance;

    private Date cMaintaintime;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType == null ? null : cType.trim();
    }

    public Integer getcState() {
        return cState;
    }

    public void setcState(Integer cState) {
        this.cState = cState;
    }

    public String getcInsurance() {
        return cInsurance;
    }

    public void setcInsurance(String cInsurance) {
        this.cInsurance = cInsurance == null ? null : cInsurance.trim();
    }

    public Date getcMaintaintime() {
        return cMaintaintime;
    }

    public void setcMaintaintime(Date cMaintaintime) {
        this.cMaintaintime = cMaintaintime;
    }
}