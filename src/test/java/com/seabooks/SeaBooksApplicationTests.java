package com.seabooks;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seabooks.entity.*;
import com.seabooks.mapper.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class SeaBooksApplicationTests {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private TagsMapper tagsMapper;

    @Autowired
    private AuthorsMapper authorsMapper;

    @Autowired
    private CategoriesMapper categoriesMapper;

    @Autowired
    private CommentsMapper commentsMapper;

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private TopupMapper topupMapper;

    @Autowired
    private UserMapper userMapper;

//    测试查询
    @Test
    void contextLoads() {
//        分页第一步 确定页数和每页数量
        PageHelper.startPage(1,2);
        List<Books> books = bookMapper.showBooks();
        books.forEach(System.out::println);
//        Tags tags = tagsMapper.selectById(1001);
        Authors authors = authorsMapper.selectById(1001);
//        Categories categories = categoriesMapper.selectById(10002);
        List<Users> users = userMapper.showUsers();
//        分页第二步 将数据放入 PageInfo 进行分页
        PageInfo<Users> pageInfo = new PageInfo<>(users);

        System.out.println(pageInfo.getList());
    }

    //    测试查询
    @Test
    void contextLoads5() {
//        List<Users> users = userMapper.selectByName("三稚晚樱");
        List<Books> books = bookMapper.selectByName("呐喊");
        System.out.println(books);
    }

    //    测试查询
    @Test
    void contextLoads51() {
        Books books = commentsMapper.selectByIdAndBookId(10027);
        System.out.println(books);
    }

    //    测试动态查询
    @Test
    void contextLoads511() {
        Books books = new Books();
//        books.setBookRead(90000000);
//        books.setBookCategory(10010);
//        books.setBookEnd("已完结");
//        books.setBookNum(80);
        List<Books> books1 = bookMapper.selectParams(books);
//        将double的E去处
//        BigDecimal bg =new BigDecimal(这里放double类型);
        books1.forEach(System.out::println);
    }
//    测试添加
    @Test
    void contextLoads1() {
//        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String time = formatter.format(date);
        System.out.println(formatter.format(date));
        Users user = new Users();
        user.setUserName("超级炸弹王");
        user.setUserPassword("123456");
        user.setUserSignature("战神");
        user.setUserImg("没有");
        user.setUserEmail("801341432@qq.com"); // 不能重复
        user.setUserPhone("13048765673");
        user.setUserCreatedat(time);
        user.setUserUpdatedat(null);
        user.setUserStatus("正常");
        user.setUserRole(0);
        user.setUserOuttime(null);
        user.setUserMoney(0);
//        Users users = userMapper.selectById(1004);
        int i = userMapper.AddUser(user);
        System.out.println(i);
    }

//    测试修改
    @Test
    void contextLoads2() {
//        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");

//        获取时间
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String time = formatter.format(date);
        System.out.println(formatter.format(date));
        Users user = new Users();
        user.setUserId(1007);
        user.setUserName("钟漂亮");
//        Users users = userMapper.selectById(1004);
        int i = userMapper.UpdateUser(user);
        System.out.println(i);
    }

//  测试删除
    @Test
    void contextLoads3() {
        int i = userMapper.DelUser(1007);
        System.out.println(i);
    }

}
