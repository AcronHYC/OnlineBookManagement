package com.hyc.onlineBookManagement.service;

import com.hyc.onlineBookManagement.bean.User;

import java.util.List;

public interface UserService {
    //根据条件动态查询读者
    List<User> queryUserByParams(String id,
                                 String userName,
                                 String realName,
                                 String password,
                                 String IDcard,
                                 String telephone,
                                 String email);

    ////分页模糊查询读者信息
    String queryUserByFuzzyAndPage(String id,
                                   String userName,
                                   String realName,
                                   String password,
                                   String IDcard,
                                   String telephone,
                                   String email,
                                   Integer pageSize,
                                   Integer page);

    //新增读者
    boolean addUser(User user);

    //更新读者信息
    boolean updateUser(String id,
                       String userName,
                       String realName,
                       String password,
                       String IDcard,
                       String telephone,
                       String email);

    //查询借书最多的十位读者的借书数量
    List<User> queryUserBorrowCount();
}
