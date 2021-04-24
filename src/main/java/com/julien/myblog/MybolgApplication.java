package com.julien.myblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class MybolgApplication  {

    public static void main(String[] args) {
        SpringApplication.run(MybolgApplication.class, args);
    }



}
