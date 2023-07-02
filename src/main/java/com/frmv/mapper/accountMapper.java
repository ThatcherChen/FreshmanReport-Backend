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
    List<account> login(String phone, String password);

    @Delete("delete from account where phone=#{phone}")
    int logoff(String phone);

    @Update("update account set nickname=#{newNickname} where phone=#{phone}")
    int changeNickname(String phone, String newNickname);

    @Update("update account set password=#{newPassword} where phone=#{phone}")
    int changePassword(String phone, String newPassword);

    @Update("update account set phone=#{newPhone} where phone=#{phone}")
    int changePhone(String phone, String newPhone);

    @Update("update account set headPicture=#{newHeadPicture} where phone=#{phone}")
    int changeHeadPicture(String phone, String newHeadPicture);
}
