package com.seabooks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

  private Integer ordersId; // 订单id
  private Integer userId; // 下单者的id
  private Integer bookId; // 下单书的id
  private String ordersDate; // 创建日期
  private double ordersPrice; // 总价格
  private String alipay; // 支付方式
  private String address; // 配送地址
  private String ordersStatus; // 支付状态
  private String productList; // 商品列表
  private double ordersMoney; // 支付金额
  private String modeDistribution; // 配送方式
  private String remark; // 备注信息
  private String updateTime; // 更新时间
  private Integer goodsNum; // 下单数量



}
