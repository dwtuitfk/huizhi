package com.huizhi.oa.entity;

import java.io.Serializable;

public class Roleinfo implements Serializable {
    private Integer roleid;

    private Integer rolename;

    private Integer depname;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getRolename() {
        return rolename;
    }

    public void setRolename(Integer rolename) {
        this.rolename = rolename;
    }

    public Integer getDepname() {
        return depname;
    }

    public void setDepname(Integer depname) {
        this.depname = depname;
    }
}