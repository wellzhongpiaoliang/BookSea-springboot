package com.seabooks.service;


import com.seabooks.entity.Movies;

import java.util.List;

public interface MoviesService {
    List<Movies> MoviesList();

    Boolean DeleteMovies(Long id);

    void UpdateMovies(Movies movies);

    void AddMovies(Movies movies);
}
