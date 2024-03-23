package com.seabooks.service.serviceimpl;

import com.seabooks.entity.Movies;
import com.seabooks.mapper.MoviesMapper;
import com.seabooks.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesServiceImpl implements MoviesService {
    @Autowired
    private MoviesMapper moviesMapper;
    @Override
    public List<Movies> MoviesList() {
        List<Movies> movies = moviesMapper.MoviesList();
        return movies;

    }

    @Override
    public Boolean DeleteMovies(Long id) {
       Integer i= moviesMapper.DeleteMovies(id);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void UpdateMovies(Movies movies) {
        moviesMapper.UpdateMovies(movies);
    }

    @Override
    public void AddMovies(Movies movies) {
        moviesMapper.AddMovies(movies);
    }
}
