package com.frmv.entity;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "change", description = "修改数据")
public class change {
    private String phone;
    private String newNickname;
    private String newPassword;
    private String newPhone;
    private String newHeadPicture;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNewNickname() {
        return newNickname;
    }

    public void setNewNickname(String newNickname) {
        this.newNickname = newNickname;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPhone() {
        return newPhone;
    }

    public void setNewPhone(String newPhone) {
        this.newPhone = newPhone;
    }

    public String getNewHeadPicture() {
        return newHeadPicture;
    }

    public void setNewHeadPicture(String newHeadPicture) {
        this.newHeadPicture = newHeadPicture;
    }

    @Override
    public String toString() {
        return "change{" +
                "phone='" + phone + '\'' +
                ", newNickname='" + newNickname + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", newPhone='" + newPhone + '\'' +
                ", newHeadPicture='" + newHeadPicture + '\'' +
                '}';
    }
}
