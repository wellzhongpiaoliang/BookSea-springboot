package com.seabooks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Userattention {

  private Integer authorsId; // 用户关注的作者的id
  private Integer userId; // 用户id

}
