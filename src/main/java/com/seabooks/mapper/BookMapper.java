package com.seabooks.mapper;

import com.seabooks.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.awt.print.Book;
import java.util.List;

/**
 * @author 14745
 * @date 2023/11/23 8:34
 */
@Mapper
public interface BookMapper {
//    查询全部书籍
    List<Books> showBooks();
//    根据书名查询书籍
    List<Books> selectByName(String bookName);
//    根据书的出版时间排序书籍
    List<Books> selectByBooksDate();
//    根据分类标签查询书籍
    List<Books> selectByCategory(String name);
//    根据书籍获取标签
    Categories selectByBookIdAndCategories(int id);
//    获取主编力荐
    List<Books> selectByPublishers();
//    书籍阅读量增加
    int upBookRead(int id);
//    根据id查询书籍
    Books selectById(int id);
//    根据isbn查询
    Books selectByIsbn(String isbn);
//    动态查询
    List<Books> selectParams(Books books);
//    收藏的书籍查询
    List<Books> selectByBookIdAndUserId(Users users);
//    添加收藏书籍
    int addCollectBook(Usercollectbook usercollectbook);
//    删除收藏书籍
    int delCollectBook(Books books);
//    浏览过的书
    List<Books> selectByReadAndUserId(Users users);
//    添加浏览过的书
    int addReadBook(Userhistorybook userhistorybook);
//    删除浏览过的书
    int delReadBook(Books books);
}
