package com.hyc.onlineBookManagement.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hyc.onlineBookManagement.bean.Page;
import com.hyc.onlineBookManagement.bean.User;
import com.hyc.onlineBookManagement.dao.UserDao;
import com.hyc.onlineBookManagement.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public String queryUserByFuzzyAndPage(String id,
                                          String userName,
                                          String realName,
                                          String password,
                                          String IDcard,
                                          String telephone,
                                          String email,
                                          Integer pageSize,
                                          Integer page){
        int total=userDao.selectUserCount(id,userName,realName,password,IDcard,telephone,email);
        List<User> userList=new ArrayList<User>();
        JSONObject jsonObject=new JSONObject();
        Page pageObject=null;
        if(page!=null){
            pageObject=new Page(page,pageSize,total);
            userList=userDao.selectUserByFuzzyAndPage(id,userName,realName,password,IDcard,telephone,email,pageObject.getStartIndex(),pageSize);
            jsonObject.put("jsonUserList",JSONObject.toJSON(userList));
            jsonObject.put("pagination",JSONObject.toJSON(pageObject));
            return jsonObject.toJSONString();
        }else{
            pageObject=new Page(1,10,total);
            userList=userDao.selectUserByFuzzyAndPage(id,userName,realName,password,IDcard,telephone,email,pageObject.getStartIndex(),pageObject.getPageSize());
            jsonObject.put("jsonUserList",JSONObject.toJSON(userList));
            jsonObject.put("pagination",JSONObject.toJSON(pageObject));
            return jsonObject.toJSONString();
        }
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

    @Override
    public List<User> queryUserBorrowCount(){
        return userDao.selectUserBorrowCount();
    }
}
