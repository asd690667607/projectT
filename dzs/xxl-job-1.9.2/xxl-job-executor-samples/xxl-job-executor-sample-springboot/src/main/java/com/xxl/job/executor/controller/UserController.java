package com.xxl.job.executor.controller;

import com.xxl.job.executor.common.result.ResultJson;
import com.xxl.job.executor.domain.orm.User;
import com.xxl.job.executor.service.IUserService;
import com.xxl.job.executor.util.MD5Util;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户api
 *
 * @author dingzhaoshuang
 * @date 17:42 2019/3/27
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@RequestMapping("/user")
@RequestMapping("user")
public class UserController {
    private Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserService iUserService;
    @ApiOperation(value = "丁兆双: 登录", notes = "")
    @PostMapping(value = "login")
    public ResultJson login( String uname,String pwd)  {
        User u = iUserService.getUserByNickName(uname);
        if(u==null){
            return ResultJson.createByErrorMsg("登录失败,用户不存在");
        }else {
            String salt = u.getPaySalt();
            MD5Util md5Util = new MD5Util(salt,"MD5");
            String pass=md5Util.encode(pwd);
            if (!u.getPayPass().equals(pass)){
                return  ResultJson.createByErrorMsg("登录失败,密码错误");
            }
            else{
                return  ResultJson.createBySuccess("userId",u.getId());
                 }
            }
    }
}