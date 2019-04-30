package com.hyc.onlineBookManagement.service;

import com.hyc.onlineBookManagement.bean.Admin;
import com.hyc.onlineBookManagement.bean.User;

public interface TokenService {
    public String getToken(Admin admin);

    public String getUserToken(User user);
}
