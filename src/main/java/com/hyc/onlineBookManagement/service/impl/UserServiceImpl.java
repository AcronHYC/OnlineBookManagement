package com.hyc.onlineBookManagement.service.impl;

import com.hyc.onlineBookManagement.bean.User;
import com.hyc.onlineBookManagement.dao.UserDao;
import com.hyc.onlineBookManagement.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public List<User> queryUserByParams(String id,
                                        String userName,
                                        String realName,
                                        String password,
                                        String IDcard,
                                        String telephone,
                                        String email){
        return userDao.selectUserByParams(id,userName,realName,password,IDcard,telephone,email);
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

    @Override
    public boolean updateUser(String id,
                              String userName,
                              String realName,
                              String password,
                              String IDcard,
                              String telephone,
                              String email){
        boolean flag=false;
        try {
            userDao.updateUser(id,userName,realName,password,IDcard,telephone,email);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
