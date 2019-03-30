package com.hyc.onlineBookManagement.service;

import com.hyc.onlineBookManagement.bean.User;

public interface UserService {
    User queryUserById(String id);

    User login(String name,String password);

    boolean addUser(User user);
}
