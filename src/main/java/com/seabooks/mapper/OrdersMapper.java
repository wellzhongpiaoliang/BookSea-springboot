package com.seabooks.mapper;

import com.seabooks.entity.Books;
import com.seabooks.entity.Orders;
import com.seabooks.entity.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 14745
 * @date 2023/12/1 21:54
 */
@Mapper
public interface OrdersMapper {
//    根据订单id查询订单
    Orders selectById(int id);
//    根据下单用户id查询订单列表
    List<Orders> selectByUserIdAndOrder(int id);
//    根据下单id查询下单书籍
    Books selectByOrderIdAndBooks(int id);
//    根据订单id查询下单用户
    Users selectByOrderIdAndUser(int id);
//    根据订单id查询用户

//    下单
    int addOrder(Orders orders);
//    确认收货,退货,取消订单
    int delOrder(int id);
}
