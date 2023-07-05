package com.frmv.controller;

import com.frmv.entity.*;
import com.frmv.mapper.accountMapper;
import com.frmv.mapper.studentMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "student表接口")
@RestController
public class studentController {

    @Autowired
    private studentMapper stuMapper;
    @Autowired
    private accountMapper accMapper;

    @ApiOperation(value = "查询收集到的所有学生信息", notes = "输入: 无")
    @GetMapping("/queryAll")
    public List<student> queryAll() {
        return stuMapper.selectList(null);
    }

    @ApiOperation(value = "信息收集并且自动绑定账号", notes = "输入: student对象+phone")
    @PostMapping("/infoCollect")
    public result infoCollect(@RequestBody bind bind) {
        result res = new result();
        student student = new student();
        student.setName(bind.getName());
        student.setGender(bind.getGender());
        student.setId_number(bind.getId_number());
        student.setRegion(bind.getRegion());
        student.setBirthday(bind.getBirthday());
        student.setMajor(bind.getMajor());
        student.setReport_time(bind.getReport_time());
        String phone = bind.getPhone();
        try {
            int i = stuMapper.insert(student);
            int id = stuMapper.queryID(student.getId_number());
            student.setId(id);
            int j = stuMapper.bind(id, phone);
            if (i <= 0) {
                res.setStatus(false);
                res.setResult("插入student信息失败！");
            }
            else if (j <= 0) {
                stuMapper.deleteById(id);
                res.setStatus(false);
                res.setResult("绑定账号失败！");
            } else {
                res.setStatus(true);
                res.setResult("信息收集成功！");
            }
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("出现异常: " + e.getMessage());
            return res;
        }
    }

    @ApiOperation(value = "查询学生是否完成信息收集，是则返回学生信息，否则返回0", notes = "输入: phone")
    @PostMapping("/queryStudent")
    public result queryStudent(@RequestBody account account){
        result res = new result();
        try{
            int stu_id = accMapper.queryStu_id(account.getPhone());
            if (stu_id == 0) {
                res.setStatus(true);
                res.setResult(0);
                return res;
            }
            student student = stuMapper.queryStudent(stu_id);
            res.setStatus(true);
            res.setResult(student);
            return res;
        } catch (DataAccessException e){
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("出现异常: " + e.getMessage());
            return res;
        }
    }

    @ApiOperation(value = "查询已完成信息收集的人数", notes = "输入: 无")
    @GetMapping("/countNumber")
    public int countNumber(){
        return stuMapper.countNumber()-1;
    }

    @ApiOperation(value = "查询男女人数", notes = "输入: 无")
    @GetMapping("/countGender")
    public List<gender> countGender() {
        return stuMapper.countGender();
    }

    @ApiOperation(value = "查询各专业人数", notes = "输入: 无")
    @GetMapping("/countMajor")
    public List<major> countMajor() {
        return stuMapper.countMajor();
    }

    @ApiOperation(value = "查询各专业性别人数", notes = "输入: 无")
    @GetMapping("/countMajorGender")
    public List<majorGender> countMajorGender() {
        return stuMapper.countMajorGender();
    }

    @ApiOperation(value = "查询各兴趣人数", notes = "输入: 无")
    @GetMapping("/countInterest")
    public List<interests> countInterest() {
        List<interests> numbers = new ArrayList<>();
        // 调用方法查询所有的 interests 数据
        List<String> interests = stuMapper.queryInterest();
        // 统计各兴趣个数
        Map<String, Long> interestCounts = new HashMap<>();
        for (String interest : interests) {
            String[] interestArr = interest.split(",");
            for (String value : interestArr) {
                String trimmedValue = value.trim();
                interestCounts.put(trimmedValue, interestCounts.getOrDefault(trimmedValue, 0L) + 1);
            }
        }
        // 将统计结果转换为 List<Interest> 格式
        for (Map.Entry<String, Long> entry : interestCounts.entrySet()) {
            numbers.add(new interests(entry.getKey(), entry.getValue()));
        }
        return numbers;
    }

    @ApiOperation(value = "查询各地区来源人数", notes = "输入: 无")
    @GetMapping("/countRegion")
    public List<region> countRegion() {
        List<region> numbers = new ArrayList<>();
        List<String> regionStrs = stuMapper.queryRegion();
        Map<String, Long> regionCounts = new HashMap<>();
        for (String regionStr: regionStrs) {
            String[] subStr = regionStr.split("-");
            for (String part: subStr) {
                if (part.endsWith("市")) {
                    regionCounts.put(part, regionCounts.getOrDefault(part, 0L) + 1);
                }
            }
        }
        for (Map.Entry<String, Long> entry : regionCounts.entrySet()) {
            numbers.add(new region(entry.getKey(), entry.getValue()));
        }
        return numbers;
    }

    @ApiOperation(value = "批量查询student信息", notes = "输入: 无")
    @GetMapping("/queryBatchStudent")
    public List<student> queryBatchStudent(Integer batch) {
        if (batch == null) {
            batch = 10;
        }
        return stuMapper.queryBatchStudent(batch);
    }

}
