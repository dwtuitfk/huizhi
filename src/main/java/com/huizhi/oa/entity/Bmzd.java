package com.huizhi.oa.entity;

import java.io.Serializable;

public class Bmzd implements Serializable {
    private Integer bmzdid;

    private Integer depname;

    private String depnamemc;

    public Integer getBmzdid() {
        return bmzdid;
    }

    public void setBmzdid(Integer bmzdid) {
        this.bmzdid = bmzdid;
    }

    public Integer getDepname() {
        return depname;
    }

    public void setDepname(Integer depname) {
        this.depname = depname;
    }

    public String getDepnamemc() {
        return depnamemc;
    }

    public void setDepnamemc(String depnamemc) {
        this.depnamemc = depnamemc == null ? null : depnamemc.trim();
    }
}