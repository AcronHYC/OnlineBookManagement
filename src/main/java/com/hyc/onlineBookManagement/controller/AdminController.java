package com.hyc.onlineBookManagement.controller;

import com.hyc.onlineBookManagement.bean.Admin;
import com.hyc.onlineBookManagement.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Resource
    private AdminService adminService;

    @ResponseBody
    @RequestMapping("/queryAdminByParams")
    public List<Admin> queryAdminByParams(HttpServletRequest request){
        String uuid=request.getParameter("uuid");
        String adminName=request.getParameter("adminName");
        String password=request.getParameter("password");
        String realName=request.getParameter("realName");
        String sex=request.getParameter("sex");
        String telephone=request.getParameter("telephone");
        String email=request.getParameter("email");
        String role=request.getParameter("role");
        return adminService.queryAdminByParams(uuid,adminName,password,realName,sex,telephone,email,role);
    }
}
