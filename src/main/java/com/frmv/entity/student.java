package com.frmv.entity;

import io.swagger.annotations.ApiModel;

import java.util.Date;
import java.util.Objects;

@ApiModel(value = "student", description = "学生信息")
public class student {
    private int id;
    private String name;
    private String gender;
    private String idNumber;
    private String region;
    private Date birthday;
    private String college;
    private String major;
    private String degree;
    private String interests;
    private String reportTime;
    private String traffic;

    public student(){};

    public student(student student) {
        this.id = student.id;
        this.name = student.name;
        this.gender = student.gender;
        this.idNumber = student.idNumber;
        this.region = student.region;
        this.birthday = student.birthday;
        this.college = student.college;
        this.major = student.major;
        this.degree = student.degree;
        this.interests = student.interests;
        this.reportTime = student.reportTime;
        this.traffic = student.traffic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        student student = (student) o;
        return id == student.id && Objects.equals(name, student.name) && Objects.equals(gender, student.gender) && Objects.equals(idNumber, student.idNumber) && Objects.equals(region, student.region) && Objects.equals(birthday, student.birthday) && Objects.equals(college, student.college) && Objects.equals(major, student.major) && Objects.equals(degree, student.degree) && Objects.equals(interests, student.interests) && Objects.equals(reportTime, student.reportTime) && Objects.equals(traffic, student.traffic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, idNumber, region, birthday, college, major, degree, interests, reportTime, traffic);
    }

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

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
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

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

}
