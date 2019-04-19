package com.hyc.onlineBookManagement.dao;

import com.hyc.onlineBookManagement.bean.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDao {
    //根据条件动态查询管理员
    List<Admin> selectAdminByParams(@Param("uuid")String uuid,
                                    @Param("adminName")String adminName,
                                    @Param("password")String password,
                                    @Param("realName")String realName,
                                    @Param("sex")String sex,
                                    @Param("telephone")String telephone,
                                    @Param("email")String email,
                                    @Param("role")String role,
                                    @Param("roleName")String roleName);

    //分页查询管理员
    List<Admin> selectAdminByPage(@Param("startIndex")Integer startIndex,
                                  @Param("pageSize")Integer pageSize);

    //根据条件查询管理员数量
    int selectAdminCount(@Param("uuid")String uuid,
                         @Param("adminName")String adminName,
                         @Param("password")String password,
                         @Param("realName")String realName,
                         @Param("sex")String sex,
                         @Param("telephone")String telephone,
                         @Param("email")String email,
                         @Param("role")String role,
                         @Param("roleName")String roleName);

    //根据条件分页模糊查询管理员
    List<Admin> seletAdminByFuzzyAndPage(@Param("uuid")String uuid,
                                         @Param("adminName")String adminName,
                                         @Param("password")String password,
                                         @Param("realName")String realName,
                                         @Param("sex")String sex,
                                         @Param("telephone")String telephone,
                                         @Param("email")String email,
                                         @Param("role")String role,
                                         @Param("roleName")String roleName,
                                         @Param("startIndex")Integer startIndex,
                                         @Param("pageSize")Integer pageSize);

    //插入管理员
    int insertAdmin(Admin admin);

    //更新管理员信息
    int updateAdmin(@Param("uuid")String uuid,
                    @Param("adminName")String adminName,
                    @Param("password")String password,
                    @Param("realName")String realName,
                    @Param("sex")String sex,
                    @Param("telephone")String telephone,
                    @Param("email")String email,
                    @Param("role")String role,
                    @Param("roleName")String roleName);

    //根据uuid删除管理员
    int deleteAdmin(@Param("uuid")String uuid);
}