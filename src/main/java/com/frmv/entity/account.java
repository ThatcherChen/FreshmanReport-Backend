package com.frmv.entity;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "account", description = "账号")
public class account {
    private int id;
    private String nickname;
    private String password;
    private String phone;
    private int head_picture;
    private int stu_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getHead_picture() {
        return head_picture;
    }

    public void setHead_picture(int head_picture) {
        this.head_picture = head_picture;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    @Override
    public String toString() {
        return "account{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", head_picture=" + head_picture +
                ", stu_id=" + stu_id +
                '}';
    }
}
