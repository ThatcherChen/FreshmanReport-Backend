package com.frmv.controller;

import com.frmv.entity.result;
import com.frmv.entity.student;
import com.frmv.mapper.studentMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "student表接口")
@RestController
public class studentController {

    @Autowired
    private studentMapper mapper;

    @ApiOperation(value = "查询所有数据(测试用)")
    @GetMapping("/student/selectAll")
    public List selectAll(){
        List<student> studentList = mapper.selectList(null);
        return studentList;
    }

    @ApiOperation(value = "信息收集", notes = "param: student对象")
    @PostMapping("/infoCollect")
    public result infoCollect(@RequestBody student student) {
        result res = new result();
        try {
            int i = mapper.insert(student);
            if (i > 0) {
                res.setStatus(true);
                res.setResult("提交成功！");
            } else {
                res.setStatus(false);
                res.setResult("提交失败！");
            }
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("出现异常: " + e.getMessage());
            return res;
        }
    }
}
