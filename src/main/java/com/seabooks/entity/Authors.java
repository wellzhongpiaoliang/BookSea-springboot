package com.seabooks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Authors {
//作者实体类
  private Integer authorsId; // 作者id
  private String authorsName; // 作者姓名
  private String authorsGender; // 作者性别
  private String authorsBirthday; // 作者出生日期
  private String authorsNationality; //  作者国籍
  private String authorsOccupation; // 作者身份(职业)
  private String authorsImg;  // 作者头像
}
