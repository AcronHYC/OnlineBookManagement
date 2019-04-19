package com.hyc.onlineBookManagement.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.hyc.onlineBookManagement.bean.Admin;
import com.hyc.onlineBookManagement.service.TokenService;
import org.springframework.stereotype.Service;

@Service("TokenService")
public class TokenServiceImpl implements TokenService {
    public String getToken(Admin admin) {
        String token="";
        token= JWT.create().withAudience(admin.getAdminName())// 将 id 保存到 token 里面
                .sign(Algorithm.HMAC256(admin.getPassword()));// 以 password 作为 token 的密钥
        return token;
    }
}
