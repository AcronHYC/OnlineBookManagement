package com.hyc.onlineBookManagement.controller;

import com.hyc.onlineBookManagement.annotation.LoginToken;
import com.hyc.onlineBookManagement.bean.User;
import com.hyc.onlineBookManagement.service.UserService;
import com.hyc.onlineBookManagement.utils.UUIDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import com.hyc.onlineBookManagement.annotation.LoginToken;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserService userService;

    @LoginToken
    @ResponseBody
    @RequestMapping("/queryUserByParams")
    public List<User> queryUserByParams(HttpServletRequest request){
        String id=request.getParameter("id");
        String userName=request.getParameter("userName");
        String realName=request.getParameter("realName");
        String password=request.getParameter("password");
        String idcard=request.getParameter("idcard");
        String telephone=request.getParameter("telephone");
        String email=request.getParameter("email");
        return userService.queryUserByParams(id,userName,realName,password,idcard,telephone,email);
    }

    @LoginToken
    @ResponseBody
    @RequestMapping(value="/addUser", method = RequestMethod.POST)
    public boolean addUser(@RequestBody Map<String,String> params){
        User user=new User();
        user.setId(UUIDUtils.getUUID());
        user.setUserName(params.get("userName"));
        user.setRealName(params.get("realName"));
        user.setPassword(params.get("password"));
        user.setIdcard(params.get("idcard"));
        user.setTelephone(params.get("telephone"));
        user.setEmail(params.get("email"));
        return userService.addUser(user);
    }

    @LoginToken
    @ResponseBody
    @RequestMapping("/queryUserByFuzzyAndPage")
    public String queryUserByFuzzyAndPage(HttpServletRequest request) {
        String id=request.getParameter("id");
        String userName=request.getParameter("userName");
        String realName=request.getParameter("realName");
        String password=request.getParameter("password");
        String idcard=request.getParameter("idcard");
        String telephone=request.getParameter("telephone");
        String email=request.getParameter("email");
        try {
            int page = Integer.parseInt(request.getParameter("page"));
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            return userService.queryUserByFuzzyAndPage(id,userName,realName,password,idcard,telephone,email,pageSize,page);
        }catch (Exception e){
            return userService.queryUserByFuzzyAndPage(id,userName,realName,password,idcard,telephone,email,null,null);
        }
    }

    @LoginToken
    @ResponseBody
    @PostMapping("/updateUser")
    public boolean updateUser(@RequestBody Map<String,String> params){
        String id=params.get("id");
        String userName=params.get("userName");
        String realName=params.get("realName");
        String password=params.get("password");
        String idcard=params.get("idcard");
        String telephone=params.get("telephone");
        String email=params.get("email");
        return userService.updateUser(id,userName,realName,password,idcard,telephone,email);
    }

    @ResponseBody
    @GetMapping("/queryUserBorrowCount")
    public List<User> queryUserBorrowCount() {
        return userService.queryUserBorrowCount();
    }

}
