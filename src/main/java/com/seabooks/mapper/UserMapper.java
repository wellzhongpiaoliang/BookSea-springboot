package com.seabooks.mapper;

import com.seabooks.entity.Administrator;
import com.seabooks.entity.Authors;
import com.seabooks.entity.Topup;
import com.seabooks.entity.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 14745
 * @date 2023/12/1 19:57
 */
@Mapper
public interface UserMapper {
//    查询全部数据
    List<Users> showUsers();
//    根据用户名查询用户
    List<Users> selectByName(String name);
//    根据作者名查询作者
    List<Authors> selectByAutName(String name);
//    用户
    Users selectById(int id);
//    查询用户邮箱
    Users selectByEmail(String userEmail);
//    管理员登录
    Administrator AdminByEmailAndPwd(Administrator name);
//    根据 id 密码查询用户
    Users selectByIdAndPwd(Users user);
//    根据邮箱号,密码查询
    Users selectByEmailAndPwd(Users user);
//    用户修改
    int UpdateUser(Users user);
//    用户添加
    int AddUser(Users user);
//    用户注销
    int DelUser(int id);
//    修改密码
    int UpdatePwd(Users users);
//    充值
    int addMoney(Users users);
//    消费
    int delMoney(Users users);
//    充值记录添加
    int addTopUp(Topup topup);
//    充值记录查询
    List<Topup> selectTopUp(int id);
}
