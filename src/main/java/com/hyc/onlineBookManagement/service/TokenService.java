package com.hyc.onlineBookManagement.service;

import com.hyc.onlineBookManagement.bean.Admin;
import com.hyc.onlineBookManagement.bean.User;

import java.util.Date;

public interface TokenService {
    public String getToken(Admin admin,Date expiredTime);

    public String getUserToken(User user,Date expiredTime);
}
