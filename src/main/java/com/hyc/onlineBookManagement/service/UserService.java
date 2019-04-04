package com.hyc.onlineBookManagement.service;

import com.hyc.onlineBookManagement.bean.User;

import java.util.List;

public interface UserService {
    List<User> queryUserByParams(String id,
                                 String userName,
                                 String realName,
                                 String password,
                                 String IDcard,
                                 String telephone,
                                 String email);

    boolean addUser(User user);

    boolean updateUser(String id,
                       String userName,
                       String realName,
                       String password,
                       String IDcard,
                       String telephone,
                       String email);
}
