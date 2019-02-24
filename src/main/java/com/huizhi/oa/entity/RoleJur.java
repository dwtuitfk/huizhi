package com.huizhi.oa.entity;

import java.io.Serializable;

public class RoleJur implements Serializable {
    private Integer roleid;

    private Integer jurid;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getJurid() {
        return jurid;
    }

    public void setJurid(Integer jurid) {
        this.jurid = jurid;
    }
}