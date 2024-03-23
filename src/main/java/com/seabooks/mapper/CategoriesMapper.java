package com.seabooks.mapper;

import com.seabooks.entity.Categories;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 14745
 * @date 2023/12/1 21:59
 */
@Mapper
public interface CategoriesMapper {
    //    根据id分类名
    Categories selectById(int id);

    //    根据分类名
    Categories selectByName(Categories categories);
}
