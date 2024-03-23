package com.seabooks.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.seabooks.entity.Users;
import com.seabooks.mapper.UserMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author 14745
 * @date 2023/12/4 22:16
 */

//  生成token
@Component
public class TokenUtils {
    private static UserMapper staticUserMapper;
    @Resource
    UserMapper userMapper;



    @PostConstruct
    public void setUserService() {
        staticUserMapper = userMapper;
    }

    /**
     * 生成token
     */
//    使用id和密码生成token
    public static String createToken(String userId, String password) {
        return JWT.create().withAudience(userId) // 将userId保存到token中,作为荷载
                .withExpiresAt(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000)) // 24小时后token过期
                .sign(Algorithm.HMAC256(password)); // 以password作为token的秘钥
    }

    /**
     * 获取当前登录的用户信息
     */
    public static Users getCurrentUser() {
        try {
            HttpServletRequest request = ((ServletRequestAttributes)
                    RequestContextHolder.getRequestAttributes()).getRequest();
            String token = request.getHeader("token");
            if (token != null) {
                String userEmail = JWT.decode(token).getAudience().get(0);
                return staticUserMapper.selectByEmail(userEmail);
            }
        } catch (JWTDecodeException | NumberFormatException e) {
            return null;
        }
        return null;
    }
}
