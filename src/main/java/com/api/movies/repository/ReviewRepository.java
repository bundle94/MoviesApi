package com.api.movies.repository;

import com.api.movies.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query(value="select r.review, r.movie_id, r.anonymous, u.full_name from review r join user u on u.id = r.user_id where r.movie_id = ?1", nativeQuery = true)
    List<Map<String, Object>> getAllMovieReviewsByMovieId(int movieId);
}
