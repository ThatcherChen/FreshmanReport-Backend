package com.frmv.entity;

public class major {
    private String major;
    private Long count;

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "major{" +
                "major='" + major + '\'' +
                ", count=" + count +
                '}';
    }
}
