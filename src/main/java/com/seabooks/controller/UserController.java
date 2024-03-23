package com.seabooks.controller;

import com.seabooks.common.Result;
import com.seabooks.entity.*;
import com.seabooks.mapper.BookMapper;
import com.seabooks.mapper.CommentsMapper;
import com.seabooks.mapper.OrdersMapper;
import com.seabooks.mapper.UserMapper;
import com.seabooks.utils.TokenUtils;
import lombok.val;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 14745
 * @date 2023/12/1 21:44
 */

@RestController
@RequestMapping("/user")
@CrossOrigin()
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private CommentsMapper commentsMapper;

    // 登录接口
    @PostMapping("/login")
    // 接收前端传入的json数据,并转成User对象
    public Result<Users> login(@RequestBody Users user) {
// 从数据库进行比对
        System.out.println("获取的user:" + user);
        Users one = userMapper.selectByEmailAndPwd(user);
        if (one != null) {
//            这里传入id和密码生成
            one.setToken(TokenUtils.createToken(String.valueOf(one.getUserId()), one.getUserPassword()));
            System.out.println();
            return new Result<>("登录成功!", one);
        } else {
            return new Result<>(Result.FILE, "账号密码错误!");
        }
    }

    //    注册
    @PostMapping("/register")
    public String RegisterUser(@RequestBody Users user) {
        //        获取时间
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String time = formatter.format(date);
        Users users = new Users();
        users.setUserName(user.getUserName());
        users.setUserEmail(user.getUserEmail());
        users.setUserPassword(user.getUserPassword());
        // 注册默认头像
        users.setUserCreatedat(time);
//        默认头像位置
        users.setUserImg("http://localhost:8081/img/user/%E7%94%A8%E6%88%B7%E5%A4%B4%E5%83%8F.png");
        users.setUserStatus("正常");
        users.setUserRole(0);
        users.setUserMoney(0);
        int i = userMapper.AddUser(users);
        String msg = null;
        if (i == 0) {
            msg = "失败";
        } else {
            msg = "成功";
        }
        return msg;
    }

    //    根据用户id查询订单
    @PostMapping("/selectByUserIdAndOrder")
    public List<Orders> selectByUserIdAndOrder(@RequestBody Users users) {
        return ordersMapper.selectByUserIdAndOrder(users.getUserId());
    }

    //    用户修改
    @PostMapping("/update")
    public Users Update(@RequestBody Users user) {
        //        获取时间
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String time = formatter.format(date);
//        判断是否是修改用户信息
        if (user.getUserUpdatedat() == "1") {
            user.setUserUpdatedat(time);
        }
        int i = userMapper.UpdateUser(user);
        System.out.println(i);
        return userMapper.selectById(user.getUserId());
    }

    //    修改密码
    @PostMapping("/updatePwd")
    public String UpdatePwd(@RequestBody Users user) {
        System.out.println("传过来要修改的数据" + user);
        int i = userMapper.UpdatePwd(user);
        String msg = null;
        if (i == 0) {
            System.out.println("密码修改失败");
            msg = "修改失败";
            return msg;
        }

        System.out.println("密码修改成功");
        msg = "修改成功";
        return msg;
    }

    //    充值
    @PostMapping("/topUpMoney")
    public String topUpMoney(@RequestBody Users user) {
        //        获取时间
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String time = formatter.format(date);
        System.out.println("传过来的钱" + user);
        Users users = new Users();
        Topup topup = new Topup();
        topup.setUserId(user.getUserId());
        topup.setMoney(user.getUserMoney());
        topup.setTopupTime(time);
        topup.setSucceed("成功");
        users.setUserId(user.getUserId());
        users.setUserMoney(user.getUserMoney());
        String msg = null;
        int i = userMapper.addMoney(users);
        int i1 = userMapper.addTopUp(topup);
        if (i == 0) {
            msg = "充值失败";
            return msg;
        }
        msg = "充值成功";
        return msg;
    }

    //充值记录查询
    @GetMapping("/getTopUp")
    public List<Topup> getTopUp(Integer id) {
        return userMapper.selectTopUp(id);
    }

    //    订单id查询订单
    @GetMapping("/selectById")
    public Orders selectById(Integer id) {
        return ordersMapper.selectById(id);
    }

    //  根据邮箱查询用户
    @GetMapping("/getByEmailAndUser")
    public Users getByEmailAndUser(String email) {
        return userMapper.selectByEmail(email);
    }

    //    消费
    @PostMapping("/delMoney")
    public String delMoney(@RequestBody Users user) {
        System.out.println("消费过来的钱" + user);
        Users users1 = new Users();
        users1.setUserId(user.getUserId());
        users1.setUserMoney(user.getUserMoney());
        String msg = null;
        val i = userMapper.delMoney(users1);
        if (i == 0) {
            msg = "消费失败";
            return msg;
        }
        msg = "消费成功";
        return msg;
    }

    //    获取全部用户
    @GetMapping("/selectAll")
    public Result<List<Users>> selectAll() {
        List<Users> list = userMapper.showUsers();
        return new Result<>("请求成功!", list);
    }

    //    根据用户id获取用户
    @GetMapping("/getUser")
    public Users getUser(Integer id) {
        return userMapper.selectById(id);
    }

    //    根据用户名获取获取用户
    @GetMapping("/getUserNameAndUser")
    public List<Users> getUserNameAndUser(String name) {
        return userMapper.selectByName(name);
    }

    //    根据作者名获取获取作者
    @GetMapping("/getAutName")
    public List<Authors> getAutName(String name) {
        return userMapper.selectByAutName(name);
    }

    //    根据用户id获取评论
    @GetMapping("/getUserIdAndComments")
    public List<Comments> getUserIdAndComments(Integer id) {
        return commentsMapper.selectByUserIdAndComments(id);
    }

    //    下单
    @PostMapping("/addOrders")
    public String AddOrders(@RequestBody Orders orders) {
        Orders order = new Orders();
        order = orders;
        String msg = null;
        int i = ordersMapper.addOrder(order);
        if ((i == 0)) {
            msg = "下单失败";
            return msg;
        }
        msg = "下单成功";
        return msg;
    }

    //    确认收货
    @PostMapping("/delOrder")
    public String delOrder(@RequestBody Orders orders) {
        String msg = null;
        int i = ordersMapper.delOrder(orders.getOrdersId());
        if ((i == 0)) {
            msg = "收货失败";
            return msg;
        }
        msg = "收货成功";
        return msg;
    }

}
