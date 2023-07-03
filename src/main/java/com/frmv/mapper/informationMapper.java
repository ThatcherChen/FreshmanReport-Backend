package com.frmv.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frmv.entity.student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface informationMapper extends BaseMapper<student> {

    @Select("select id from interest where name = #{interest}")
    int select_interest_id(String interest);

    @Select("select id from student where id_number = #{id_number}")
    int select_student_id(String id_number);

    @Delete("delete from student where id_number = #{id_number}")
    int rollback(String id_number);

    @Insert("insert into stu_interest(student_id, interest_id) values(#{stu_id}, #{interest_id})")
    int insert_stu_interest(int stu_id, int interest_id);


}
