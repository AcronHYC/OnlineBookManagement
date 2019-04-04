package com.hyc.onlineBookManagement.dao;

import com.hyc.onlineBookManagement.bean.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDao {
    List<Admin> selectAdminByParams(@Param("uuid")String uuid,
                                    @Param("adminName")String adminName,
                                    @Param("password")String password,
                                    @Param("realName")String realName,
                                    @Param("sex")String sex,
                                    @Param("telephone")String telephone,
                                    @Param("email")String email,
                                    @Param("role")String role);
}
