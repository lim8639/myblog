package com.julien.myblog.controller;

import com.alibaba.fastjson.JSONObject;
import com.julien.myblog.anotation.PassToken;
import com.julien.myblog.bean.User;
import com.julien.myblog.service.UserService;
import com.julien.myblog.utils.SendEmail;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Random;

/**
 * @function: UserController
 * @author: 863978160@qq.com
 * @create: 2021-01-20 10:15
 **/
@RestController
public class UserController {

    UserService userService;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/user")
    public List<User> getAllUserData(){
       return userService.getAlllUser();
    }

    @RequestMapping("/user/{id}")
    public String getOneUser(@PathVariable Integer id){
          User u = userService.getOneUser(id);
        if ( u==null){
            return "数据不存在";
        }
        return u.toString();
    }

    @RequestMapping("login2")
    public Object loginuser(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "服务器故障");
        return  jsonObject;
    }


    @RequestMapping("/email")
    public Object email(@RequestParam(name = "email",required = true)String email){
        JSONObject jsonObject = new JSONObject();
        Random r = new Random();
        int code =   r.nextInt(100000)+100000;
        try {
            SendEmail.PutEmail(email,"欢迎注册"+code,"验证码");
        } catch (MessagingException | GeneralSecurityException e) {
            e.printStackTrace();
        }
        jsonObject.put("code",code);
        jsonObject.put("message", "发送成功");
        return  jsonObject;
    }
    @RequestMapping(value = "/email2",method = RequestMethod.POST)
    public Object email2(@RequestParam(name = "email",required = true)String email,
                         @RequestParam(name = "title",required = true)String title,
                         @RequestParam(name = "content",required = true)String content){
        JSONObject jsonObject = new JSONObject();
        try {
            SendEmail.PutEmail(email,content,title);
        } catch (MessagingException | GeneralSecurityException e) {
            e.printStackTrace();
        }
        jsonObject.put("code",1);
        jsonObject.put("message", "发送成功");
        return  jsonObject;
    }

    @RequestMapping("/reg")
    public Object userReger(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",1);
        jsonObject.put("message","注册成功");
        return jsonObject;
    }

    @ApiOperation(value = "登陆", notes = "登陆")
    @PassToken
    @RequestMapping("/login")
    public Object userLogin(User user,HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        User userForBase = new User();
        User loginUser = userService.findByUsername(user);
        if (loginUser==null){
            jsonObject.put("message", "当前用户未注册");
            jsonObject.put("code", 0);
            return jsonObject;
        }
        userForBase.setId(loginUser.getId());
        userForBase.setUsername(loginUser.getUsername());
        userForBase.setPassword(loginUser.getPassword());
        if (!userForBase.getPassword().equals(user.getPassword())) {
            jsonObject.put("message", "登录失败,密码错误");
            jsonObject.put("code", 0);
            return jsonObject;
        } else {
             String token = userService.getToken(userForBase);
            jsonObject.put("token", token);
            jsonObject.put("code", 1);
            jsonObject.put("message","登录成功");
            Cookie cookie = new Cookie("token", token);
            cookie.setPath("/");
            response.addCookie(cookie);
            return jsonObject;
        }
    }
}
