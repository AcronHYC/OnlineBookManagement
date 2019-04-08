package com.hyc.onlineBookManagement.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.hyc.onlineBookManagement.bean.Admin;
import com.hyc.onlineBookManagement.bean.Page;
import com.hyc.onlineBookManagement.dao.AdminDao;
import com.hyc.onlineBookManagement.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service(value = "adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;

    @Override
    public List<Admin> queryAdminByParams(String uuid,
                                          String adminName,
                                          String password,
                                          String realName,
                                          String sex,
                                          String telephone,
                                          String email,
                                          String role,
                                          String roleName){
        return adminDao.selectAdminByParams(uuid,adminName,password,realName,sex,telephone,email,role,roleName);
    }

    @Override
    public String queryAdminByPage(Integer pageSize,Integer page){
        int total=adminDao.selectAdminCount(null,null,null,null,null,null,null,null,null);
        List<Admin> adminList=new ArrayList<Admin>();
        JSONObject jsonObject=new JSONObject();
        Page pageObject=null;
        if(page!=null){
            pageObject=new Page(page,pageSize,total);
            adminList=adminDao.selectAdminByPage(pageObject.getStartIndex(),pageSize);
            jsonObject.put("jsonAdminList",JSONObject.toJSON(adminList));
            jsonObject.put("pagination",JSONObject.toJSON(pageObject));
            return jsonObject.toJSONString();
        }else{
            pageObject=new Page(1,10,total);
            adminList=adminDao.selectAdminByPage(pageObject.getStartIndex(),pageObject.getPageSize());
            jsonObject.put("jsonAdminList",JSONObject.toJSON(adminList));
            jsonObject.put("pagination",JSONObject.toJSON(pageObject));
            return jsonObject.toJSONString();
        }
    }

    @Override
    public String queryAdminByFuzzyAndPage(String uuid,
                                           String adminName,
                                           String password,
                                           String realName,
                                           String sex,
                                           String telephone,
                                           String email,
                                           String role,
                                           String roleName,
                                           Integer pageSize,
                                           Integer page){
        int total=adminDao.selectAdminCount(uuid,adminName,password,realName,sex,telephone,email,role,roleName);
        List<Admin> adminList=new ArrayList<Admin>();
        JSONObject jsonObject=new JSONObject();
        Page pageObject=null;
        if(page!=null){
            pageObject=new Page(page,pageSize,total);
            adminList=adminDao.seletAdminByFuzzyAndPage(uuid,adminName,password,realName,sex,telephone,email,role,roleName,pageObject.getStartIndex(),pageSize);
            jsonObject.put("jsonAdminList",JSONObject.toJSON(adminList));
            jsonObject.put("pagination",JSONObject.toJSON(pageObject));
            return jsonObject.toJSONString();
        }else{
            pageObject=new Page(1,10,total);
            adminList=adminDao.seletAdminByFuzzyAndPage(uuid,adminName,password,realName,sex,telephone,email,role,roleName,pageObject.getStartIndex(),pageObject.getPageSize());
            jsonObject.put("jsonAdminList",JSONObject.toJSON(adminList));
            jsonObject.put("pagination",JSONObject.toJSON(pageObject));
            return jsonObject.toJSONString();
        }
    }

    @Override
    public boolean addAdmin(Admin admin){
        boolean flag=false;
        try {
            adminDao.insertAdmin(admin);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
