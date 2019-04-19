package com.hyc.onlineBookManagement.service;

import com.hyc.onlineBookManagement.bean.Admin;

public interface TokenService {
    public String getToken(Admin admin);
}
