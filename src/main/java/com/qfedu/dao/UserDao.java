package com.qfedu.dao;

import com.qfedu.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
    //註冊
    @Select("select * from t_user where username = #{username}")
    @ResultType(User.class)
    User selectByName(String username);

    @Insert("insert into t_user(username, password, sex, role, flag) values(#{username}, #{password}, #{sex}, 1, 1)")
    int insert(User user);
    //登录
    @Select("select * from t_user where username =#{username} and password = #{password}")
    @ResultType(User.class)
    User selectLogin(@Param("username") String username, @Param("password") String password);
}
