package com.seabooks.mapper;

import com.seabooks.entity.Topup;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 14745
 * @date 2023/12/1 21:55
 */
@Mapper
public interface  TopupMapper {
//    充值
    Topup selectById(int id);
}
