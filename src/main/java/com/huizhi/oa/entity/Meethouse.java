package com.huizhi.oa.entity;

public class Meethouse {
    private Integer mhId;

    private String mhName;

    private String mhAddress;

    private Integer mhState;

    public Integer getMhId() {
        return mhId;
    }

    public void setMhId(Integer mhId) {
        this.mhId = mhId;
    }

    public String getMhName() {
        return mhName;
    }

    public void setMhName(String mhName) {
        this.mhName = mhName == null ? null : mhName.trim();
    }

    public String getMhAddress() {
        return mhAddress;
    }

    public void setMhAddress(String mhAddress) {
        this.mhAddress = mhAddress == null ? null : mhAddress.trim();
    }

    public Integer getMhState() {
        return mhState;
    }

    public void setMhState(Integer mhState) {
        this.mhState = mhState;
    }
}