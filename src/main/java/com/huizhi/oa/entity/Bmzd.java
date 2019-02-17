package com.huizhi.oa.entity;

public class Bmzd {
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