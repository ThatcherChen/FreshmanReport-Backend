package com.frmv.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frmv.entity.student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface studentMapper extends BaseMapper<student> {
}
