package com.huizhi.oa.entity;

import java.util.Date;

public class Attendanceinfo {
    private Integer aId;

    private Integer userid;

    private Date aMtime;

    private Date aAtime;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getaMtime() {
        return aMtime;
    }

    public void setaMtime(Date aMtime) {
        this.aMtime = aMtime;
    }

    public Date getaAtime() {
        return aAtime;
    }

    public void setaAtime(Date aAtime) {
        this.aAtime = aAtime;
    }
}