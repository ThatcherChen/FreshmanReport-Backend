package com.frmv.controller;

import com.frmv.entity.account;
import com.frmv.entity.change;
import com.frmv.entity.result;
import com.frmv.mapper.accountMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "account表接口")
@RestController
public class accountController {
    @Autowired
    private accountMapper mapper;

    @ApiOperation(value = "查询所有数据")
    @GetMapping("/account/selectAll")
    public List selectAll(){
        List<account> accounts = mapper.selectList(null);
        return accounts;
    }

    @ApiOperation(value = "登录账号", notes = "输入: phone, password")
    @PostMapping("/login")
    public result login(@RequestBody account account){
        result res = new result();
        String phone = account.getPhone();
        String password = account.getPassword();
        try{
            List<account> account1 = mapper.login(phone, password);
            if(account1.size() < 1){
                res.setStatus(false);
                res.setResult("结果为空！");
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
        System.out.println(account.toString());
        try{
            int i  = mapper.insert(account);
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

}
