package com.julien.myblog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;

import java.lang.reflect.Method;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @function: test
 * @author: 863978160@qq.com
 * @create: 2021-02-02 19:33
 **/


@RestController
public class TestControl {

    @RequestMapping("/api1")
    public String pjax1(){return "<h2>pjax1</h2>";}
    @RequestMapping("/api2")
    public String pjax2(){return "<h2>pjax2</h2>";}

    
    @GetMapping(value="/host")
   public String gethost(){
            return  "host:";
    }
    

    @MyAnotation
    String hello(){
        // 等我看看再说，这个什么东西我不知道吗
        return "hello";
    }
}

