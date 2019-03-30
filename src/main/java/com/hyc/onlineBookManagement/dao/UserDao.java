package com.hyc.onlineBookManagement.dao;

import com.hyc.onlineBookManagement.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User selectUserById(String id);

    User selectUserByNameAndPassword(String name,String password);

    int insertUser(User user);
}
