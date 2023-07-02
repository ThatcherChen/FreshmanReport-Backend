package com.frmv.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "change", description = "后端返回结果")
public class result {
    private Boolean status;
    private Object result;
}
