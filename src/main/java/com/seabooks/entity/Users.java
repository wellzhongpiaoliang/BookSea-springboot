package com.seabooks.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users implements Serializable {
  private static final long serialVersionUID = 1L;
  private Integer userId;// 用户id
  private String userName;//用户昵称
  private String userPassword; // 用户密码
  private String userSignature;//用户签名
  private String userGender;//用户性别
  private String userImg;// 用户头像链接
  private String userEmail;// 用户邮箱
  private String userPhone;// 用户手机号
  private String userCreatedat;// 用户账号创建时间
  private String userUpdatedat; // 用户修改信息的时间
  private String userStatus;// 用户状态: 锁定,激活
  private Integer userRole; // 用户权限: 管理员,普通账号,会员
  private String userOuttime;// 用户最后一次登录时间
  private Integer userMoney;// 用户的money
  // 新增token字段,并表示这个字段在数据库中不存在,不加这个注解会报SQL异常
  @TableField(exist = false)
  private String token;
}
