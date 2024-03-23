package com.seabooks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Authorsbook {
// 作者 出过的书实体类
  private Integer authorsId; // 作者id
  private Integer bookId; // 作者出过的书id

}
