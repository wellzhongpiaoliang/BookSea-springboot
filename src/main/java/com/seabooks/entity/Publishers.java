package com.seabooks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publishers {

  private Integer publishersId; // 出版id
  private String publishersName; //出版社名
  private String publishersAddress; // 出版社地址
  private String publishersPhone;// 出版社电话
  private String publishersUrl; // 出版社网址
  private String publishersType;// 出版社类型
  private String createTime;// 出版社成立时间
  private Integer publishersSales; // 出版社销量
  private Integer publishersScore; // 出版社评分

}
