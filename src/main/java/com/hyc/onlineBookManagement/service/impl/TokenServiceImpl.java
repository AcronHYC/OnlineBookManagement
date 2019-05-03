package com.hyc.onlineBookManagement.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.hyc.onlineBookManagement.bean.Admin;
import com.hyc.onlineBookManagement.bean.User;
import com.hyc.onlineBookManagement.service.TokenService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("TokenService")
public class TokenServiceImpl implements TokenService {
    @Override
    public String getToken(Admin admin,Date expiredTime) {
        String token="";
        token= JWT.create().withAudience(admin.getAdminName())// 将 id 保存到 token 里面
                .withExpiresAt(expiredTime)
                .sign(Algorithm.HMAC256(admin.getPassword()));// 以 password 作为 token 的密钥
        return token;
    }

    @Override
    public String getUserToken(User user,Date expiredTime){
        String token="";
        token= JWT.create().withAudience(user.getUserName())// 将 id 保存到 token 里面
                .withExpiresAt(expiredTime)
                .sign(Algorithm.HMAC256(user.getPassword()));// 以 password 作为 token 的密钥
        return token;
    }
}
