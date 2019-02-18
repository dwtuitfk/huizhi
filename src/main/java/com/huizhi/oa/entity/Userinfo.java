package com.huizhi.oa.entity;

public class Userinfo {
    private Integer userid;

    private String turename;

    private String password;

    private String phone;

    private String qq;

    private String email;

    private Integer age;

    private String sex;

    private String address;

    private Integer isprohibit;

    private Integer depName;

    public void setDepName(Integer depName) {
        this.depName = depName;
    }

    public Integer getDepName() {
        return depName;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getTurename() {
        return turename;
    }

    public void setTurename(String turename) {
        this.turename = turename == null ? null : turename.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getIsprohibit() {
        return isprohibit;
    }

    public void setIsprohibit(Integer isprohibit) {
        this.isprohibit = isprohibit;
    }
}