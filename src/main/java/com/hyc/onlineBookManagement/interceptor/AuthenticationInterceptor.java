package com.hyc.onlineBookManagement.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.hyc.onlineBookManagement.annotation.LoginToken;
import com.hyc.onlineBookManagement.annotation.PassToken;
import com.hyc.onlineBookManagement.bean.Admin;
import com.hyc.onlineBookManagement.bean.User;
import com.hyc.onlineBookManagement.service.AdminService;
import com.hyc.onlineBookManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;

public class AuthenticationInterceptor implements HandlerInterceptor{
    @Autowired
    AdminService adminService;
    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        System.out.println("token;"+token);
        // 如果不是映射到方法直接通过
        if(!(object instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod)object;
        Method method=handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        if(method.isAnnotationPresent(LoginToken.class)){
            LoginToken loginToken=method.getAnnotation(LoginToken.class);
            if(loginToken.required()){
                if(token==null){
                    throw new RuntimeException("无token,请重新登录");
                }
                // 获取token中的登录id
                String loginId;
                try {
                    loginId= JWT.decode(token).getAudience().get(0);
                    System.out.println("loginId:"+loginId);
                }catch (JWTDecodeException j){
                    throw new RuntimeException("401");
                }
                List<Admin> admin=adminService.queryAdminByParams(null,loginId,null,null,null,null,null,null,null);
                List<User> user=userService.queryUserByParams(null,loginId,null,null,null,null,null);
                if(admin.size()==0 && user.size()==0){
                    throw new RuntimeException("用户不存在，请重新登录!");
                }

                // 验证 token
                if(admin.size()>0) {
                    JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(admin.get(0).getPassword())).build();
                    try {
                        jwtVerifier.verify(token);
                    } catch (JWTDecodeException e) {
                        throw new RuntimeException("401");
                    }
                }else{
                    JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.get(0).getPassword())).build();
                    try {
                        jwtVerifier.verify(token);
                    } catch (JWTDecodeException e) {
                        throw new RuntimeException("401");
                    }
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
