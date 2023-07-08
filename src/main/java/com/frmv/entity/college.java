package com.frmv.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "college", description = "学院")
public class college {
    private String college;
    private Long count;
    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
