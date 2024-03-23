package com.seabooks.controller;

import com.seabooks.common.Result;
import com.seabooks.entity.Administrator;
import com.seabooks.entity.Users;
import com.seabooks.mapper.AdministratorMapper;
import com.seabooks.mapper.UserMapper;
import com.seabooks.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.seabooks.utils.TokenUtils;

/**
 * @author 14745
 * @date 2024/3/18 16:27
 */
@RestController
@RequestMapping("/Administrators")
@CrossOrigin() // 解决跨域，放通所有端口
public class AdministratorController {
    @Autowired
    private UserMapper userMapper;

//    管理员登录
    @PostMapping("/adminLogin")
    public Result<Administrator> getAdministratorLogin(@RequestBody Administrator administrator){
        System.out.println(administrator);
        Administrator admin = userMapper.AdminByEmailAndPwd(administrator);
        if (admin != null) {
//            这里传入id和密码生成
            admin.setToken(TokenUtils.createToken(String.valueOf(admin.getAdministratorId()), admin.getAdministratorPwd()));
            System.out.println();
            return new Result<>("登录成功!", admin);
        } else {
            return new Result<>(Result.FILE, "账号密码错误!");
        }
    }
}
