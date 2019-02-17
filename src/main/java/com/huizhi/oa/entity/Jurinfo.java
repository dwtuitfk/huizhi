package com.huizhi.oa.entity;

public class Jurinfo {
    private Integer jurid;

    private String fname;

    public Integer getJurid() {
        return jurid;
    }

    public void setJurid(Integer jurid) {
        this.jurid = jurid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }
}