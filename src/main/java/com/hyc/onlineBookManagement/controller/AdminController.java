package com.hyc.onlineBookManagement.controller;

import com.alibaba.fastjson.JSONObject;
import com.hyc.onlineBookManagement.bean.Admin;
import com.hyc.onlineBookManagement.service.AdminService;
import com.hyc.onlineBookManagement.utils.UUIDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Resource
    private AdminService adminService;

    @ResponseBody
    @RequestMapping("/queryAdminByParams")
    public List<Admin> queryAdminByParams(HttpServletRequest request) {
        String uuid = request.getParameter("uuid");
        String adminName = request.getParameter("adminName");
        String password = request.getParameter("password");
        String realName = request.getParameter("realName");
        String sex = request.getParameter("sex");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        String roleName = request.getParameter("roleName");
        return adminService.queryAdminByParams(uuid, adminName, password, realName, sex, telephone, email, role, roleName);
    }

    @ResponseBody
    @RequestMapping("/queryAdminByPage")
    public String queryAdminByPage(HttpServletRequest request) {
        try {
            int page = Integer.parseInt(request.getParameter("page"));
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            return adminService.queryAdminByPage(pageSize, page);
        } catch (Exception e) {
            return adminService.queryAdminByPage(null, null);
        }
    }

    @ResponseBody
    @RequestMapping("/queryAdminByFuzzyAndPage")
    public String queryAdminByFuzzyAndPage(HttpServletRequest request) {
        String uuid = request.getParameter("uuid");
        String adminName = request.getParameter("adminName");
        String password = request.getParameter("password");
        String realName = request.getParameter("realName");
        String sex = request.getParameter("sex");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        String roleName = request.getParameter("roleName");
        try {
            int page = Integer.parseInt(request.getParameter("page"));
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            return adminService.queryAdminByFuzzyAndPage(uuid, adminName, password, realName, sex, telephone, email, role, roleName, pageSize, page);
        } catch (Exception e) {
            return adminService.queryAdminByFuzzyAndPage(uuid, adminName, password, realName, sex, telephone, email, role, roleName, null, null);
        }
    }

    @ResponseBody
    @RequestMapping(value="/addAdmin", method = RequestMethod.POST)
    public boolean addUser(@RequestBody Map<String,String> params) {
        Admin admin = new Admin();
        admin.setUuid(UUIDUtils.getUUID());
        admin.setAdminName(params.get("adminName"));
        admin.setPassword(params.get("password"));
        admin.setRealName(params.get("realName"));
        admin.setSex(params.get("sex"));
        admin.setTelephone(params.get("telephone"));
        admin.setEmail(params.get("email"));
        String role = params.get("role");
        admin.setRole(role);
        if (role.equals("1")) {
            admin.setRoleName("超级管理员");
        } else if (role.equals("2")) {
            admin.setRoleName("高级管理员");
        } else if (role.equals("3")) {
            admin.setRoleName("普通管理员");
        }
        return adminService.addAdmin(admin);
    }

    @ResponseBody
    @RequestMapping(value = "/updateAdmin", method = RequestMethod.POST)
    public boolean updateAdmin(@RequestBody Map<String,String> params) {
        String uuid = params.get("uuid");
        String adminName = params.get("adminName");
        String password = params.get("password");
        String realName = params.get("realName");
        String sex = params.get("sex");
        String telephone = params.get("telephone");
        String email = params.get("email");
        String role = params.get("role");
        String roleName = null;
        if (role != null) {
            if (role.equals("1")) {
                roleName = "超级管理员";
            } else if (role.equals("2")) {
                roleName = "高级管理员";
            } else if (role.equals("3")) {
                roleName = "普通管理员";
            }
        }
        return adminService.updateAdmin(uuid, adminName, password, realName, sex, telephone, email, role, roleName);
    }

    @ResponseBody
    @RequestMapping(value="/deleteAdmin")
    public boolean deleteAdmin(@RequestBody Map<String,String> params){
        String uuid=params.get("uuid");
        return adminService.deleteAdmin(uuid);
    }
}
