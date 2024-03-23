package com.seabooks.mapper;

import com.seabooks.entity.Tags;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 14745
 * @date 2023/11/23 13:00
 */

@Mapper
public interface TagsMapper {
//    标签
    List<Tags> showTags();
    Tags selectById(int id);
}
