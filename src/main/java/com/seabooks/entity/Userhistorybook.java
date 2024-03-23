package com.seabooks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Userhistorybook {

  private Integer userId; //  用户id
  private Integer bookId; // 用户历史阅读的书的id

}
