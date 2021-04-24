package com.julien.myblog.anotation;

/**
 * @function: login
 * @author: 863978160@qq.com
 * @create: 2021-02-01 21:03
 **/

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***
 * 用来跳过验证的 PassToken
 * @author qiaoyn
 * @date 2019/06/14
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PassToken {
    boolean required() default true;
}