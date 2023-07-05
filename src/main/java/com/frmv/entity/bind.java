package com.frmv.entity;

import io.swagger.annotations.ApiModel;

import java.util.Date;

@ApiModel(value = "bind", description = "绑定学生和账号")
public class bind {
    private int id;
    private String name;
    private String gender;
    private String id_number;
    private String region;
    private Date birthday;
    private String major;
    private String interests;
    private String report_time;
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

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
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

    public String getReport_time() {
        return report_time;
    }

    public void setReport_time(String report_time) {
        this.report_time = report_time;
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
                ", id_number='" + id_number + '\'' +
                ", region='" + region + '\'' +
                ", birthday=" + birthday +
                ", major='" + major + '\'' +
                ", interests='" + interests + '\'' +
                ", report_time='" + report_time + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
