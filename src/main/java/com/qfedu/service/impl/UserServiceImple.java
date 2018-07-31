package com.qfedu.service.impl;

import com.qfedu.dao.UserDao;
import com.qfedu.domain.User;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImple implements UserService {
    @Autowired
    private UserDao dao;

    @Override
    public User selectByName(String username) {
        if (username!=null && username.length()>0){
            return  dao.selectByName(username);
        }
        return null;
    }

    @Override
    public int insert(User user) {
        String name = user.getUsername();
        String pwd = user.getPassword();
        String sex = user.getSex();
        if (name!=null && name.length()>0 && pwd!=null && pwd.length()>0 &&
                sex!=null && sex.length()>0){
            return dao.insert(user);
        }
        return -1;
    }

    @Override
    public User selectLogin(String username, String password) {
        if (username!=null && username.length()>0 && password!=null && password.length()>0){
//            System.err.println(username+"--->"+password);
//            System.err.println("dao:"+dao.selectLogin(username,password));
            return dao.selectLogin(username, password);
        }
        return null;
    }
}
