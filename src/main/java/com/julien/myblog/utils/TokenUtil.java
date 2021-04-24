package com.julien.myblog.utils;

import com.auth0.jwt.JWT;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @function:
 * @author: 863978160@qq.com
 * @create: 2021-02-01 20:58
 **/
public class TokenUtil {

    public static String getUserIdByToken() {
        String token = Objects.requireNonNull(getRequest()).getHeader("Authorization");// 从 http 请求头中取出 token
        return JWT.decode(token).getAudience().get(0);
    }

    /**
     * 获取request
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }
}