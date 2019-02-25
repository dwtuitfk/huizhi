package com.huizhi.oa.entity;

import java.io.Serializable;

/**
 * created by dwtuitfk on 2019/2/19.
 */
public class UserJur implements Serializable {

    private Integer userId;

    private String tureName;

    private String fName;

    private String finfo;

    private String depNamemc;

    public String getFinfo() {
        return finfo;
    }

    public void setFinfo(String finfo) {
        this.finfo = finfo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTureName() {
        return tureName;
    }

    public void setTureName(String tureName) {
        this.tureName = tureName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getDepNamemc() {
        return depNamemc;
    }

    public void setDepNamemc(String depNamemc) {
        this.depNamemc = depNamemc;
    }
}
