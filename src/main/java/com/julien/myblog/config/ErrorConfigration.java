package com.julien.myblog.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @function: config
 * @author: 863978160@qq.com
 * @create: 2021-02-08 19:40
 **/

@Configuration
public class ErrorConfigration {

    @Bean
    ErrorPageRegistrar setErrorpage(){return new ErrorPageRegistrar() {
        @Override
        public void registerErrorPages(ErrorPageRegistry registry) {
            ErrorPage e404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404.html");
            /*错误类型为500，表示服务器响应错误，默认显示500.html网页*/
            ErrorPage e500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500.html");
            ErrorPage e400 = new ErrorPage(HttpStatus.BAD_REQUEST, "/error/400.html");
            registry.addErrorPages(e400 ,e404, e500);
        }
    };}
}
