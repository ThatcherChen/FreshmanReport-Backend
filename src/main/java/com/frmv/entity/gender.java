package com.frmv.entity;

public class gender {
    private String gender;
    private Long count;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "gender{" +
                "gender='" + gender + '\'' +
                ", count=" + count +
                '}';
    }
}
