package com.qfedu.service;

import com.qfedu.domain.User;

public interface UserService {
    //註冊
    User selectByName(String username);

    int insert(User user);
    //登录
    User selectLogin(String username, String password);
}
