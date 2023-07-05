package com.frmv.entity;

public class interests {
    private String interest;
    private Long count;

    public interests(String interest, Long count) {
        this.interest = interest;
        this.count = count;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
