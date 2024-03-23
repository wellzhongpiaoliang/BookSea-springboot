package com.seabooks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Authorsfans {
// 关注实体类
  private Integer authorsId; // 作者id
  private Integer userId; // 关注作者的用户

}
