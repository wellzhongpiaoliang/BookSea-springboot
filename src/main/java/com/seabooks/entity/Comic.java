package com.seabooks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comic {

  private long comicId; // 漫画id
  private String comicName; // 漫画名
  private String comicType; // 漫画种类
  private String comicStyle; //
  private String comicImgs; // 漫画图片路径
  private String updateTime; // 修改时间
  private String updateQuantity; //
  private String introduction; //
  private String press; // 价格
}
