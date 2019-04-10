package com.hyc.onlineBookManagement.controller;

import com.hyc.onlineBookManagement.bean.User;
import com.hyc.onlineBookManagement.service.UserService;
import com.hyc.onlineBookManagement.utils.UUIDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserService userService;


    @ResponseBody
    @RequestMapping("/queryUserByParams")
    public List<User> queryUserByParams(HttpServletRequest request){
        String id=request.getParameter("id");
        String userName=request.getParameter("userName");
        String realName=request.getParameter("realName");
        String password=request.getParameter("password");
        String IDcard=request.getParameter("IDcard");
        String telephone=request.getParameter("telephone");
        String email=request.getParameter("email");
        return userService.queryUserByParams(id,userName,realName,password,IDcard,telephone,email);
    }

    @ResponseBody
    @RequestMapping(value="/addUser", method = RequestMethod.POST)
    public boolean addUser(@RequestBody Map<String,String> params){
        User user=new User();
        user.setId(UUIDUtils.getUUID());
        user.setUserName(params.get("userName"));
        user.setRealName(params.get("realName"));
        user.setPassword(params.get("password"));
        user.setIDcard(params.get("IDcard"));
        user.setTelephone(params.get("telephone"));
        user.setEmail(params.get("email"));
        return userService.addUser(user);
    }

    @ResponseBody
    @RequestMapping("/queryUserByFuzzyAndPage")
    public String queryUserByFuzzyAndPage(HttpServletRequest request) {
        String id=request.getParameter("id");
        String userName=request.getParameter("userName");
        String realName=request.getParameter("realName");
        String password=request.getParameter("password");
        String IDcard=request.getParameter("IDcard");
        String telephone=request.getParameter("telephone");
        String email=request.getParameter("email");
        try {
            int page = Integer.parseInt(request.getParameter("page"));
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            return userService.queryUserByFuzzyAndPage(id,userName,realName,password,IDcard,telephone,email,pageSize,page);
        }catch (Exception e){
            return userService.queryUserByFuzzyAndPage(id,userName,realName,password,IDcard,telephone,email,null,null);
        }
    }

    @ResponseBody
    @RequestMapping("/updateUser")
    public boolean updateUser(HttpServletRequest request){
        String id=request.getParameter("id");
        String userName=request.getParameter("userName");
        String realName=request.getParameter("realName");
        String password=request.getParameter("password");
        String IDcard=request.getParameter("IDcard");
        String telephone=request.getParameter("telephone");
        String email=request.getParameter("email");
        return userService.updateUser(id,userName,realName,password,IDcard,telephone,email);
    }
}
