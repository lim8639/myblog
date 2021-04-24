package com.julien.myblog.service;

import com.julien.myblog.bean.User;

import java.util.List;

/**
 * @function: USD
 * @author: 863978160@qq.com
 * @create: 2021-01-20 10:08
 **/

public interface UserService {
      /**
       *
       * @return
       */
      public List<User> getAlllUser();

      /**
       *
       * @param id
       * @return
       */
      public User getOneUser(Integer id);


      /**
       *
       * @param user
       * @return
       */
      public User findByUsername(User user);

      /**
       *
       * @param userId
       * @return
       */
      public User findUserById(String userId);


      /**
       *
       * @param user
       * @return
       */
      public String getToken(User user);
}
