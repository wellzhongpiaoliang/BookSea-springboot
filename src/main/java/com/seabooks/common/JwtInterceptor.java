package com.seabooks.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.seabooks.entity.Administrator;
import com.seabooks.entity.Users;
import com.seabooks.exception.ServiceException;
import com.seabooks.mapper.AdministratorMapper;
import com.seabooks.mapper.UserMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 14745
 * @date 2023/12/4 22:06
 */

// 拦截请求是否携带token
public class JwtInterceptor implements HandlerInterceptor {
    @Resource
    private UserMapper userMapper;

    @Resource
    private AdministratorMapper administratorMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getMethod().equals("OPTIONS")) {
// 如果是OPTIONS请求，直接放行
            return true;
        }
// 获取header请求头里面为token的参数
        String token = request.getHeader("token");
// 如果为空,则尝试获取url中的token
        if (token == null) {
            token = request.getParameter("token");
        }
// 如果都没有,则拦截,并抛异常
        if (token == null) {
            throw new ServiceException("请登录");
        }
// 如果有,则进行解析
        Integer userId = 0;
        try {
// 该方法用于解析token,并获取token中存放的userEmail
//            userId = JWT.decode(token).getAudience().get(0);
//            解析userId
            userId = Integer.valueOf(JWT.decode(token).getAudience().get(0));
        } catch (JWTDecodeException e) {
// 若解析失败,则拦截并抛异常
            throw new ServiceException("请登录");
        }
// 根据token中的userId查询数据库
        System.out.println("查询到的:"+userId);
//        普通用户的登录SQL
        Users user = userMapper.selectById(userId);
//        管理员的登录SQL
        Administrator administrator = administratorMapper.selectById(userId);
//        如果两个查询都查不到数据则表示该用户不存在或未登录就请求
        if (user == null && administrator == null) {
//            提示
            throw new ServiceException("请登录");
        }
// 用户密码加签验证
        JWTVerifier build =
                JWT.require(Algorithm.HMAC256(user.getUserPassword())).build();
        try {
// 将数据库中根据id查询出来的password进行加签,然后与前端携带的token进行比对(防止前端编写假的token鱼目混珠)
            build.verify(token);
        } catch (JWTVerificationException e) {
            throw new ServiceException("请登录");
        }
// 若以上都通过,则放行请求
        return true;
    }
}