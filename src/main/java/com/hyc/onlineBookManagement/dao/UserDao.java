package com.hyc.onlineBookManagement.dao;

import com.hyc.onlineBookManagement.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    //根据条件动态查询读者
    List<User> selectUserByParams(@Param("id")String id,
                                  @Param("userName")String userName,
                                  @Param("realName")String realName,
                                  @Param("password")String password,
                                  @Param("IDcard")String IDcard,
                                  @Param("telephone")String telephone,
                                  @Param("email")String email);

    //根据条件动态查询读者数量
    int selectUserCount(@Param("id")String id,
                        @Param("userName")String userName,
                        @Param("realName")String realName,
                        @Param("password")String password,
                        @Param("IDcard")String IDcard,
                        @Param("telephone")String telephone,
                        @Param("email")String email);

    //分页模糊查询读者信息
    List<User> selectUserByFuzzyAndPage(@Param("id")String id,
                                       @Param("userName")String userName,
                                       @Param("realName")String realName,
                                       @Param("password")String password,
                                       @Param("IDcard")String IDcard,
                                       @Param("telephone")String telephone,
                                       @Param("email")String email,
                                       @Param("startIndex")Integer startIndex,
                                       @Param("pageSize")Integer pageSize);

    //插入读者信息
    int insertUser(User user);

    //更新读者信息
    int updateUser(@Param("id")String id,
                   @Param("userName")String userName,
                   @Param("realName")String realName,
                   @Param("password")String password,
                   @Param("IDcard")String IDcard,
                   @Param("telephone")String telephone,
                   @Param("email")String email);

    //查询借书最多的十位读者的借书数量
    List<User> selectUserBorrowCount();
}
