package com.frmv.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frmv.entity.*;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface studentMapper extends BaseMapper<student> {

    @Select("select id from student where id_number = #{id_number}")
    int queryID(String id_number);

    @Update("update account set stu_id = #{id} where phone = #{phone}")
    int bind(int id, String phone);

    @Select("select * from student where id = #{stu_id}")
    student queryStudent(int stu_id);

    @Select("SELECT COUNT(*) FROM student where id != 0")
    int countNumber();

    @Select("SELECT gender, COUNT(*) AS count FROM student WHERE gender IN ('男', '女') GROUP BY gender")
    List<gender> countGender();

    @Select("SELECT college, COUNT(*) AS count FROM student where college is not null GROUP BY college")
    List<college> countCollege();

    @Select("SELECT college, gender, COUNT(*) AS count FROM student WHERE gender IN ('男', '女') GROUP BY college, gender")
    List<collegeGender> countCollegeGender();

    @Select("SELECT college, degree, COUNT(*) AS count FROM student GROUP BY college, degree")
    List<collegeDegree> countCollegeDegree();

    @Select("SELECT college, degree, COUNT(*) AS count FROM student where college = #{name} GROUP BY college, degree")
    List<collegeDegree> countOneCollegeDegree(String name);

    @Select("SELECT major, COUNT(*) AS count FROM student where major is not null GROUP BY major")
    List<major> countMajor();

    @Select("SELECT major, gender, COUNT(*) AS count FROM student WHERE gender IN ('男', '女') GROUP BY major, gender")
    List<majorGender> countMajorGender();

    @Select("SELECT degree, COUNT(*) AS count FROM student where degree is not null GROUP BY degree")
    List<degree> countDegree();

    @Select("SELECT interests from student where interests is not null")
    List<String> queryInterest();

    @Select("SELECT region from student where region is not null")
    List<String> queryRegion();

    @Select("select * from (SELECT * FROM student ORDER BY id DESC LIMIT #{batch}) AS subQuery ORDER BY subQuery.id ASC")
    List<student> queryBatchStudent(int batch);

    @Select("SELECT traffic, COUNT(*) AS count FROM student where traffic is not null GROUP BY traffic")
    List<traffic> countTraffic();

}
