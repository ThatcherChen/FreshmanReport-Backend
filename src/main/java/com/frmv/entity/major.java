package com.frmv.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "major", description = "专业")
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
