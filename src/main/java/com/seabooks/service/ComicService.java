package com.seabooks.service;

import com.seabooks.entity.Comic;

import java.util.List;

public interface ComicService {
    List<Comic> GetComicList();

    Comic GetComic(Integer id);

    List<Comic> GetComicRecommend();
}
