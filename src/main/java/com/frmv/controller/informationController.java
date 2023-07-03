package com.frmv.controller;

import com.frmv.entity.information;
import com.frmv.entity.result;
import com.frmv.entity.student;
import com.frmv.mapper.informationMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "student表接口")
@RestController
public class informationController {

    @Autowired
    private informationMapper mapper;

    @ApiOperation(value = "查询所有数据(测试用)")
    @GetMapping("/student/selectAll")
    public List selectAll(){
        List<student> studentList = mapper.selectList(null);
        return studentList;
    }

    @ApiOperation(value = "信息收集", notes = "student对象+兴趣  ")
    @PostMapping("/infoCollect")
    public result infoCollect(@RequestBody information info){
        result res = new result();
        student stu = new student();
        stu.setName(info.getName());
        stu.setGender(info.getGender());
        stu.setid_number(info.getId_number());
        stu.setRegion(info.getRegion());
        stu.setBirthday(info.getBirthday());
        stu.setMajor(info.getMajor());
        List<String> interests = info.getInterest();
        String id_number = info.getId_number();
        int stu_id;
        List<Integer> interests_id = new ArrayList<>();
        res.setStatus(true);
        res.setResult("信息收集成功！");
        // 插入student表
        try{
            int i  = mapper.insert(stu);
            if(i <= 0){
                res.setStatus(false);
                res.setResult("插入student表失败！");
            }
        } catch (Exception e){
            mapper.rollback(id_number);
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("出现异常: " + e.getMessage());
            return res;
        }
        // 查询学生id
        try{
            stu_id = mapper.select_student_id(id_number);
        } catch (Exception e){
            mapper.rollback(id_number);
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("出现异常: " + e.getMessage());
            return res;
        }
        // 查询兴趣id
        try{
            for(String interest: interests){
                int id = mapper.select_interest_id(interest);
                if(id == 0){
                    return res;
                }
                else{
                    interests_id.add(id);
                }
            }
        } catch (Exception e){
            mapper.rollback(id_number);
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("出现异常: " + e);
            return res;
        }
        // 插入stu_interest表
        try{
            for(int interest_id: interests_id){
                int i = mapper.insert_stu_interest(stu_id, interest_id);
                if(i < 0){
                    return res;
                }
            }
        } catch (Exception e){
            mapper.rollback(id_number);
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("出现异常: " + e.getMessage());
            return res;
        }
        return res;
    }


}
