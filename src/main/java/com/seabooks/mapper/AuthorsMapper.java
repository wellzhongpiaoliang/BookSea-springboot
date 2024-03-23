package com.seabooks.mapper;

import com.seabooks.entity.Authors;
import com.seabooks.entity.Authorsfans;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 14745
 * @date 2023/12/1 21:58
 */
@Mapper
public interface AuthorsMapper {
//    作者
    Authors selectById(int id);

//    根据作者名查询作者
    List<Authors> selectByName(Authors name);
//    获取作者粉丝
    List<Authorsfans> selectByAuthorsFansId(int id);
}
