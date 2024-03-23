package com.seabooks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attachcomments {
  // 评论附表实体类
  private Integer bookId; // 书籍id
  private Integer commentsId; // 评论id

}
