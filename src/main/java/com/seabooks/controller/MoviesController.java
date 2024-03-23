package com.seabooks.controller;

import com.seabooks.entity.Movies;
import com.seabooks.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//RestController是ResponseBody和Controller的结合注释
//@ResponseBody是让返回的数据变为json格式,不会返回路径
//Controller标记这个类为控制器
@RequestMapping("/movies")
//RequestMapping是设置请求路径的注解
@CrossOrigin("*")
//CrossOrigin是将这个类启用跨域支持,括号内填写允许跨域访问的路径
public class MoviesController {
    @Autowired
    private MoviesService moviesService;
    @GetMapping
//    GetMapping是requestMapping(method = RequestMethod.GET)的结合注解,且可以不填写路径,不填写路径默认使用类上RequestMapping的路径(如果有)
    public List<Movies> MoviesList(){
        return moviesService.MoviesList();
    }
    @DeleteMapping
    public String DeleteMovies(Long id){
        Boolean b= moviesService.DeleteMovies(id);
        if(b){
            return "删除成功";
        }else{
            return "删除失败";
        }
    }
    @PutMapping

    public void UpdateMovies(@RequestBody Movies movies){
//        RequestBody表示这个参数是前端返回的json对象,spring会把前端的数据对象和后端的数据对象的属性名进行匹配,属性名一致的就将前端对象的值赋给后端
        moviesService.UpdateMovies(movies);
    }
    @PostMapping
    public void AddMovies(@RequestBody Movies movies){
        moviesService.AddMovies(movies);
    }

}
