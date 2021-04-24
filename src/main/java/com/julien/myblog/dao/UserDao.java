package com.julien.myblog.dao;

import com.julien.myblog.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author julien
 * @date 18:50
 * @function: userdao
 */

@Component
@Mapper
public interface UserDao {
    /**
     * 读取用户信息
     * @return
     */
    @Select("Select * from t_user;")
    public List<User> getUser();

    @Select("Select * from t_user where id = #{id}")
    public User getUserById(Integer id);


    @Select("select * from t_user where username = #{username};")
    User findByUsername(String username);

    @Select("Select * from t_user where id = #{id}")
    User findUserById(String id);


}
