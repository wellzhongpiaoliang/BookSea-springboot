package com.seabooks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publishersbook {

  private Integer publishersId; // 出版社id
  private Integer bookId; // 出版社出过的书id

}
