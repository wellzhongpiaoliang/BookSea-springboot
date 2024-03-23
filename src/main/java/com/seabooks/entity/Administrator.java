package com.seabooks.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Administrator implements Serializable {
//  管理员实体类
  private static final long serialVersionUID = 1L;
  private long administratorId;
  private String administratorName;
  private String administratorPwd;
  private long administratorGender;
  private String administratorEmail;
  private String administratorPhone;
  private String administratorCreatetime;
  private String administratorOuttime;
  private String administratorState;

  // 新增token字段,并表示这个字段在数据库中不存在,不加这个注解会报SQL异常
  @TableField(exist = false)
  private String token;
}
