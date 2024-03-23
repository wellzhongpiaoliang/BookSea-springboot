package com.seabooks.mapper;

import com.seabooks.entity.Movies;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MoviesMapper {
    @Select("select * from movies")
    List<Movies> MoviesList();
    @Delete("delete from movies where id=#{id}")
    Integer DeleteMovies(Long id);
    @Update("update movies set title=#{title},director=#{director},actors=#{actors},genr=#{genr},duration=#{duration} where id=#{id}")
    void UpdateMovies(Movies movies);
    @Insert("insert into movies values (null,#{title},#{director},#{actors},#{genr},#{duration})")
    void AddMovies(Movies movies);
}
