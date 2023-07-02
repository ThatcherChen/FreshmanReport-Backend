package com.frmv.controller;

import com.frmv.entity.student;
import com.frmv.mapper.studentMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "student表接口")
@RestController
public class studentController {

    @Autowired
    private studentMapper mapper;

    @ApiOperation(value = "查询所有数据")
    @GetMapping("/student/selectAll")
    public List selectAll(){
        List<student> studentList = mapper.selectList(null);
        return studentList;
    }

    // 信息采集
//    @PostMapping("/infoCollect")


}
