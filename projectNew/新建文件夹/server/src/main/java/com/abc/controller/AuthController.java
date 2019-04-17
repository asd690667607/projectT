package com.abc.controller;

import com.abc.annotation.PermInfo;
import com.abc.constant.Codes;
import com.abc.entity.SysUser;
import com.abc.util.JWT;
import com.abc.util.MD5Util;
import com.abc.vo.Json;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.internal.org.apache.commons.codec.digest.DigestUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
/**
 * created by dzs at 2019/3/10 17:26<br>
 */
@PermInfo(value = "登录模块", pval = "a:auth")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
    /**
     * 登录接口
     *
     *
     * @param body
     * @return
     */
    @ApiOperation(value = "丁兆双: 登录", notes = "")
    @PostMapping("/login")
    public Json login(@RequestBody String body){
        String oper = "user login";
        log.info("{}, body: {}",oper,body);
        JSONObject json = JSON.parseObject(body);
        String uname = json.getString("uname");
        String pwd = json.getString("pwd");
        MD5Util md5Util = new MD5Util(uname, "MD5");
        String pass = md5Util.encode(pwd);
        System.out.println("md5"+pass);
        if (StringUtils.isEmpty(uname)){
            return Json.fail(oper,"用户名不能为空");
        }
        if (StringUtils.isEmpty(pwd)){
            return Json.fail(oper,"密码不能为空");
        }

        Subject currentUser = SecurityUtils.getSubject();
        try {
            //登录
            currentUser.login( new UsernamePasswordToken(uname, pwd) );
            SysUser user = (SysUser) currentUser.getPrincipal();
            if (user==null) throw new AuthenticationException();
            if (user.getLock().equals(true)) throw new LockedAccountException();
            String token = JWT.sign(user, 60L* 1000L* 30L);
            System.out.println(token);
            //返回登录用户的信息给前台，含用户的所有角色和权限
            System.out.println(user.getPerms()+"perms");
            System.out.println(user.getRoles()+"roles");
            return Json.succ(oper)
                    .data("token", token)
                    .data("uid",user.getUid())
                    .data("nick",user.getNick())
                    .data("roles",user.getRoles())
                    .data("perms",user.getPerms());

        } catch ( UnknownAccountException uae ) {
            log.warn("用户帐号不正确");
            return Json.fail(oper,"用户帐号或密码不正确");

        } catch ( IncorrectCredentialsException ice ) {
            log.warn("用户密码不正确");
            return Json.fail(oper,"用户帐号或密码不正确");

        } catch ( LockedAccountException lae ) {
            log.warn("用户帐号被锁定");
            return Json.fail(oper,"用户帐号被锁定不可用");

        } catch ( AuthenticationException ae ) {
            log.warn("登录出错");
            return Json.fail(oper,"登录失败："+ae.getMessage());
        }
    }
    @ApiOperation(value = "丁兆双: 登出", notes = "")
    @PostMapping("/logout")
    public Json logout(){
        String oper = "user logout";
        log.info("{}",oper);
        SecurityUtils.getSubject().logout();
        return new Json(oper);
    }
    @ApiOperation(value = "丁兆双: 登录信息", notes = "")
    @GetMapping("/info")
    public Json info(){
        String oper = "get user info";
        Subject subject = SecurityUtils.getSubject();
        SysUser user = (SysUser) subject.getPrincipal();
        if (user==null){
            //告知前台，登录失效
            return new Json(oper,false, Codes.SESSION_TIMEOUT,"登录已失效",null);
        }else{
            //返回登录用户的信息给前台，含用户的所有角色和权限
            return Json.succ(oper)
                    .data("name",user.getUname())
                    .data("nick",user.getNick())
                    .data("avator","")
                    .data("roles",user.getRoles())
                    .data("perms",user.getPerms());
        }
    }
}
