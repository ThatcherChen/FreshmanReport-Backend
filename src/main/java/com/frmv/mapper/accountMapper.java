package com.frmv.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frmv.entity.account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface accountMapper extends BaseMapper<account> {

    @Select("select * from account where phone=#{phone} and password=#{password}")
    account login(String phone, String password);

    @Delete("delete from account where phone=#{phone}")
    int logoff(String phone);

    @Update("update account set nickname=#{account.nickname}, password=#{account.password}, phone=#{account.phone} where phone=#{oldPhone}")
    int change(account account, String oldPhone);

    @Select("select * from account where phone = #{phone}")
    account queryAccount(String phone);

    @Select("select stu_id from account where phone = #{phone}")
    int queryStu_id(String phone);

}
