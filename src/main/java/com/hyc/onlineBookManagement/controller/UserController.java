package com.hyc.onlineBookManagement.controller;

import com.hyc.onlineBookManagement.bean.User;
import com.hyc.onlineBookManagement.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping("/queryUserById")
    public User queryUserById(HttpServletRequest request){
        return userService.queryUserById(request.getParameter("id"));
    }

    @ResponseBody
    @RequestMapping("/login")
    public User login(HttpServletRequest request){
        System.out.println(request.getParameter("name"));
        return userService.login(request.getParameter("name"),request.getParameter("password"));
    }

    @ResponseBody
    @RequestMapping("/addUser")
    public boolean addUser(HttpServletRequest request){
        User user=new User();
        user.setId("7");
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        user.setIDcard(request.getParameter("IDcard"));
        user.setTelephone(request.getParameter("telephone"));
        user.setEmail(request.getParameter("email"));
        return userService.addUser(user);
    }
}
