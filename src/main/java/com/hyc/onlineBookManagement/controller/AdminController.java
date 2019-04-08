package com.hyc.onlineBookManagement.controller;

import com.hyc.onlineBookManagement.bean.Admin;
import com.hyc.onlineBookManagement.service.AdminService;
import com.hyc.onlineBookManagement.utils.UUIDUtils;
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
        String roleName=request.getParameter("roleName");
        return adminService.queryAdminByParams(uuid,adminName,password,realName,sex,telephone,email,role,roleName);
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
        String roleName=request.getParameter("roleName");
        try{
            int page = Integer.parseInt(request.getParameter("page"));
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            return adminService.queryAdminByFuzzyAndPage(uuid,adminName,password,realName,sex,telephone,email,role,roleName,pageSize,page);
        }catch (Exception e){
            return adminService.queryAdminByFuzzyAndPage(uuid,adminName,password,realName,sex,telephone,email,role,roleName,null,null);
        }
    }

    @ResponseBody
    @RequestMapping("/addAdmin")
    public boolean addUser(HttpServletRequest request){
        Admin admin=new Admin();
        admin.setUuid(UUIDUtils.getUUID());
        admin.setAdminName(request.getParameter("adminName"));
        admin.setPassword(request.getParameter("password"));
        admin.setRealName(request.getParameter("realName"));
        admin.setSex(request.getParameter("sex"));
        admin.setTelephone(request.getParameter("telephone"));
        admin.setEmail(request.getParameter("email"));
        String role=request.getParameter("role");   
        admin.setRole(role);
        if(role.equals("1")) {
            admin.setRoleName("超级管理员");
        }else if(role.equals("2")){
            admin.setRoleName("高级管理员");
        }else if(role.equals("3")){
            admin.setRoleName("普通管理员");
        }
        return adminService.addAdmin(admin);

    }
}
