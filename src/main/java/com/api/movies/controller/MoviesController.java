package com.api.movies.controller;

import com.api.movies.model.Movie;
import com.api.movies.service.MoviesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class MoviesController {

    private MoviesServices moviesServices;
    @Autowired
    public MoviesController(MoviesServices moviesServices) {
        this.moviesServices = moviesServices;
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Movie>> getMovies() {
        return ResponseEntity.ok(moviesServices.getAll());
    }

    @GetMapping(value = "/popularMovies")
    public ResponseEntity<List<Movie>> getPopularMovies() {
        return ResponseEntity.ok(moviesServices.getPopularMovies());
    }
}
