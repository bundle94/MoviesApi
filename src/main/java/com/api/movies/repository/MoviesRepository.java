package com.api.movies.repository;

import com.api.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends JpaRepository<Movie, Integer> {
    @Query("select m from Movie m where m.popular = true")
    List<Movie> getPopularMovies();
}
