package com.seabooks.mapper;

import com.seabooks.entity.Attachcomments;
import com.seabooks.entity.Books;
import com.seabooks.entity.Comments;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 14745
 * @date 2023/12/1 21:57
 */
@Mapper
public interface CommentsMapper {
//    根据书籍id获取评论
    List<Comments> selectByBookIdAndComments(int id);
//    根据用户id获取评论
    List<Comments> selectByUserIdAndComments(int id);
//    根据评论id获取书籍
    Books selectByIdAndBookId(int id);
//    添加评论
    int addComments(Comments comments);
//    添加评论附表
    int addAttComments(Attachcomments attachcomments);
//    获取最后一个评论的id
    Comments selectGetCommentsId();
}
