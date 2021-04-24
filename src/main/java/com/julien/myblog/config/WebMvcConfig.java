package com.julien.myblog.config;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.julien.myblog.anotation.PassToken;
import com.julien.myblog.anotation.UserLoginToken;
import com.julien.myblog.bean.User;
import com.julien.myblog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @function: config 本地路径映射
 * @author: 863978160@qq.com
 * @create: 2021-01-21 17:18
 **/

@Configuration
public class WebMvcConfig {

        @Bean
        public WebMvcConfigurerAdapter setWebMvcConfigurerAdapter(){
           return  new WebMvcConfigurerAdapter() {
               UserService userService;
               private Logger logger = LoggerFactory.getLogger(getClass());
               @Autowired
               public void setUserService(UserService userService) {
                   this.userService = userService;
               }

                @Override
                public void addResourceHandlers(ResourceHandlerRegistry registry) {
                    registry.addResourceHandler("/api/**").addResourceLocations("file:"+System.getProperty("user.dir")+"/upload/image/");
                    super.addResourceHandlers(registry);
                }

//                @Override
//                public void addViewControllers(ViewControllerRegistry registry) {
//                    registry.addViewController("/index.html").setViewName("index");
//                    super.addViewControllers(registry);
//                }
                // 添加拦截器

                @Override
                public void addInterceptors(InterceptorRegistry registry) {
                    registry.addInterceptor(new HandlerInterceptor() {
                        @Override
                        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
                            String token = request.getHeader("Authorization");// 从 http 请求头中取出 token
                            // 如果不是映射到方法直接通过
                            if(!(object instanceof HandlerMethod)){
                                return true;
                            }
                            HandlerMethod handlerMethod=(HandlerMethod)object;
                            Method method=handlerMethod.getMethod();


                            //检查是否有passtoken注解，有则跳过认证
                            if (method.isAnnotationPresent(PassToken.class)) {
                                PassToken passToken = method.getAnnotation(PassToken.class);
                                if (passToken.required()) {
                                    return true;
                                }
                            }
                            //检查有没有需要用户权限的注解
                            if (method.isAnnotationPresent(UserLoginToken.class)) {
                                UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
                                if (userLoginToken.required()) {
                                    // 执行认证
                                    if (token == null) {
                                        response.setCharacterEncoding("UTF-8");
                                        response.getWriter().write("{code:0,message:\"token不存在\"}");
                                        logger.warn("无token，请重新登录");
                                        return false;
                                    }
                                    // 获取 token 中的 user id
                                    String userId;
                                    try {
                                        userId = JWT.decode(token).getAudience().get(0);
                                    } catch (JWTDecodeException j) {
                                        throw new RuntimeException("401");
                                    }
                                    User user = userService.findUserById(userId);
                                    if (user == null) {
                                        response.getWriter().write("{code:0,message:\"用户不存在，去注册\"}");
                                        logger.warn("用户不存在，去注册");
                                    }
                                    // 验证 token
                                    assert user != null;
                                    JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
                                    try {
                                        jwtVerifier.verify(token);
                                    } catch (JWTVerificationException e) {
                                        throw new RuntimeException("401");
                                    }
                                    return true;
                                }
                            }
                            return true;
                        }

                        @Override
                        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

                        }

                        @Override
                        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

                        }
                    }).addPathPatterns("/private/*");
//                    }).addPathPatterns("/**");
                }
            };
        }
}
