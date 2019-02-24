package com.huizhi.oa.entity;

import java.io.Serializable;

public class Jurinfo implements Serializable {

    private Integer jurid;

    private String fname;

    private String finfo;

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

    public String getFinfo() {
        return finfo;
    }

    public void setFinfo(String finfo) {
        this.finfo = finfo == null ? null : finfo.trim();
    }
}