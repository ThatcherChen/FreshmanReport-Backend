package com.frmv.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "region", description = "来源地区")
public class region {
    private String region;
    private Long count;

    public region(String region, Long count) {
        this.region = region;
        this.count = count;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
