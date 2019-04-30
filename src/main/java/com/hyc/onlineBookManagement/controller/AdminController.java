package com.hyc.onlineBookManagement.controller;

import com.alibaba.fastjson.JSONObject;
import com.hyc.onlineBookManagement.annotation.LoginToken;
import com.hyc.onlineBookManagement.bean.Admin;
import com.hyc.onlineBookManagement.bean.User;
import com.hyc.onlineBookManagement.service.AdminService;
import com.hyc.onlineBookManagement.service.TokenService;
import com.hyc.onlineBookManagement.service.UserService;
import com.hyc.onlineBookManagement.utils.UUIDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Resource
    private AdminService adminService;
    @Resource
    private TokenService tokenService;
    @Resource
    private UserService userService;

    @LoginToken
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

    @LoginToken
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

    @LoginToken
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

    @LoginToken
    @ResponseBody
    @RequestMapping(value="/addAdmin", method = RequestMethod.POST)
    public boolean addAdmin(@RequestBody Map<String,String> params) {
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

    @LoginToken
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

    @LoginToken
    @ResponseBody
    @RequestMapping(value="/deleteAdmin")
    public boolean deleteAdmin(@RequestBody Map<String,String> params){
        String uuid=params.get("uuid");
        return adminService.deleteAdmin(uuid);
    }

    @ResponseBody
    @PostMapping("/login")
    public String login(@RequestBody Map<String,String> params){
        String adminName = params.get("adminName");
        String userName = params.get("userName");
        String password = params.get("password");
        JSONObject jsonObject=new JSONObject();
        try {
            if(adminName!=null) {
                Admin admin = adminService.queryAdminByParams(null, adminName, password, null, null, null, null, null, null).get(0);
                String token = tokenService.getToken(admin);
                jsonObject.put("loginUser", JSONObject.toJSON(admin));
                jsonObject.put("token", JSONObject.toJSON(token));
                return jsonObject.toJSONString();
            }else{
                User user=userService.queryUserByParams(null,userName,null,password,null,null,null).get(0);
                String token = tokenService.getUserToken(user);
                jsonObject.put("loginUser", JSONObject.toJSON(user));
                jsonObject.put("token", JSONObject.toJSON(token));
                return jsonObject.toJSONString();
            }
        }catch (IndexOutOfBoundsException e){
            jsonObject.put("error","用户名或密码错误!");
            return jsonObject.toJSONString();
        }
    }
}
