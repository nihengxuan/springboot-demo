package com.sdjzu.group.utils;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.sdjzu.group.domain.User;
import com.sdjzu.group.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Date;

public class TokenUtils {
    @Autowired
    private UserMapper userMapper;
    private static UserMapper staticUserMapper;

    @PostConstruct
    public void init(){
        staticUserMapper = userMapper;
    }
    /**
     * 生成token
     */
    public static String genToken(User user){
        String sign = JWT.create()
                .withExpiresAt(DateUtil.offsetDay(new Date(), 1))
                .withAudience(user.getId().toString())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return sign;
    }
}
