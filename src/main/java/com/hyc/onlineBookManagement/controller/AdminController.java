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

    @ResponseBody
    @RequestMapping("/queryAdminByPage")
    public String queryAdminByPage(HttpServletRequest request){
        try {
            int page = Integer.parseInt(request.getParameter("page"));
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            return adminService.queryAdminByPage(pageSize, page);
        }catch (Exception e){
            return adminService.queryAdminByPage(null, null);
        }
    }

    @ResponseBody
    @RequestMapping("/queryAdminByFuzzyAndPage")
    public String queryAdminByFuzzyAndPage(HttpServletRequest request){
        String uuid=request.getParameter("uuid");
        String adminName=request.getParameter("adminName");
        String password=request.getParameter("password");
        String realName=request.getParameter("realName");
        String sex=request.getParameter("sex");
        String telephone=request.getParameter("telephone");
        String email=request.getParameter("email");
        String role=request.getParameter("role");
        try{
            int page = Integer.parseInt(request.getParameter("page"));
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            return adminService.queryAdminByFuzzyAndPage(uuid,adminName,password,realName,sex,telephone,email,role,pageSize,page);
        }catch (Exception e){
            return adminService.queryAdminByFuzzyAndPage(uuid,adminName,password,realName,sex,telephone,email,role,null,null);
        }
    }
}
