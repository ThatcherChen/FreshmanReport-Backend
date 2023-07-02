package com.frmv.entity;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "account", description = "账号")
public class account {
    private int id;
    private String nickname;
    private String password;
    private String phone;
    private int headPicture;
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

    public int getHeadPicture() {
        return headPicture;
    }

    public void setHeadPicture(int headPicture) {
        this.headPicture = headPicture;
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
                ", headPicture=" + headPicture +
                ", stu_id=" + stu_id +
                '}';
    }
}