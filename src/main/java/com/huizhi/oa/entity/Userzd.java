package com.huizhi.oa.entity;

import java.io.Serializable;

public class Userzd implements Serializable {
    private Integer userzdid;

    private Integer rolename;

    private String rolenamemc;

    public Integer getUserzdid() {
        return userzdid;
    }

    public void setUserzdid(Integer userzdid) {
        this.userzdid = userzdid;
    }

    public Integer getRolename() {
        return rolename;
    }

    public void setRolename(Integer rolename) {
        this.rolename = rolename;
    }

    public String getRolenamemc() {
        return rolenamemc;
    }

    public void setRolenamemc(String rolenamemc) {
        this.rolenamemc = rolenamemc == null ? null : rolenamemc.trim();
    }
}