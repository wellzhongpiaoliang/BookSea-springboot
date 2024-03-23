package com.seabooks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topup {

  private Integer topupId; // 充值id
  private Integer userId; // 充值者id
  private double money; // 充值金额
  private String topupTime; // 充值时间
  private String succeed; // 充值状态


}
