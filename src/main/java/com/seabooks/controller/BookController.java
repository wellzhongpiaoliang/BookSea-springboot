package com.seabooks.controller;

import com.seabooks.entity.*;
import com.seabooks.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 14745
 * @date 2023/11/23 19:40
 */

@RestController
@RequestMapping("/book")
@CrossOrigin() // 解决跨域，放通所有端口
public class BookController {

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CommentsMapper commentsMapper;
    @Autowired
    private AuthorsMapper authorsMapper;
    @Autowired
    private OrdersMapper ordersMapper;

    //    获取新书
    @GetMapping("/newBook")
    public List<Books> NewBooks() {
        return bookMapper.selectByBooksDate();
    }

    //    主编力荐
    @GetMapping("/getPublishers")
    public List<Books> getPublishers() {
        return bookMapper.selectByPublishers();
    }

    //    书籍详情
    @GetMapping("/getBookDetails")
//    加了@RequestBody 对方传过来的数据必须是对象
    public Books getBookDetails(Integer bookId) {
        Books books = bookMapper.selectById(bookId);
        System.out.println("查询的书籍" + books);
        return books;
    }

    //    评论
    @GetMapping("/getBookDetailsAndComments")
    public List<Comments> getBookDetailsAndComments(Integer id) {
        return commentsMapper.selectByBookIdAndComments(id);
    }

    //    根据书名获取书籍
    @GetMapping("/getBookNameAndBook")
    public List<Books> getBookNameAndBook(String bookName) {
        return bookMapper.selectByName(bookName);
    }

    //    通过评论id获取书籍
    @GetMapping("/getCommentsIdAndBook")
    public Books getCommentsIdAndBook(Integer id) {
        return commentsMapper.selectByIdAndBookId(id);
    }

    //    获取分类
    @GetMapping("/getByBookIdAndCategories")
    public Categories getByBookIdAndCategories(Integer id) {
        return bookMapper.selectByBookIdAndCategories(id);
    }

    //    获取作者
    @GetMapping("/getBookDetailsAndAuthors")
    public Authors getBookDetailsAndAuthors(Integer id) {
        return authorsMapper.selectById(id);
    }

    //    获取作者粉丝
    @GetMapping("/getBookByAuthorsFens")
    public List<Authorsfans> getBookByAuthorsFens(Integer id) {
        return authorsMapper.selectByAuthorsFansId(id);
    }

    //    主编力荐
    @GetMapping("/getByPublishers")
    public List<Books> getByPublishers() {
        return bookMapper.selectByPublishers();
    }

    //    添加评论
    @PostMapping("/addComm")
    public int addComm(@RequestBody Comments comments1) {
        System.out.println("获取传过来的评论:" + comments1);
        System.out.println("获取传过来的书id:" + comments1.getCommentsId());
        Integer bookId = comments1.getCommentsId();
//        创建comment对象
        Comments comment = new Comments();
        Attachcomments attachcomments = new Attachcomments();
//        获取时间
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String time = formatter.format(date);
//        获取评论表最后的id
        Comments id = commentsMapper.selectGetCommentsId();
//        添加评论id,原理是最后的id+1
        attachcomments.setCommentsId(id.getCommentsId() + 1);
//        添加评论的书籍id
        attachcomments.setBookId(bookId);
//        添加评论数据
        comment.setCommentsId(id.getCommentsId() + 1);
        comment.setUserId(comments1.getUserId());
        comment.setCommentsText(comments1.getCommentsText());
        comment.setCommentsState("已审核");
        comment.setCommentsScore(comments1.getCommentsScore());
        comment.setCommentsTime(time);
//        评论持久化
        int i = commentsMapper.addComments(comment);
        System.out.println(i < 1 ? "失败" : "成功");
//        评论添加成功则将评论id添加到评论附表
        if (i == 1) {
            System.out.println("成功");
            int i1 = commentsMapper.addAttComments(attachcomments);
            System.out.println(i1);
        }
        return i;
    }

    //    书库
    @PostMapping("/getBookData")
    public List<Books> getBookData(@RequestBody Books book) {
        Books books = new Books();
        books.setBookRead(book.getBookRead());
        books.setBookCategory(book.getBookCategory());
        books.setBookEnd(book.getBookEnd());
        books.setBookNum(book.getBookNum());
        return bookMapper.selectParams(books);
    }

    //    收藏的书添加
    @PostMapping("/addCollectBook")
    public String addCollectBook(@RequestBody Usercollectbook usercollectbook) {
        int i = bookMapper.addCollectBook(usercollectbook);
        String msg = null;
        if (i == 0) {
            msg = "添加失败";
            return msg;
        }
        msg = "添加成功";
        return msg;
    }

    //    收藏的书删除
    @PostMapping("/delCollectBook")
    public String delCollectBook(@RequestBody Usercollectbook usercollectbook) {
        Books books = new Books();
        books.setBookId(usercollectbook.getBookId());
        int i = bookMapper.delCollectBook(books);
        String msg = null;
        if (i == 0) {
            msg = "删除失败";
            return msg;
        }
        msg = "删除成功";
        return msg;
    }

    //    收藏的书查询
    @PostMapping("/getCollectBook")
    public List<Books> getCollectBook(@RequestBody Usercollectbook usercollectbook) {
        Users users = new Users();
        users.setUserId(usercollectbook.getUserId());
        List<Books> books = bookMapper.selectByBookIdAndUserId(users);
        books.forEach(System.out::println);
        return books;
    }

    //    浏览的书查询
    @PostMapping("/getReadBook")
    public List<Books> getReadBook(@RequestBody Userhistorybook userhistorybook) {
        System.out.println("收藏1:" + userhistorybook);
        Users users = new Users();
        users.setUserId(userhistorybook.getUserId());
        List<Books> books = bookMapper.selectByReadAndUserId(users);
        books.forEach(System.out::println);
        return books;
    }

    //    浏览过的书添加
    @PostMapping("/addReadBook")
    public String addReadBook(@RequestBody Userhistorybook userhistorybook) {
        System.out.println("收藏:" + userhistorybook);
        int i = bookMapper.addReadBook(userhistorybook);
        int i1 = bookMapper.upBookRead(userhistorybook.getBookId());
        String msg = null;
        if (i == 0) {
            msg = "添加失败";
            return msg;
        }
        msg = "添加成功";
        return msg;
    }

    //    浏览过的书删除
    @PostMapping("/delReadBook")
    public String delReadBook(@RequestBody Userhistorybook userhistorybook) {
        System.out.println("收藏:" + userhistorybook);
        Books books = new Books();
        books.setBookId(userhistorybook.getBookId());
        int i = bookMapper.delReadBook(books);
        String msg = null;
        if (i == 0) {
            msg = "删除失败";
            return msg;
        }
        msg = "删除成功";
        return msg;
    }

//    增加订单
    @PostMapping("/addOrders")
    public String AddOrders(@RequestBody Orders orders){
        System.out.println("传入订单:"+orders);
        Orders orders1 = new Orders();
        orders1 = orders;
        orders1.setOrdersStatus("已支付");
        System.out.println("orders1:"+orders1);
        int i = ordersMapper.addOrder(orders1);
        String msg = null;
        if (i == 0){
            msg = "下单失败";
            return msg;
        }
        msg = "下单成功";
        return msg;
    }

    //    根据订单id查询书籍
    @PostMapping("/selectByOrderIdAndBooks")
    public Books selectByOrderIdAndBooks(@RequestBody Orders orders){
        return ordersMapper.selectByOrderIdAndBooks(orders.getOrdersId());
    }
}
