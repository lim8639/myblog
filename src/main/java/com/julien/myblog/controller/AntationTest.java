package com.julien.myblog.controller;

import org.slf4j.LoggerFactory;

/**
 * @function: test
 * @author: 863978160@qq.com
 * @create: 2021-02-02 19:39
 **/



public class AntationTest {

    @MyAnotation
    void test44(){
        LoggerFactory.getLogger(getClass()).info("这个是注解方法");
    }

}
