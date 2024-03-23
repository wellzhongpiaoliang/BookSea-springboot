package com.seabooks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categories {

  private Integer categoriesId; // 分类id
  private String categoriesName; //  分类名
  private String categoriesDescribe;// 分裂描述

}
