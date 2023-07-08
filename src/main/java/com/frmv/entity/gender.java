package com.frmv.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "gender", description = "性别")
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
