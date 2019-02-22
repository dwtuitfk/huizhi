package com.huizhi.oa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Tiaoxiuinfo {
    private Integer txId;

    private Integer userid;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date txStarttime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date txOvertime;

    private String txReason;

    private Integer txUserid;

    private Integer txState;

    private String txCheckad;

    private String tureName;

    public void setTureName(String tureName) {
        this.tureName = tureName;
    }

    public String getTureName() {
        return tureName;
    }

    public Integer getTxId() {
        return txId;
    }

    public void setTxId(Integer txId) {
        this.txId = txId;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getTxStarttime() {
        return txStarttime;
    }

    public void setTxStarttime(Date txStarttime) {
        this.txStarttime = txStarttime;
    }

    public Date getTxOvertime() {
        return txOvertime;
    }

    public void setTxOvertime(Date txOvertime) {
        this.txOvertime = txOvertime;
    }

    public String getTxReason() {
        return txReason;
    }

    public void setTxReason(String txReason) {
        this.txReason = txReason == null ? null : txReason.trim();
    }

    public Integer getTxUserid() {
        return txUserid;
    }

    public void setTxUserid(Integer txUserid) {
        this.txUserid = txUserid;
    }

    public Integer getTxState() {
        return txState;
    }

    public void setTxState(Integer txState) {
        this.txState = txState;
    }

    public String getTxCheckad() {
        return txCheckad;
    }

    public void setTxCheckad(String txCheckad) {
        this.txCheckad = txCheckad == null ? null : txCheckad.trim();
    }
}