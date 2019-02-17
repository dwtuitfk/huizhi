package com.huizhi.oa.entity;

import java.util.Date;

public class Meetinfo {
    private Integer mId;

    private String mTitle;

    private String mContent;

    private Integer mhId;

    private String mPeople;

    private Date mStarttime;

    private Integer mState;

    private Date mOvertime;

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle == null ? null : mTitle.trim();
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent == null ? null : mContent.trim();
    }

    public Integer getMhId() {
        return mhId;
    }

    public void setMhId(Integer mhId) {
        this.mhId = mhId;
    }

    public String getmPeople() {
        return mPeople;
    }

    public void setmPeople(String mPeople) {
        this.mPeople = mPeople == null ? null : mPeople.trim();
    }

    public Date getmStarttime() {
        return mStarttime;
    }

    public void setmStarttime(Date mStarttime) {
        this.mStarttime = mStarttime;
    }

    public Integer getmState() {
        return mState;
    }

    public void setmState(Integer mState) {
        this.mState = mState;
    }

    public Date getmOvertime() {
        return mOvertime;
    }

    public void setmOvertime(Date mOvertime) {
        this.mOvertime = mOvertime;
    }
}