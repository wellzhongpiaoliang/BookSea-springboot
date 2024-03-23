package com.seabooks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usercollectbook {

  private Integer userId;//  用户收藏的书id
  private Integer bookId; // 用户id

}
