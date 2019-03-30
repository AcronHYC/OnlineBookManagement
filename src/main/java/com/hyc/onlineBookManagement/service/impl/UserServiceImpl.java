package com.hyc.onlineBookManagement.service.impl;

import com.hyc.onlineBookManagement.bean.User;
import com.hyc.onlineBookManagement.dao.UserDao;
import com.hyc.onlineBookManagement.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User queryUserById(String id){
        return userDao.selectUserById(id);
    }

    @Override
    public User login(String name,String password){
        return userDao.selectUserByNameAndPassword(name,password);
    }
    @Override
    public boolean addUser(User user) {
        boolean flag=false;
        try {
            userDao.insertUser(user);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
