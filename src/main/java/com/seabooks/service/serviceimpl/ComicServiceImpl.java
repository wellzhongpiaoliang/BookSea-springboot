package com.seabooks.service.serviceimpl;

import com.seabooks.entity.Comic;
import com.seabooks.mapper.ComicMapper;
import com.seabooks.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicServiceImpl implements ComicService {
    @Autowired
    private ComicMapper comicMapper;


    @Override
    public List<Comic> GetComicList() {
        List<Comic> comics = comicMapper.GetComicList();
        return comics;
    }

    @Override
    public Comic GetComic(Integer id) {
        Comic comic = comicMapper.GetComic(id);
        return comic;
    }

    @Override
    public List<Comic> GetComicRecommend() {
        List<Comic> comics = comicMapper.GetComicList2();
        return comics;
    }
}
