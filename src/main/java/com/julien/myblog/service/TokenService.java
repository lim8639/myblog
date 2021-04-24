package com.julien.myblog.service;

/**
 * @function: token
 * @author: 863978160@qq.com
 * @create: 2021-02-01 20:54
 **/

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.julien.myblog.bean.User;
import org.springframework.stereotype.Service;

import java.util.Date;

/***
 * token 下发
 * @Title: TokenService.java
 * @author qiaoyn
 * @date 2019/06/14
 * @version V1.0
 */
@Service
public class TokenService {
    public String getToken(User user) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60* 60 * 1000;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";
        System.out.println("正在验证");
        token = JWT.create().withAudience(String.valueOf(user.getId().intValue())).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

    public String test(){return "test";}
}