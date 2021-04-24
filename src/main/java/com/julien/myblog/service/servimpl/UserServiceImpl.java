package com.julien.myblog.service.servimpl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.julien.myblog.bean.User;
import com.julien.myblog.dao.UserDao;
import com.julien.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @function: imp
 * @author: 863978160@qq.com
 * @create: 2021-01-20 10:10
 **/

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Override
    public List<User> getAlllUser() {
        return  userDao.getUser();
    }

    @Override
    public User getOneUser(Integer id) {
        return  userDao.getUserById(id);
    }

    public User findByUsername(User user){

        return userDao.findByUsername(user.getUsername());
    }

    public User findUserById(String userId) {
        return userDao.findUserById(userId);
    }

    /**
     *
     * @param user
     * @return
     */
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

}
