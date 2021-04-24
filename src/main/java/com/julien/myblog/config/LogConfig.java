package com.julien.myblog.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @function: log
 * @author: 863978160@qq.com
 * @create: 2021-01-24 18:02
 **/

@Configuration
public class LogConfig {
    /**
     * 用户信息日志提示
     * @return
     */
    @Bean
    public Logger getLogger(){
        return LoggerFactory.getLogger(getClass());
    }

}
