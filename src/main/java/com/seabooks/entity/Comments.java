package com.seabooks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comments {

  private Integer commentsId;  // 评论id commentsId
  private Integer userId; // 评论者id
  private String commentsText; // 评论内容
  private String commentsTime; // 评论时间
  private String commentsState; // 评论状态
  private Integer commentsScore; // 评分

}
