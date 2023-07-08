package com.frmv.controller;

import com.frmv.entity.account;
import com.frmv.entity.change;
import com.frmv.entity.result;
import com.frmv.entity.student;
import com.frmv.mapper.accountMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "account表接口")
@RestController
public class accountController {
    @Autowired
    private accountMapper mapper;

    @ApiOperation(value = "登录账号", notes = "输入: phone, password")
    @PostMapping("/login")
    public result login(@RequestBody account account){
        result res = new result();
        String phone = account.getPhone();
        String password = account.getPassword();
        try{
            account account1 = mapper.login(phone, password);
            if(account1 == null){
                res.setStatus(false);
                res.setResult("手机号码或是密码错误！");
                return res;
            }
            res.setStatus(true);
            res.setResult(account1);
            return res;
        } catch (DataAccessException e){
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("出现异常: " + e.getMessage());
            return res;
        }
    }

    @ApiOperation(value = "注册账号", notes = "param: account对象")
    @PostMapping("/signup")
    public result signup(@RequestBody account account){
        result res = new result();
        try{
            int i = mapper.signup(account, "i");
            if(i > 0){
                res.setStatus(true);
                res.setResult("注册成功！");
                return res;
            }
            res.setStatus(false);
            res.setResult("注册失败！");
            return res;
        } catch (Exception e){
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("出现异常: " + e.getMessage());
            return res;
        }
    }

    @ApiOperation(value = "注销账号", notes = "param: phone")
    @PostMapping("/logoff")
    public result logoff(@RequestBody account account){
        result res = new result();
        try{
            int i  = mapper.logoff(account.getPhone());
            if(i > 0){
                res.setStatus(true);
                res.setResult("注销成功！");
                return res;
            }
            res.setStatus(false);
            res.setResult("注销失败！");
            return res;
        } catch (Exception e){
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("出现异常: " + e.getMessage());
            return res;
        }
    }

    @ApiOperation(value = "修改信息", notes = "param: account对象, oldPhone")
    @PostMapping("/change")
    public result change(@RequestBody change change){
        result res = new result();
        account account = new account();
        account.setNickname(change.getNickname());
        account.setPassword(change.getPassword());
        account.setPhone(change.getPhone());
        String oldPhone = change.getOldPhone();
        try{
            int i  = mapper.change(account, oldPhone);
            if(i > 0){
                res.setStatus(true);
                res.setResult("修改成功！");
                return res;
            }
            res.setStatus(false);
            res.setResult("修改失败！");
            return res;
        } catch (Exception e){
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("出现异常: " + e.getMessage());
            return res;
        }
    }

    @ApiOperation(value = "修改头像", notes = "param: account对象")
    @PostMapping("/chooseHeadPicture")
    public result chooseHeadPicture(@RequestBody account account){
        result res = new result();
        int headPicture = account.getHeadPicture();
        String phone = account.getPhone();
        try{
            int i  = mapper.chooseHeadPicture(headPicture, phone);
            if(i > 0){
                res.setStatus(true);
                res.setResult("修改头像成功！");
                return res;
            }
            res.setStatus(false);
            res.setResult("修改头像失败！");
            return res;
        } catch (Exception e){
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("出现异常: " + e.getMessage());
            return res;
        }
    }

    @ApiOperation(value = "修改点赞数", notes = "param: account对象")
    @PostMapping("/changeLikes")
    public result changeLikes(@RequestBody student student){
        result res = new result();
        int id = student.getId();
        account account = mapper.queryAccountByID(id);
        String phone = account.getPhone();
        try{
            int i  = mapper.changeLikes(phone);
            if(i > 0){
                res.setStatus(true);
                res.setResult("点赞成功！");
                return res;
            }
            res.setStatus(false);
            res.setResult("点赞失败！");
            return res;
        } catch (Exception e){
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("出现异常: " + e.getMessage());
            return res;
        }
    }

}
