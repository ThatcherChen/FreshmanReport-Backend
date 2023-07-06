package com.frmv.entity;

import io.swagger.annotations.ApiModel;

import java.util.Date;

@ApiModel(value = "bind", description = "绑定学生和账号")
public class bind {
    private int id;
    private String name;
    private String gender;
    private String idNumber;
    private String region;
    private Date birthday;
    private String major;
    private String interests;
    private String reportTime;
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "bind{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", region='" + region + '\'' +
                ", birthday=" + birthday +
                ", major='" + major + '\'' +
                ", interests='" + interests + '\'' +
                ", reportTime='" + reportTime + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
