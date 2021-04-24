package com.julien.myblog.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @function: aop
 * @author: 863978160@qq.com
 * @create: 2021-01-20 23:34
 **/



@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.julien"})
public class AOPConfig {

}
