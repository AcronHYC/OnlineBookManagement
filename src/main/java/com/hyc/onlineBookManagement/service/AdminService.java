package com.hyc.onlineBookManagement.service;

import com.hyc.onlineBookManagement.bean.Admin;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdminService {
    //接收控制器方法获取的参数，根据输入条件查询管理员
    List<Admin> queryAdminByParams(String uuid,
                                   String adminName,
                                   String password,
                                   String realName,
                                   String sex,
                                   String telephone,
                                   String email,
                                   String role,
                                   String roleName);

    //分页查询管理员
    String queryAdminByPage(Integer pageSize,Integer page);

    //分页模糊查询管理员
    String queryAdminByFuzzyAndPage(String uuid,
                                    String adminName,
                                    String password,
                                    String realName,
                                    String sex,
                                    String telephone,
                                    String email,
                                    String role,
                                    String roleName,
                                    Integer pageSize,
                                    Integer page);

    //添加新的管理员
    boolean addAdmin(Admin admin);

    //动态更新管理员信息
    boolean updateAdmin(String uuid,
                        String adminName,
                        String password,
                        String realName,
                        String sex,
                        String telephone,
                        String email,
                        String role,
                        String roleName);

    //根据UUID删除管理员
    boolean deleteAdmin(String uuid);
}
