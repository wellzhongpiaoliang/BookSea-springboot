package com.seabooks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tags {

  private Integer tagsId; // 标签id
  private String tagsName; // 标签名
  private String tagsDescribe; // 标签描述
  private String tagsCreatetime; // 标签创建时间
  private String tagsUpdatetime; // 更新时间

}
