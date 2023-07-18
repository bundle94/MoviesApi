package com.api.movies.service;

import com.api.movies.model.Movie;
import com.api.movies.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesServices {
    @Autowired
    private MoviesRepository moviesRepository;


    public List<Movie> getAll() {
        return moviesRepository.findAll();
    }
    public List<Movie> getPopularMovies() {
        return moviesRepository.getPopularMovies();
    }
}
