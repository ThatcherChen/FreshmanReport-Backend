package com.frmv.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frmv.entity.account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


@Repository
public interface accountMapper extends BaseMapper<account> {

    @Select("select * from account where phone=#{phone} and password=#{password}")
    account login(String phone, String password);

    @Insert("insert into account(nickname, password, phone) values (#{account.nickname},#{account.password},#{account.phone})")
    int signup(account account, String i);

    @Delete("delete from account where phone=#{phone}")
    int logoff(String phone);

    @Update("update account set nickname=#{account.nickname}, password=#{account.password}, phone=#{account.phone} where phone=#{oldPhone}")
    int change(account account, String oldPhone);

    @Select("select * from account where phone = #{phone}")
    account queryAccountByPhone(String phone);

    @Select("select * from account where stu_id = #{id}")
    account queryAccountByID(int id);

    @Select("select stu_id from account where phone = #{phone}")
    int queryStu_id(String phone);

    @Update("update account set head_picture=#{headPicture} where phone=#{phone}")
    int chooseHeadPicture(int headPicture, String phone);
}
