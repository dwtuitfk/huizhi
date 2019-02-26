package com.huizhi.oa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Attendanceinfo {
    private Integer aId;

    private Integer userid;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date aMtime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date aAtime;

    private String tureName;

    private String mtimeRemarkes;

    private String atimeRemarkes;

    private String selectTime;

    public void setMtimeRemarkes(String mtimeRemarkes) {
        this.mtimeRemarkes = mtimeRemarkes;
    }

    public void setAtimeRemarkes(String atimeRemarkes) {
        this.atimeRemarkes = atimeRemarkes;
    }

    public void setSelectTime(String selectTime) {
        this.selectTime = selectTime;
    }

    public String getMtimeRemarkes() {
        return mtimeRemarkes;
    }

    public String getAtimeRemarkes() {
        return atimeRemarkes;
    }

    public String getSelectTime() {
        return selectTime;
    }

    public void setTureName(String tureName) {
        this.tureName = tureName;
    }

    public String getTureName() {
        return tureName;
    }

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