package com.hyc.onlineBookManagement.service.impl;

import com.hyc.onlineBookManagement.bean.Admin;
import com.hyc.onlineBookManagement.dao.AdminDao;
import com.hyc.onlineBookManagement.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
                                          String role){
        return adminDao.selectAdminByParams(uuid,adminName,password,realName,sex,telephone,email,role);
    }
}
