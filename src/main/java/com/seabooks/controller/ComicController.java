package com.seabooks.controller;

import com.seabooks.entity.Comic;
import com.seabooks.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comic")
@CrossOrigin
public class ComicController {
//    这个控制器是组员开发的漫画板块的数据
    @Autowired
    private ComicService comicService;

    @GetMapping
    public List<Comic> GetComicList(){
        return comicService.GetComicList();
    }

    @GetMapping("info")
    public Comic GetComic(Integer id){
        return comicService.GetComic(id);
    }

    @GetMapping("/recommend")
    public List<Comic> GetComicRecommend(){
        return comicService.GetComicRecommend();
    }
}
