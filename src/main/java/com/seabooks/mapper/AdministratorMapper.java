package com.seabooks.mapper;

import com.seabooks.entity.Administrator;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 14745
 * @date 2024/3/18 16:21
 */
@Mapper
public interface AdministratorMapper {
//    管理员


//    查询用户id
    Administrator selectById(int name);

//    查询用户邮箱
    Administrator selectByEmail(Integer email);
}
