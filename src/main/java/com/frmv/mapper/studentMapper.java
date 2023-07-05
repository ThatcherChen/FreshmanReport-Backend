package com.frmv.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frmv.entity.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface studentMapper extends BaseMapper<student> {

    @Select("select id from student where id_number = #{id_number}")
    int queryID(String id_number);

    @Update("update account set stu_id = #{id} where phone = #{phone}")
    int bind(int id, String phone);

    @Select("select * from student where id = #{stu_id}")
    student queryStudent(int stu_id);

    @Select("SELECT COUNT(*) FROM student")
    int countNumber();

    @Select("SELECT gender, COUNT(*) AS count FROM student WHERE gender IN ('男', '女') GROUP BY gender")
    List<gender> countGender();

    @Select("SELECT major, COUNT(*) AS count FROM student GROUP BY major")
    List<major> countMajor();

    @Select("SELECT interests from student where interests is not null")
    List<String> queryInterest();

    @Select("SELECT region from student where region is not null")
    List<String> queryRegion();
}
