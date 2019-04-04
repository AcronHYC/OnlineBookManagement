package com.hyc.onlineBookManagement.dao;

import com.hyc.onlineBookManagement.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    List<User> selectUserByParams(@Param("id")String id,
                                  @Param("userName")String userName,
                                  @Param("realName")String realName,
                                  @Param("password")String password,
                                  @Param("IDcard")String IDcard,
                                  @Param("telephone")String telephone,
                                  @Param("email")String email);

    int insertUser(User user);

    int updateUser(@Param("id")String id,
                   @Param("userName")String userName,
                   @Param("realName")String realName,
                   @Param("password")String password,
                   @Param("IDcard")String IDcard,
                   @Param("telephone")String telephone,
                   @Param("email")String email);
}
