package com.seabooks.mapper;

import com.seabooks.entity.Comic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ComicMapper {
    @Select("select * from comic")
    List<Comic> GetComicList();

    @Select("select * from comic where comic_id=#{id}")
    Comic GetComic(Integer id);
    /*
    * 模糊查询
    * */
    @Select("select * from comic limit 5")
    List<Comic> GetComicList2();

}
