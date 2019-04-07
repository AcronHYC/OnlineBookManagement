package com.hyc.onlineBookManagement.service;

import com.hyc.onlineBookManagement.bean.Admin;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdminService {
    List<Admin> queryAdminByParams(String uuid,
                                   String adminName,
                                   String password,
                                   String realName,
                                   String sex,
                                   String telephone,
                                   String email,
                                   String role);

    String queryAdminByPage(Integer pageSize,Integer page);

    String queryAdminByFuzzyAndPage(String uuid,
                                    String adminName,
                                    String password,
                                    String realName,
                                    String sex,
                                    String telephone,
                                    String email,
                                    String role,
                                    Integer pageSize,
                                    Integer page);
}
